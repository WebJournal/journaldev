from datetime import datetime, timedelta

current_datetime = datetime.now()

# future dates
one_year_future_date = current_datetime + timedelta(days=365)

print('Current Date:', current_datetime)
print('One year from now Date:', one_year_future_date)

# past dates
three_days_before_date = current_datetime - timedelta(days=3)
print('Three days before Date:', three_days_before_date)

# with date and time objects
dt = current_datetime.date()
print('Current Date:', dt)
dt_tomorrow = dt + timedelta(days=1)
print('Tomorrow Date:', dt_tomorrow)

tm = current_datetime.time()
print('Current Time:', tm)
# TypeError: unsupported operand type(s) for +: 'datetime.time' and 'datetime.timedelta'
# tm_after_30_mins = tm + timedelta(minutes=30)
# print('Time after 30 minutes:', tm_after_30_mins)

# timedelta attributes
print(timedelta.max)
print(timedelta.min)
print(timedelta.resolution)

# other supported operations
ct = current_datetime + timedelta(seconds=60) - timedelta(seconds=60)
print(current_datetime == ct)

ct = current_datetime + timedelta(seconds=10) * 6
print('Current Time:', current_datetime)
print('One Min from Current Time:', ct)

print('Seconds in an year:', timedelta(days=365).total_seconds())

print('Timedelta absolute value:', abs(timedelta(days=-10)))
print('Timedelta String Representation:', str(timedelta(days=1, seconds=30, hours=10, milliseconds=300)))
print('Timedelta Object Representation:', repr(timedelta(days=1, seconds=30, hours=10, milliseconds=300)))
