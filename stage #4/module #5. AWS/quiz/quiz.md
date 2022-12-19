# Quiz

## IAM

1. Which tasks are available ONLY for the root user?
- a) Change IAM users settings (name, password, access keys, MFA etc.)
- b) Delete an AWS account
- c) Set up budget and free tier usage alerts
- d) Activate IAM access to the Billing and Cost Management console
2. By default a new IAM user has permissions to...
- a) Do nothing(i.e. has no permissions at all)
- b) Manage any of AWS services
- c) Change their own password
- d) Access any of AWS services in the read-only mode
3. Which of the following IS NOT a policy type in AWS IAM?
- a) Organizations SCP
- b) Identity-based policies
- c) Resource-based policies
- d) Service-based policies
4. Which of the following IS NOT present in the list of IAM Security best practices?
- a) Grant least privilege
- b) Use a root user to manage essential AWS resources
- c) Do not share access keys
- d) Use user groups to assign permissions to IAM users
5. Which identities exist in IAM?
- a) User
- b) User groups
- c) Roles
- d) All of the above
6. Does every request to AWS API gets authenticated by IAM by default?
- a) No
- b) Yes
- c) Yes, if it uses access keys
- d) Yes, if it uses access keys or temporary credentials
7. Which of the following IS NOT an IAM policy element?
- a) Effect
- b) Action
- c) Exclusion
- d) Condition
8. Which of the following statements are correct about IAM policies?
- a) Resource-based policies are attached to a resource and control what actions and by whom are allowed to be performed on this resource
- b) IAM policies can be resource-based and identity-based at the same time
- c) IAM policies that allow access to all resources of a particular service are considered to be a best practice
- d) Identity-based policies are attached to an identity and control what actions(on what services) this identity is allowed to perform
9. Which of the following identities CAN assume an IAM role in your account?
- a) AWS service(EC2, Lambda, etc.)
- b) Another AWS account
- c) External(non-AWS) web identity
- d) All of the above
10. Which statement is correct about root users?
- a) You can only use Organizations SCPs to limit the permissions of the root user
- b) You can attach an identity-based policy to the root user
- c) Root user permissions cannot be limited
- d) Root user cannot limit the permissions of IAM users

## S3

1. Which of the object attributes uniquely identify the S3 object within a bucket?
- a) Key (name)
- b) Owner ID
- c) Version ID
- d) Content type
2. What is the maximum S3 object size?
- a) 1 gigabyte
- b) 5 gigabytes
- c) 100 gigabytes
- d) 5 terabytes
3. What is the maximum S3 object size for upload in a single PUT operation?
- a) 1 gigabyte
- b) 5 gigabytes
- c) 100 gigabytes
- d) 5 terabytes
4. Which of the following ARE NOT the existing S3 storage classes?
- a) S3 Standard-IA
- b) S3 Multi Zone-IA
- c) S3 Glacier Deep Retrieval
- d) S3 Glacier Flexible Retrieval
5. Which S3 features can we use to automatically move S3 objects from one storage class to another?
- a) Replication
- b) Lifecycle management
- c) S3 Intelligent-Tiering
- d) Access Points
6. Which of the following are valid ways to allow access to S3 bucket content?
- a) Bucket policy
- b) Access Points
- c) Presigned URLs
- d) All of the above
7. Which S3 replication type DOES NOT exist?
- a) Cross-Region Replication
- b) Cross-Account Replication
- c) Transitive Replication
- d) Same-Region Replication
8. How to delete an object entirely in a S3 bucket with versioning enabled?
- a) Delete the latest version of an object
- b) Delete all versions of an object
- c) Delete all versions of an object and all delete markers
- d) Disable versioning for an object and then delete it
9. Which statements are correct about S3 buckets?
- a) S3 bucket names are globally unique within the “aws” partition, i.e. across all standard regions of all AWS accounts
- b) S3 bucket names are unique within the AWS account but not across all accounts
- c) Amazon S3 creates a bucket in a specified Region, but all objects belonging to are implicitly transferred to other Regions by default to optimize latency, minimize costs, and address regulatory requirements
- d) Amazon S3 creates a bucket in a specified Region and all objects belonging to it never leave that Region, unless you explicitly transfer them to another Region
10. What is the S3 Standard storage class rate of durability?
- a) 99.99999999% (10 9s)
- b) 99.999999999% (11 9s)
- c) 99.9999999% (9 9s)
- d) 99.999999999999% (14 9s)

## EC2

1. Which of the following is the AWS service that is used for providing scalable virtual servers(computing capacity)?
- a) Elastic Cloud Computing
- b) Elastic Computer Cloud
- c) Elastic Compute Cloud
- d) Elastic Calculator Cloud
2. Can you detach an EBS volume that isn't used as the root device from a running EC2 instance without stopping it?
- a) No
- b) Yes
3. Can you delete a snapshot of an EBS volume that is used as the root device of a registered AMI?
- a) No
- b) Yes
4. Can you restart an instance after its termination?
- a) No
- b) Yes
5. Which EBS volume types DO exist?
- a) ssd, gp2, io1, Throughput Optimized HDD
- b) gp2, gp3, io1, Cold HDD
- c) gp2, gp3, sata1, magnetic storage
- d) ssd, hdd, magnetic storage
6. Which IP addresses can you use to connect to the EC2 instance from the Internet?
- a) Public IPv4 address
- b) Private IPv4 address
- c) IPv6 address
- d) Elastic IP address
7. When you REBOOT an instance, which of the following instance attributes DO NOT change?
- a) Public IPv4 address
- b) Private IPv4 address
- c) IPv6 address
- d) Elastic IP address
8. When you STOP and START an instance, which of the following instance attributes DO NOT change?
- a) Public IPv4 address
- b) Private IPv4 address
- c) IPv6 address
- d) Elastic IP address
9. If you need to attach an EBS volume to an EC2 instance, which statement is correct?
- a) EC2 should be in the same Availability Zone as the volume
- b) EC2 should be in the same Region as the volume
- c) EC2 should be in the same Datacenter as the volume
- d) EC2 and EBS volume could be in any Region or Availability Zone
10. Which of the following are instance purchasing options?
- a) On-demand
- b) Reserved Instances
- c) Dedicated Hosts
- d) Spot Instances

## RDS

1. Which of the following features are you responsible for when working with RDS instances?
- a) Database configuration & operation
- b) Creating backups
- c) Software patching
- d) All of the above
2. Can you connect directly to the DB instance(for example, to install some additional software on it)?
- a) Yes
- b) No
- c) No by default, but can be configured to yes
3. Will you be billed if you stop your RDS instance?
- a) No
- b) Yes, only for provisioned storage
- c) Yes, for backup storage and provisioned storage
- d) Yes, only for backup storage
4. Which database engine is not supported by Amazon RDS?
- a) MySQL
- b) Microsoft SQL Server
- c) MariaDB
- d) SQLite
5. Which DB instance storage is the most optimized for fast and consistent throughput of input and output operations?
- a) Provisioned IOPS
- b) General Purpose SSD
- c) Magnetic Storage
6. Which purchasing options are supported in Amazon RDS?
- a) On-demand instances
- b) Dedicated instances
- c) Reserved instances
- d) Spot instances
7. What are the basic conditions which has to be followed in order to create a DB instance backup?
- a) DB instance should be in the "Available" state
- b) DB backup window and DB maintenance window cannot overlap
- c) DB instance cannot have any active connections
- d) All of the above
8. Can a standby replica accept connections for read queries in a Multi-AZ DB deployment?
- a) Yes
- b) No
9. Can you connect directly to the database on a DB instance(for example, from an EC2 instance inside the same VPC)?
- a) Yes
- b) No
10. What type of replication is used when working with read replicas?
- a) Asynchronous replication
- b) Synchronous replication
- c) All of the above

## DynamoDB

1. Is DynamoDB a serverless solution?
- a) Yes
- b) No
- c) Yes, but DAX which is a part of the service requires instances
- d) Yes, but instances are used when replication is enabled
2. There are several storage types available in DynamoDB. They are ...
- a) Yes, several ones. HDD, SSD
- b) Yes, several ones. HDD, cold HDD, SSD
- c) No, HDD only
- d) No, SSD only
3. Each item should follow a particular schema while being stored in DynamoDB?
- a) Yes
- b) Only if SSD is used for storing
- c) Only if DAX enabled needed
- d) No
4. Suppose you have an item with a concrete partition key. How will DynamoDB resolve the situation putting this item in the same partition?
- a) An existing item will be replaced with a new one
- b) An existing item will be overwritten with a new one
- c) There will be two item within the same partition but with different sort keys
- d) There will be two item within the same hash key and sort key
5. Suppose you have to access an item, and you know its partition key and other attributes' values. What will be faster to run?
- a) Scan since you know all the attributes' values
- b) Query since you know its partition key
- c) Query since you know all the attributes' values
- d) Scan since you know its partition key
6. Is it possible to modify an LSI after its creation?
- a) No
- b) Yes
- c) Yes, if it has only one item added
- d) Yes, if there is only on LSI within the table
7. AWS DynamoDB calls can be throttled if ...
- a) No items found with specified parameters
- b) RCU or WCU not configured
- c) RCU or WCU exceeded
- d) They never be throttled
8. Use DAX in case you want to improve ...
- a) Read performance
- b) Write performance
- c) Read and write performance
- d) ElastiCache is a better approach
9. Consider you want to ger rid of outdated items in order to reduce cost. You'd better ...
- a) Use TTL feature
- b) Manually delete them
- c) Read a table, detect outdated items, create a new table without outdated items and delete the old one
- d) Use scan features to filter old items
10. What is the best approach to handle occasionally overloaded errors?
- a) ElastiCache to read cached data
- b) DAX to read cached data
- c) Exponential backoff
- d) If an error happen then no need to try it again because DynamoDB provides ultimate resources, so no errors possible if data exists

## Lambda

1. What service does AWS use to store a Lambda function's code?
- a) S3
- b) DynamoDB
- c) EFS
- d) EBS
2. What should be used to give permissions to a function to use other services?
- a) Event mapping descriptors
- b) Resource policy
- c) Execution role
- d) Execution permissions
3. In what style must you write Lambda code?
- a) Stateful
- b) MVC
- c) Stateless
- d) Virtual
4. How can a developer provide Lambda code?
- a) By uploading a .zip file
- b) All of these answers
- c) By editing inline
- d) From an S3 bucket
5. How are computing resources allocated to Lambdas?
- a) Equally
- b) Periodically
- c) Daily
- d) Proportionally
6. How can additional code or content be provided for your Lambda?
- a) Blocks
- b) Layers
- c) Aliases
- d) Handlers
7. How is CPU power configured in lambda?
- a) Allocated in proportion to the specified memory
- b) It's not required
- c) It's can be dissembled
- d) Allocated in doubled proportion to the specified memory
8. How are environment variables stored?
- a) Via DynamoDB tables
- b) Key-value pairs
- c) None of these answers
- d) S3 buckets
9. Is there any way to code a function with a language not listed as a natively supported?
- a) No, in this case you shouldn't use the service
- b) Yes, create a Lambda layer with a custom runtime and reference the layer in your lambda
- c) Yes, create a Lambda function with a custom runtime
- d) Yes, create a Lambda function with a custom runtime and reference the function in your Lambda
10. What should be used to give permissions to other AWS entities to invoke a Lambda function?
- a) Event mapping descriptors
- b) Resource policy
- c) Execution role
- d) Execution permissions

## VPC

*Pay attention here multiple right answers can be right per a question*

1. What is the maximum size of the CIDR block you can have for a VPC?
- a) 16
- b) 32
- c) 28
- d) 10
2. How many IP addresses are reserved by AWS for its internal purposes in a CIDR block that you can't use?
- a) 15
- b) 5
- c) 1
- d) 4
3. What is the key difference of ACL (Access Control List) from Security Group?
- a) Statelessness
- b) It's attached to an EC2 instance
- c) Statefullness
- d) It's attached to a subnet
4. To connect your corporate data center to AWS, you need at least which of the following components?
- a) Internet gateway
- b) Virtual private gateway
- c) Customer gateway
- d) NAT gateway
5. In case you want to explicitly "deny" certain traffic to the instance running in your VPC. You'll reach this via ...
- a) Security group
- b) Route table entry
- c) Putting a new instance in a private subnet
- d) ACL
6. An application load balancer must be deployed into at least ... subnet(s)?
- a) 1
- b) 2
- c) 4
- d) 5
7. A VPN connection consists of which of the following components?
- a) Cross connect gateway
- b) Customer gateway
- c) Direct connect gateway
- d) Virtual private gateway
8. By default, how many VPCs am I allowed in each AWS region?
- a) 1
- b) 2
- c) 5
- d) 6
9. Which of the following allows you to SSH or RDP into an EC2 instance located in a private subnet?
- a) NAT instance
- b) NAT gateway
- c) Bastion host
- d) API gateway
10. Consider having 4 VPCs. You decided to enable peering between them. How many direct connections there will be?
- a) 6
- b) 3
- c) 4
- d) 8
