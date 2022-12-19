import boto3, os

def main(event, context):
    s3Client = boto3.client('s3')
    try:
        buckets = s3Client.list_buckets()
        print(buckets)
        output = ""
        for bucket in buckets['Buckets']:
            output = output + bucket['Name'] + "\n"
        print("Buckets: " + output)
    except:
        print("An error occurred!")