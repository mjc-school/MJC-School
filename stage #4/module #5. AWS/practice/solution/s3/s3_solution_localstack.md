# Amazon S3

## Solution

* Create a folder with some files.
* To create an S3 bucket, use the following command: awslocal s3api create-bucket --bucket name-surname-website
* To list all available buckets, use the following command: awslocal s3api list-buckets
* To upload a file to an S3 bucket, use the following command: awslocal s3api put-object --bucket name-surname-website --key filename.html
* To download a file from an S3 bucket, use the following command: awslocal s3api get-object --bucket name-surname-website --key filename.html