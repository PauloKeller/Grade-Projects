import pymongo
import gridfs


arquivo = "test.mp4"
con = pymongo.MongoClient("mongodb://localhost")
db = con.test
videos_meta = db.videos_metax

grid = gridfs.GridFS(db, 'videos')

f = open(arquivo, 'rb') #if not working try rb
_id = grid.put(f)
f.close()

print ('id of file is ', _id)

videos_meta.insert({'grid_id':_id, 'filename':
                    arquivo})