import pymongo
import sys
import json, requests

url = "http://www.reddit.com/r/Python/.json"
connection = pymongo.MongoClient("mongodb://localhost")
db = connection.reddit
stories = db.stories

resp = requests.get(url=url)
data = json.loads(resp.text)

def insert_stories() :
    for item in data['data']['children']:
        stories.insert(item['data'])


def find():
    query = {'title': {'$regex': 'Python'}}
    selector = {'title': 1, 'num_comments': 1, '_id': 0}

    try:
        cursor = stories.find(query, selector)
    except:
        print('Unexpected error:', sys.exc_info()[0])

    sanity = 0
    for doc in cursor:
        print(doc)
        sanity += 1
        if sanity > 10:
            break


def find():
    query = {}

    try:
        cursor = scores.find(query).sort('student_id', pymongo.ASCENDING).skip(4).limit(1)
        # não adianta separar, o conjunto é executado quando o cursor é consumido!!!!
        # para várias chaves use uma tupla, como exemplo abaixo
        # .sort([('student_id', pymongo.ASCENDING), ('score', pymongo.DESCENDING)])
    except:
        print('Unexpected error:', sys.exc_info()[0])

    sanity = 0
    for doc in cursor:
        print(doc)
        sanity += 1
        if sanity > 10:
            break


find()
