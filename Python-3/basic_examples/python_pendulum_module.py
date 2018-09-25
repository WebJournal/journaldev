from datetime import datetime
import pendulum

utc = pendulum.timezone('UTC')
pst = pendulum.timezone('America/Los_Angeles')
ist = pendulum.timezone('Asia/Calcutta')

print(type(utc))
print('Current Date Time in UTC =', datetime.now(utc))
print('Current Date Time in PST =', datetime.now(pst))
print('Current Date Time in IST =', datetime.now(ist))
print(type(datetime.now(ist)))

# drop in replacement for datetime
utc_time = pendulum.now('UTC')
print(type(utc_time))
print('Current Date Time in UTC =', utc_time)

# converting to another timezone
ist_time = utc_time.in_timezone('Asia/Calcutta')
print(type(ist_time))
print('Current Date Time in IST =', ist_time)

tz = pendulum.timezone('Europe/Paris')
paris_time = tz.convert(ist_time)
print('Current Date Time in Paris =', paris_time)

# date time manipulations
utc_time.add(years=1)
utc_time.subtract(months=2)
print('Updated UTC Time', utc_time)

# support for common datetime formats
print(utc_time.to_iso8601_string())
print(utc_time.to_formatted_date_string())
print(utc_time.to_w3c_string())
print(utc_time.to_date_string())

# supports strftime() too
print(utc_time.strftime('%Y-%m-%d %H:%M:%S %Z%z'))

# parse string to date time
dt = pendulum.parse('2018-05-21T22:00:00')
print(dt)

dt = pendulum.parse('2018-05-21T22:00:00', tz='Europe/Paris')
print(dt)

# parsing using specified format string
dt = pendulum.from_format('2018/05/21', 'YYYY/MM/DD')
print(dt)

# drop in replacement for timedelta
time_delta = pendulum.duration(days=1, hours=10, years=2)
print(time_delta)
print('time_delta years =', time_delta.years)

print('time_delta in seconds =', time_delta.in_seconds())
print('time_delta in words =', time_delta.in_words())

print('future date =', pendulum.now() + time_delta)

# period of time
current_date = pendulum.now()
future_date = current_date.add(days=4)

period_time = future_date - current_date

print('period in words =', period_time.in_words())

# period is iterable with days
for dt in period_time:
    print(dt)


