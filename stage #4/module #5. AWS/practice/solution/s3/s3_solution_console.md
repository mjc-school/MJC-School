# Amazon S3

## Solution

### Subtask 1

* Create a simple static website
* To create an S3 bucket, use the following AWS CLI commands: aws s3 mb s3://name-surname-website --region us-east-1 OR aws s3api create-bucket --bucket name-surname-website --region us-east-1
* To copy the static website, use the following AWS CLI command: aws s3 cp ./my-simple-static-website-folder s3://name-surname-website/
* To enable static website hosting, refer to [this tutorial](https://docs.aws.amazon.com/AmazonS3/latest/userguide/HostingWebsiteOnS3Setup.html)

### Subtask 2

* To create another S3 bucket, use one of the commands specified in the subtask 1.
* To enable versioning for your bucket, refer to either the Management Console or AWS CLI instruction from [this tutorial](https://docs.aws.amazon.com/AmazonS3/latest/userguide/manage-versioning-examples.html)
* To upload your website again, use the command specified in the subtask 1.
* Make any local changes to one of the files(e.g., delete a word or a symbol).
* To upload the changed file to S3, use the following AWS CLI command: aws s3 sync ./ s3://name-surname-website/your-simple-static-website/
* To download the first(previous) version of the changed file, refer to the Management Console instruction from [this tutorial](https://docs.aws.amazon.com/AmazonS3/latest/userguide/RestoringPreviousVersions.html)