# AWS IAM

## Practice

As part of this module, you'll work with the following IAM identities: 
1. IAM roles
2. IAM policies
3. IAM user groups

IMPORTANT: do not forget to remove all the created resources after the task has been completed.

### Amazon Web Services

All of the tasks can be completed via the Management Console or AWS CLI based on your preference.

#### Subtask 1 - IAM policies

Full Access EC2:
1. Create a policy named FullAccessPolicyEC2.
2. Configure the FullAccessPolicyEC2 policy to allow any actions on any EC2 resources.

Full Access S3:
3. Create a policy named FullAccessPolicyS3.
4. Configure the FullAccessPolicyS3 policy to allow any actions on any S3 resources.

Read Access S3:
5. Create a policy named ReadAccessPolicyS3.
4. Configure the ReadAccessPolicyS3 policy to allow only GET and LIST actions on any S3 resources.

#### Subtask 2 - IAM roles

Create one IAM role of EC2 Type (Trusted Entity) per each IAM policy configured so far:
1. FullAccessRoleEC2
2. FullAccessRoleS3 - this role will give EC2 resources(EC2 instances) full access to S3 resources.
3. ReadAccessRoleS3 - this role will give EC2 resources(EC2 instances) read access to S3 resources.

#### Subtask 3 - IAM user groups

Create one IAM user group per each IAM role configured so far:
1. FullAccessGroupEC2
2. FullAccessGroupS3
3. ReadAccessGroupS3

Create one user in every IAM user group configured so far.

### LocalStack

Unfortunately, there are no tasks to do in LocalStack in this module.

## Solution

In case you face any issues while doing the task please peek into the [AWS solution](./solution/iam/iam_solution_console.md)