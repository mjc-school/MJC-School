import json

from datetime import datetime

def lambda_handler(event, context):
    currentTime = datetime.now().strftime("%m-%d-%Y %H:%M:%S")
    message = "Hello, world! Now is {}".format(current_time)
    return {
        'statusCode': 200,
        'body': json.dumps(message)
    }
