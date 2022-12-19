# AWS Lambda

## Solution

In order to create a lambda function in terminal type the following 
```
awslocal lambda create-function 
```

After you create the function run this command to make a URL

```
awslocal lambda create-function-url-config 
```

Then run it and see logs

```
aws lambda invoke
```

You can use as sample code [this](../../resources/lambda/samplcode/lambda_solution.py)
