// Copyright (c) HashiCorp, Inc.
// SPDX-License-Identifier: MPL-2.0

package cloudfront_test

import (
	"context"
	"fmt"
	awstypes "github.com/aws/aws-sdk-go-v2/service/cloudfront/types"
	sdkacctest "github.com/hashicorp/terraform-plugin-testing/helper/acctest"
	"github.com/hashicorp/terraform-plugin-testing/helper/resource"
	"github.com/hashicorp/terraform-plugin-testing/terraform"
	"github.com/hashicorp/terraform-provider-aws/internal/conns"
	tfcloudfront "github.com/hashicorp/terraform-provider-aws/internal/service/cloudfront"
	"github.com/hashicorp/terraform-provider-aws/internal/tfresource"
	"testing"

	"github.com/hashicorp/terraform-provider-aws/internal/acctest"
	"github.com/hashicorp/terraform-provider-aws/names"
)

func TestAccCloudFrontVPCOrigin_basic(t *testing.T) {
	ctx := acctest.Context(t)
	var vpcOrigin awstypes.VpcOrigin
	rName := sdkacctest.RandomWithPrefix(acctest.ResourcePrefix)
	resourceName := "aws_cloudfront_vpc_origin.test"

	resource.ParallelTest(t, resource.TestCase{
		PreCheck:                 func() { acctest.PreCheck(ctx, t); acctest.PreCheckPartitionHasService(t, names.CloudFrontEndpointID) },
		ErrorCheck:               acctest.ErrorCheck(t, names.CloudFrontServiceID),
		ProtoV5ProviderFactories: acctest.ProtoV5ProviderFactories,
		CheckDestroy:             testAccCheckVPCOriginDestroy(ctx),
		Steps: []resource.TestStep{
			{
				Config: testAccVPCOriginConfig_basic(rName),
				Check: resource.ComposeTestCheckFunc(
					testAccCheckVPCOriginExists(ctx, resourceName, &vpcOrigin),
					resource.TestCheckResourceAttrSet(resourceName, "etag"),
					resource.TestCheckResourceAttrSet(resourceName, "vpc_origin_endpoint_config.origin_arn"),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.name", rName),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.http_port", "8080"),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.https_port", "8443"),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.origin_protocol_policy", "https-only"),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.origin_ssl_protocols.items#", "TLSv1.2"),
					resource.TestCheckResourceAttr(resourceName, "vpc_origin_endpoint_config.origin_ssl_protocols.quantity", "1"),
				),
			},
			{
				ResourceName:      resourceName,
				ImportState:       true,
				ImportStateVerify: true,
			},
		},
	})
}

func testAccCheckVPCOriginExists(ctx context.Context, n string, v *awstypes.VpcOrigin) resource.TestCheckFunc {
	return func(s *terraform.State) error {
		conn := acctest.Provider.Meta().(*conns.AWSClient).CloudFrontClient(ctx)
		rs, ok := s.RootModule().Resources[n]
		if !ok {
			return fmt.Errorf("not found: %s", n)
		}

		if rs.Type != "aws_cloudfront_vpc_origin" {
			return fmt.Errorf("resource %s is not a Cloudfront VPC Origin", n)
		}

		output, err := tfcloudfront.FindVPCOriginByID(ctx, conn, rs.Primary.ID)

		if err != nil {
			return err
		}

		if output.VpcOrigin != nil {
			*v = *output.VpcOrigin
		}

		return nil
	}
}

func testAccCheckVPCOriginDestroy(ctx context.Context) resource.TestCheckFunc {
	return func(s *terraform.State) error {
		conn := acctest.Provider.Meta().(*conns.AWSClient).CloudFrontClient(ctx)

		for _, rs := range s.RootModule().Resources {
			if rs.Type != "aws_cloudfront_vpc_origin" {
				continue
			}

			_, err := tfcloudfront.FindVPCOriginByID(ctx, conn, rs.Primary.ID)

			if err == nil {
				return fmt.Errorf("CloudFront VPC Origin %s still exists", rs.Primary.ID)
			}

			if !tfresource.NotFound(err) {
				return err
			}
		}

		return nil
	}
}

func testAccVPCOriginConfig_basic(rName string) string {
	return fmt.Sprintf(`


data "aws_availability_zones" "available" {
  state = "available"

  filter {
    name   = "opt-in-status"
    values = ["opt-in-not-required"]
  }
}


resource "aws_vpc" "test" {
  cidr_block = "10.1.0.0/16"

  tags = {
    Name = %[1]q
  }
}

resource "aws_subnet" "a" {
  vpc_id            = aws_vpc.test.id
  cidr_block        = "10.1.1.0/24"
  availability_zone = data.aws_availability_zones.available.names[0]
}

resource "aws_subnet" "b" {
  vpc_id            = aws_vpc.test.id
  cidr_block        = "10.1.2.0/24"
  availability_zone = data.aws_availability_zones.available.names[1]
}

resource "aws_subnet" "c" {
  vpc_id            = aws_vpc.test.id
  cidr_block        = "10.1.3.0/24"
  availability_zone = data.aws_availability_zones.available.names[2]
}

resource "aws_internet_gateway" "gw" {
  vpc_id = aws_vpc.test.id

  tags = {
    Name = %[1]q
  }
}

resource "aws_security_group" "allow_tls" {
  name        = "allow_tls"
  description = "Allow TLS inbound traffic and all outbound traffic"
  vpc_id      = aws_vpc.test.id

  tags = {
    Name = %[1]q
  }
}

resource "aws_vpc_security_group_ingress_rule" "allow_tls_ipv4" {
  security_group_id = aws_security_group.allow_tls.id
  cidr_ipv4         = "0.0.0.0/0"
  from_port         = 443
  ip_protocol       = "tcp"
  to_port           = 443
}

resource "aws_vpc_security_group_egress_rule" "allow_all_traffic_ipv4" {
  security_group_id = aws_security_group.allow_tls.id
  cidr_ipv4         = "0.0.0.0/0"
  ip_protocol       = "-1" # semantically equivalent to all ports
}

resource "aws_lb" "this" {
  name               = %[1]q
  internal           = true
  load_balancer_type = "application"
  security_groups    = [aws_security_group.allow_tls.id]
  subnets            = [aws_subnet.a.id, aws_subnet.b.id, aws_subnet.c.id]

  tags = {
    Name = %[1]q
  }
}

resource "aws_cloudfront_vpc_origin" "this" {
  vpc_origin_endpoint_config {
    name                   = %[1]q
    origin_arn             = aws_lb.this.arn
    http_port              = 8080
    https_port             = 8443
    origin_protocol_policy = "https-only"
    origin_ssl_protocols {
      items    = ["TLSv1.2"]
      quantity = 1
    }
  }

  tags = {
    Name = %[1]q
  }
}
`, rName)
}
