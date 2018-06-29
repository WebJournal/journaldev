# import the module
import calendar

# print the current month
print('The month of August is:\n', calendar.month(2018, 8))

# set first day of week as sunday
calendar.setfirstweekday(6)

# re print the calender
print('The month of August is:\n', calendar.month(2018, 8))

# print if a year is leap year
print('Is 2017 a leap year? Ans:', calendar.isleap(2017))
print('Is 2016 a leap year? Ans:', calendar.isleap(2016))