from datetime import date, timedelta

d = date(2018, 12, 25)

print(d)

# today's date
d = date.today()
print(d)

# date from timestamp
import time
t = time.time()
print(t)
d = date.fromtimestamp(t)
print(d)
d = date.fromtimestamp(1537261418)
print(d)

# date from ordinal
d = date.fromordinal(366)
print(d)

# date from ISO string format, added in Python 3.7
d = date.fromisoformat('2018-09-19')
print(d)

# date class attributes
print(date.min)
print(date.max)
print(date.resolution)

# instance attributes, read only
d = date.today()
print(d.year)
print(d.month)
print(d.day)

# date operations with timedelta
date_tomorrow = date.today() + timedelta(days=1)
print(date_tomorrow)
date_yesterday = date.today() - timedelta(days=1)
print(date_yesterday)

td = date_tomorrow - date_yesterday
print(td)

print(date_tomorrow > date_yesterday)

# instance methods
today = date.today()
print(today)
new_date = today.replace(year=2020)
print(new_date)

print(today.timetuple())

print(today.toordinal())

print(today.weekday())

print(today.isoweekday())

print(today.isocalendar())

print(today.isoformat())

print(today.ctime())

# date to string formatting
print(today.strftime('%Y/%m/%d'))

# string to date instance
from datetime import datetime
dt = datetime.strptime('2018/09/18', '%Y/%m/%d').date()
print(type(dt))
print(dt)
