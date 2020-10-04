import _thread
import time

def say_hello(name: str, delay: int):
  count = 0
  while count < 5:
    time.sleep(delay)
    count += 1
    print ("%s: %s" % ( name, time.ctime(time.time()) ))

try:
   _thread.start_new_thread(say_hello, ("Paulo", 2) )
   _thread.start_new_thread(say_hello, ("Vinicius", 4) )
except:
   print ("Error: unable to start thread")

while 1:
   pass