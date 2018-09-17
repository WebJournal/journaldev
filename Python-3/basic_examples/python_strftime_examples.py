import datetime

dt = datetime.datetime.now()

print('DateTime in Default Formatting:', dt)

print('Formatted DateTime', dt.strftime("%m/%d/%y %H:%M:%S"))

print("Current year:", dt.strftime("%Y"))
print("Month of year:", dt.strftime("%B"))
print("Week number of the year:", dt.strftime("%W"))
print("Weekday of the week:", dt.strftime("%w"))
print("Day of year:", dt.strftime("%j"))
print("Day of the month:", dt.strftime("%d"))
print("Day of week:", dt.strftime("%A"))
# below will print empty string because datetime object has no timezone information
print("TimeZone:", dt.strftime("%Z"))

# datetime with timezone
import pytz
utc = pytz.utc
dt = datetime.datetime.now(utc)
print("TimeZone:", dt.strftime("%Z"))


# time module
import time
seconds = time.time()
t = time.localtime(seconds)

print('Time struct_time object:', t)
print('Time object with pre-defined formatting:', time.asctime(t))


print('Formatted Time:', time.strftime("%m/%d/%y %H:%M:%S", t))

print("Current year:", time.strftime("%Y", t))
print("Month of year:", time.strftime("%B", t))
print("Week number of the year:", time.strftime("%W", t))
print("Weekday of the week:", time.strftime("%w", t))
print("Day of year:", time.strftime("%j", t))
print("Day of the month:", time.strftime("%d", t))
print("Day of week:", time.strftime("%A", t))
print("TimeZone:", time.strftime("%Z", t))
