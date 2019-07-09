import pymongo
import sys

connection = pymongo.MongoClient("mongodb://localhost")
db = connection.school
scores = db.scores


def find():
    query = {'type': 'exam'}

    try:
        cursor = scores.find(query)
    except:
        print('Unexpected error:', sys.exc_info()[0])

    query = {'type': 'exam', 'score': {'$gt': 50, '$lt': 70}}
    selector = {'student_id': 1, 'score': 1, '_id': 0}

    sanity = 0
    for doc in cursor:
        print(doc)
        sanity += 1
        if sanity > 10:
            break


def find_one():
    query = {'student_id': 10}

    try:
        it = scores.find_one(query)
    except:
        print('Unexpected error:', sys.exc_info()[0])

    print(it)


print('cursor')
find()
print()
print('one')
find_one()


def sort():
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


sort()