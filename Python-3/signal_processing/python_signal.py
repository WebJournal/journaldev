import signal  
import time  
  
  
def handler(a, b):  # define the handler  
    print("Signal Number:", a, " Frame: ", b)  
  
signal.signal(signal.SIGINT, handler)  # assign the handler to the signal SIGINT  
  
while 1:  
    print("Press ctrl + c")  # wait for SIGINT  
    time.sleep(10) 
