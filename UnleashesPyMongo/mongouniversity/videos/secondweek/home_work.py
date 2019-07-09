import pymongo
import datetime
import sys

# establish a connection to the database
connection = pymongo.MongoClient("mongodb://localhost")


# get a handle to the school database
db = connection.students
grades = db.grades



def find_student_data():
    print("Searching for student data for student with type = ", "homework")
    try:
        query = {'type': "homework"}
        docs = grades.find(query)
        for doc in docs:
            print(doc)
            result = grades.delete_many(doc)
            print("num removed: ", result.deleted_count)

    except Exception as e:
        print("Exception: ", type(e), e)



find_student_data()