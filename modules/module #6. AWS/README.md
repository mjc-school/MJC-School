# AWS Introduction
The goal of the module is to make you familiar with the Cloud computing concepts, 
main features and patterns, give you the feeling what's the benefits it brings and when it's
worth using in real life. Being most widely spread Amazon Web Services (AWS) cloud provider
is to be used as main source of knowledge and tasks for the given module.

## Materials
* [Cloud Computing Fundamentals](https://youtu.be/uroryFU78gM)
* [AWS Official Documentation](https://docs.aws.amazon.com/index.html?nc2=h_ql_doc_do)
* [AWS Essentials](https://www.youtube.com/playlist?list=PLv2a_5pNAko0Mijc6mnv04xeOut443Wnk)
* [AWS Tutorial for Begginers](https://youtu.be/IT1X42D1KeA)
* [AWS Concepts](https://www.youtube.com/playlist?list=PLv2a_5pNAko2Jl4Ks7V428ttvy-Fj4NKU)

## Tasks
The goal of the exercise to make your familiar with AWS console, base components available in AWS such as
Virtual Private Cloud (VPC), Security Group, EC2, RDS and S3. You also are expected to deploy you application within
cloud facilities: web application on top of EC2 instance and static assets within S3 bucket. It also required to 
integrate with managed database instance (RDS). The deployment flow is not expected 
to be fully automated and most provision is to be done manually.
![image info](./vision.jpg)
### 1. AWS Account Creation
AWS gives you an option to create a free account to browse, discover and use the main services
it offers.
To accomplish the  task follow the link [AWS Free Tier](https://aws.amazon.com/free/?all-free-tier.sort-by=item.additionalFields.SortRank&all-free-tier.sort-order=asc)
and complete registration.
### 2. Application Role Creation
In order to access S3 bucket from within your application deployed in EC2 you must make it under authorized identity.
The common approach is to assign a service role that we are to create beforehand.
1. Go to IAM section and navigate to Roles section.
2. Under the section Common use cases select EC2 and assign AmazonS3ReadOnlyAccess permission policy on Role.
3. Save just created Role.
### 3. Upload Application Jar to AWS S3
1. Create mjc-<yourname>-jar S3 bucket.
2. Make sure the bucket is available for the role created on the step above only. It might be achieved 
through Bucket Policy.
3. Upload your application jar file to the newly created bucket.
### 4. Upload Application UI Files to AWS S3
1. Create mjc-<yourname>-assets S3 bucket.
2. Make sure the bucket is publicly available.
3. Upload your application static content to the newly created bucket.
### 5. Launch RDS instance
1. Start launching RDS instance available within Free Tier (MySQL or PostgreSQL).
2. Select default VPC, Subnet and Security Group. 
3. Make sure Security Group is configured to permit access by port your database is running on.
4. Configure your database with application specific data: schema, tables, data.
### 6. Launch ASW instance
1. Start launching t2.micro EC2 instance based on Amazon Linux 2 image with default VPC settings. 
2. Assigned the Role created on step 2.
2. Within User Data section add the script that download your application from S3 bucket and launch it. Use
aws cli command: aws s3 cp s3://BUCKET-NAME/FILENAME . 
3. In security group settings open the port your application will be running on.
4. Attach Elastic IP address to your EC2 instance.
