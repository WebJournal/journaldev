import time

print('Hello There, next message will be printed after 5 seconds.')

time.sleep(5)

print('Sleep time is over.')

sec = input('Let us wait for user input. Let me know how many seconds to sleep now.\n')

print('Going to sleep for', sec, 'seconds.')

time.sleep(int(sec))

print('Enough of sleeping, I Quit!')
