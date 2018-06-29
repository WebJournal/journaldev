import signal  
import time  
  
  
def alarm_handler(signum, stack):  
    print('Alarm at:', time.ctime())  
  
  
signal.signal(signal.SIGALRM, alarm_handler)  # assign alarm_handler to SIGALARM  
signal.alarm(4)  # set alarm after 4 seconds  
print('Current time:', time.ctime())  
time.sleep(6)  # make sufficient delay for the alarm to happen 
