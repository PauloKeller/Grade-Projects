from tweepy.streaming import StreamListener
from tweepy import OAuthHandler
from tweepy import Stream
from pymongo import MongoClient
import json

connection = MongoClient("mongodb://localhost")



db = connection.syriawar

consumer_key = 'I9OGuZdi1NCoxfhZpqSDLbZ0f'
consumer_secret = 'Sufdkp24HqnxNN1gVZgVctLKnFcDyFA5rD7gzPv5veNqOptgxO'
access_token = '968495699947122688-EbxY3wwEMpMiaEMjcKSWD5SzoDDPrSw'
access_token_secret = 'jqVrWan4pSHxBSe2vfcovc7lpbaLxhi5yFI8Kn2oeHZpa'

def BMP(s): return "".join((i if ord(i) < 10000 else '\ufffd' for i in s))

class StdOutListener(StreamListener):
    def on_data(self, data):
        resp = json.loads(data)
        db.tweets.insert(resp)
        if 'extended_tweet' in resp:
            print(BMP(resp['extended_tweet']['full_text']))
        else:
            print(BMP(resp['text']))
        return True

    def on_error(self, status):
        print(status)


l = StdOutListener()
auth = OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)

stream = Stream(auth, l, tweet_mode='extended')
stream.filter(track=['Syria war'])