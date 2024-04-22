// Copyright (c) HashiCorp, Inc.
// SPDX-License-Identifier: MPL-2.0

package conns

import (
	"github.com/aws/aws-sdk-go/aws/session"
	"github.com/aws/smithy-go/middleware"
)

func (c *AWSClient) AppendAPIOptions(options ...func(stack *middleware.Stack) error) {
	c.awsConfig.APIOptions = append(c.awsConfig.APIOptions, options...)
}
func (c *AWSClient) Session() *session.Session {
	return c.session
}
