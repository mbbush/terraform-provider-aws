// Code generated by internal/generate/teamcity/main.go; DO NOT EDIT.

val services = mapOf(
    "accessanalyzer" to ServiceSpec("IAM Access Analyzer"),
    "account" to ServiceSpec("Account Management"),
    "acm" to ServiceSpec("ACM (Certificate Manager)"),
    "acmpca" to ServiceSpec("ACM PCA (Certificate Manager Private Certificate Authority)"),
    "amp" to ServiceSpec("AMP (Managed Prometheus)"),
    "amplify" to ServiceSpec("Amplify"),
    "apigateway" to ServiceSpec("API Gateway"),
    "apigatewayv2" to ServiceSpec("API Gateway V2"),
    "appautoscaling" to ServiceSpec("Application Auto Scaling", vpcLock = true),
    "appconfig" to ServiceSpec("AppConfig"),
    "appflow" to ServiceSpec("AppFlow"),
    "appintegrations" to ServiceSpec("AppIntegrations"),
    "applicationinsights" to ServiceSpec("CloudWatch Application Insights"),
    "appmesh" to ServiceSpec("App Mesh"),
    "apprunner" to ServiceSpec("App Runner"),
    "appstream" to ServiceSpec("AppStream 2.0", vpcLock = true, parallelismOverride = 10),
    "appsync" to ServiceSpec("AppSync"),
    "athena" to ServiceSpec("Athena"),
    "autoscaling" to ServiceSpec("Auto Scaling", vpcLock = true),
    "autoscalingplans" to ServiceSpec("Auto Scaling Plans"),
    "backup" to ServiceSpec("Backup"),
    "batch" to ServiceSpec("Batch", vpcLock = true),
    "budgets" to ServiceSpec("Web Services Budgets"),
    "ce" to ServiceSpec("CE (Cost Explorer)"),
    "chime" to ServiceSpec("Chime"),
    "cloud9" to ServiceSpec("Cloud9"),
    "cloudcontrol" to ServiceSpec("Cloud Control API"),
    "cloudformation" to ServiceSpec("CloudFormation", vpcLock = true),
    "cloudfront" to ServiceSpec("CloudFront"),
    "cloudhsmv2" to ServiceSpec("CloudHSM", vpcLock = true),
    "cloudsearch" to ServiceSpec("CloudSearch"),
    "cloudtrail" to ServiceSpec("CloudTrail"),
    "cloudwatch" to ServiceSpec("CloudWatch"),
    "codeartifact" to ServiceSpec("CodeArtifact"),
    "codebuild" to ServiceSpec("CodeBuild"),
    "codecommit" to ServiceSpec("CodeCommit"),
    "codepipeline" to ServiceSpec("CodePipeline"),
    "codestarconnections" to ServiceSpec("CodeStar Connections"),
    "codestarnotifications" to ServiceSpec("CodeStar Notifications"),
    "cognitoidentity" to ServiceSpec("Cognito Identity"),
    "cognitoidp" to ServiceSpec("Cognito IDP (Identity Provider)"),
    "configservice" to ServiceSpec("Config"),
    "connect" to ServiceSpec("Connect"),
    "cur" to ServiceSpec("Cost and Usage Report"),
    "dataexchange" to ServiceSpec("Data Exchange"),
    "datapipeline" to ServiceSpec("Data Pipeline"),
    "datasync" to ServiceSpec("DataSync", vpcLock = true),
    "dax" to ServiceSpec("DynamoDB Accelerator (DAX)"),
    "deploy" to ServiceSpec("CodeDeploy"),
    "detective" to ServiceSpec("Detective"),
    "devicefarm" to ServiceSpec("Device Farm"),
    "directconnect" to ServiceSpec("Direct Connect", vpcLock = true),
    "dlm" to ServiceSpec("DLM (Data Lifecycle Manager)"),
    "dms" to ServiceSpec("DMS (Database Migration)", vpcLock = true),
    "docdb" to ServiceSpec("DocDB (DocumentDB)", vpcLock = true),
    "ds" to ServiceSpec("DS (Directory Service)", vpcLock = true),
    "dynamodb" to ServiceSpec("DynamoDB"),
    "ec2" to ServiceSpec("EC2 (Elastic Compute Cloud)", vpcLock = true),
    "ecr" to ServiceSpec("ECR (Elastic Container Registry)"),
    "ecrpublic" to ServiceSpec("ECR Public"),
    "ecs" to ServiceSpec("ECS (Elastic Container)"),
    "efs" to ServiceSpec("EFS (Elastic File System)", vpcLock = true),
    "eks" to ServiceSpec("EKS (Elastic Kubernetes)", vpcLock = true),
    "elasticache" to ServiceSpec("ElastiCache", vpcLock = true),
    "elasticbeanstalk" to ServiceSpec("Elastic Beanstalk", vpcLock = true),
    "elasticsearch" to ServiceSpec("Elasticsearch", vpcLock = true),
    "elastictranscoder" to ServiceSpec("Elastic Transcoder"),
    "elb" to ServiceSpec("ELB Classic", vpcLock = true),
    "elbv2" to ServiceSpec("ELB (Elastic Load Balancing)", vpcLock = true),
    "emr" to ServiceSpec("EMR", vpcLock = true),
    "emrcontainers" to ServiceSpec("EMR Containers"),
    "emrserverless" to ServiceSpec("EMR Serverless"),
    "events" to ServiceSpec("EventBridge"),
    "firehose" to ServiceSpec("Kinesis Firehose"),
    "fis" to ServiceSpec("FIS (Fault Injection Simulator)"),
    "fms" to ServiceSpec("FMS (Firewall Manager)"),
    "fsx" to ServiceSpec("FSx", vpcLock = true),
    "gamelift" to ServiceSpec("GameLift"),
    "glacier" to ServiceSpec("S3 Glacier"),
    "globalaccelerator" to ServiceSpec("Global Accelerator"),
    "glue" to ServiceSpec("Glue"),
    "grafana" to ServiceSpec("Managed Grafana"),
    "greengrass" to ServiceSpec("IoT Greengrass"),
    "guardduty" to ServiceSpec("GuardDuty"),
    "iam" to ServiceSpec("IAM (Identity & Access Management)"),
    "identitystore" to ServiceSpec("SSO Identity Store"),
    "imagebuilder" to ServiceSpec("EC2 Image Builder"),
    "inspector" to ServiceSpec("Inspector"),
    "iot" to ServiceSpec("IoT Core"),
    "iotanalytics" to ServiceSpec("IoT Analytics"),
    "iotevents" to ServiceSpec("IoT Events"),
    "kafka" to ServiceSpec("Managed Streaming for Kafka", vpcLock = true),
    "kafkaconnect" to ServiceSpec("Managed Streaming for Kafka Connect"),
    "kendra" to ServiceSpec("Kendra"),
    "keyspaces" to ServiceSpec("Keyspaces (for Apache Cassandra)"),
    "kinesis" to ServiceSpec("Kinesis"),
    "kinesisanalytics" to ServiceSpec("Kinesis Analytics"),
    "kinesisanalyticsv2" to ServiceSpec("Kinesis Analytics V2"),
    "kinesisvideo" to ServiceSpec("Kinesis Video"),
    "kms" to ServiceSpec("KMS (Key Management)"),
    "lakeformation" to ServiceSpec("Lake Formation"),
    "lambda" to ServiceSpec("Lambda", vpcLock = true),
    "lexmodels" to ServiceSpec("Lex Model Building"),
    "licensemanager" to ServiceSpec("License Manager"),
    "lightsail" to ServiceSpec("Lightsail"),
    "location" to ServiceSpec("Location"),
    "logs" to ServiceSpec("CloudWatch Logs"),
    "macie" to ServiceSpec("Macie Classic"),
    "macie2" to ServiceSpec("Macie"),
    "mediaconnect" to ServiceSpec("Elemental MediaConnect"),
    "mediaconvert" to ServiceSpec("Elemental MediaConvert"),
    "medialive" to ServiceSpec("Elemental MediaLive"),
    "mediapackage" to ServiceSpec("Elemental MediaPackage"),
    "mediastore" to ServiceSpec("Elemental MediaStore"),
    "memorydb" to ServiceSpec("MemoryDB for Redis"),
    "mq" to ServiceSpec("MQ", vpcLock = true),
    "mwaa" to ServiceSpec("MWAA (Managed Workflows for Apache Airflow)", vpcLock = true),
    "neptune" to ServiceSpec("Neptune"),
    "networkfirewall" to ServiceSpec("Network Firewall", vpcLock = true),
    "networkmanager" to ServiceSpec("Network Manager"),
    "opensearch" to ServiceSpec("OpenSearch"),
    "opsworks" to ServiceSpec("OpsWorks", vpcLock = true),
    "organizations" to ServiceSpec("Organizations"),
    "outposts" to ServiceSpec("Outposts"),
    "pinpoint" to ServiceSpec("Pinpoint"),
    "pricing" to ServiceSpec("Pricing Calculator"),
    "qldb" to ServiceSpec("QLDB (Quantum Ledger Database)"),
    "quicksight" to ServiceSpec("QuickSight"),
    "ram" to ServiceSpec("RAM (Resource Access Manager)"),
    "rbin" to ServiceSpec("Recycle Bin (RBin)"),
    "rds" to ServiceSpec("RDS (Relational Database)", vpcLock = true),
    "redshift" to ServiceSpec("Redshift", vpcLock = true),
    "redshiftdata" to ServiceSpec("Redshift Data"),
    "redshiftserverless" to ServiceSpec("Redshift Serverless"),
    "resourcegroups" to ServiceSpec("Resource Groups"),
    "resourcegroupstaggingapi" to ServiceSpec("Resource Groups Tagging"),
    "rolesanywhere" to ServiceSpec("Roles Anywhere"),
    "route53" to ServiceSpec("Route 53", vpcLock = true),
    "route53domains" to ServiceSpec("Route 53 Domains"),
    "route53recoverycontrolconfig" to ServiceSpec("Route 53 Recovery Control Config"),
    "route53recoveryreadiness" to ServiceSpec("Route 53 Recovery Readiness"),
    "route53resolver" to ServiceSpec("Route 53 Resolver", vpcLock = true),
    "rum" to ServiceSpec("CloudWatch RUM"),
    "s3" to ServiceSpec("S3 (Simple Storage)"),
    "s3control" to ServiceSpec("S3 Control"),
    "s3outposts" to ServiceSpec("S3 on Outposts"),
    "sagemaker" to ServiceSpec("SageMaker", vpcLock = true),
    "schemas" to ServiceSpec("EventBridge Schemas"),
    "secretsmanager" to ServiceSpec("Secrets Manager"),
    "securityhub" to ServiceSpec("Security Hub"),
    "serverlessrepo" to ServiceSpec("Serverless Application Repository"),
    "servicecatalog" to ServiceSpec("Service Catalog"),
    "servicediscovery" to ServiceSpec("Cloud Map", vpcLock = true),
    "servicequotas" to ServiceSpec("Service Quotas"),
    "ses" to ServiceSpec("SES (Simple Email)"),
    "sfn" to ServiceSpec("SFN (Step Functions)"),
    "shield" to ServiceSpec("Shield"),
    "signer" to ServiceSpec("Signer"),
    "simpledb" to ServiceSpec("SDB (SimpleDB)"),
    "sns" to ServiceSpec("SNS (Simple Notification)"),
    "sqs" to ServiceSpec("SQS (Simple Queue)"),
    "ssm" to ServiceSpec("SSM (Systems Manager)", vpcLock = true),
    "ssoadmin" to ServiceSpec("SSO Admin"),
    "storagegateway" to ServiceSpec("Storage Gateway", vpcLock = true),
    "sts" to ServiceSpec("STS (Security Token)"),
    "swf" to ServiceSpec("SWF (Simple Workflow)"),
    "synthetics" to ServiceSpec("CloudWatch Synthetics", parallelismOverride = 10),
    "timestreamwrite" to ServiceSpec("Timestream Write"),
    "transcribe" to ServiceSpec("Transcribe"),
    "transfer" to ServiceSpec("Transfer Family", vpcLock = true),
    "waf" to ServiceSpec("WAF Classic"),
    "wafregional" to ServiceSpec("WAF Classic Regional"),
    "wafv2" to ServiceSpec("WAF"),
    "worklink" to ServiceSpec("WorkLink"),
    "workspaces" to ServiceSpec("WorkSpaces", vpcLock = true),
    "xray" to ServiceSpec("X-Ray"),
)
