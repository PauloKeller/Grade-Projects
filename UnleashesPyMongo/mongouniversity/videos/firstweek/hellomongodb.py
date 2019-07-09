import bottle
import pymongo

# this is the handler for the default path of web server

@bottle.route('/')
def index():

    # connect to mongoDB
    connection = pymongo.MongoClient('localhost', 27017)

    # attach to test database
    db = connection.test

    # get handle for names collection
    name = db.names

    # find a single document
    item = name.find_one()

    return '<b></>'
