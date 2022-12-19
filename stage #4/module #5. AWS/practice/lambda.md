# AWS Lambda

## Practice

In this section you are going to create a simple lambda function that prints current time<br/>
For the AWS part there is an optional task to incorporate some other services

**IMPORTANT: do not forget to remove all the created resources within AWS after the task has been completed**

### Amazon Web Services

#### First Task
* Create a lambda function named *MJC-<Your_Name>-Current-Time-Function*
    * You can use any language and runtime but keep in mind that solution is given with Python
* Ensure you can see correct time in the execution result

You can add some logs in the code to see them in the *Log output* section.<br/>
Also please pay attention that other information about execution is displayed.<br/>

#### Second Task (optional)
If you have the *IAM* and *S3* modules completed then you can write another function to list S3 buckets from your account
* Create a lambda function name *MJC-<Your_Name>-List-Buckets-Function*
  * Use a proper execution role according to the least privilege strategy
  * You should use SDK in order to list buckets
  * Please give a non-standard name for a handler
* Ensure you can see correct list of buckets from your account

### LocalStack

#### Task
* Create a lambda function named *MJC-<Your_Name>-Current-Time-Function*
  * You can use any language and runtime but keep in mind that solution is given with Python
* Ensure you can see correct time in the execution result

Please use this [documentation](https://docs.localstack.cloud/aws/lambda/) while doing the task<br/>


## Solution
In case you face any issues while doing the task please peek into the [AWS solution](solution/lambda/lambda_solution_console.md) or [LocalStack solution](solution/lambda/lambda_solution_localstack.md) 
