# import the module

# get the current clock ticks from the time() function
seconds = basic_examples.time()
print(seconds)

currentTime = time.localtime(seconds)

# print the currentTime variable to know about it
print(currentTime,'\n')

# use current time to show current time in formatted string
print('Current System time is :', time.asctime(currentTime))

print('Formatted Time is :', time.strftime("%d/%m/%Y", currentTime))