# AWS Lambda

## Solution

### First task
1. Go to the AWS Console and find the Lambda service
2. Click *Create function*
3. Choose *Author from scratch*
4. In the *Basic information* section: 
   * Type the function's name
   * Choose runtime (Current solution is given with Python 3.9 runtime)
   * Leave architecture and execution role as it
5. Click *Create function*
6. Check out the *Code* tab
7. Place in the *Code source* section the [given code](../../resources/lambda/samplcode/lambda_solution.py)
   * Note that handler name has to match with Handler name in function info
8. Check out the *Test* tab
9. Click *Test*
10. See the execution result and current date there
11. In order to add some logs in Python you can use *print()* function

### Second task (optional)
You should make sure you have some buckets in your account to list<br/>
To list buckets you can use a standard role called *AmazonS3ReadOnlyAccess*
1. The sequence of actions is almost identical to the firs task but a bit more configuration is required
2. You can use the [boto3](https://boto3.amazonaws.com/v1/documentation/api/latest/guide/s3-example-creating-buckets.html) library to get S3 client and use its method to list buckets
3. [Here](../../resources/lambda/samplcode/optional_lambda_solution.py) you can see an example code to use
4. In order to rename use the *Handler* info section just above the code section


