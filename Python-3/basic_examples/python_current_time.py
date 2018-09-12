from datetime import datetime

# Current date time in local system
print(datetime.now())

# only current date
print(datetime.date(datetime.now()))

# only current time in local system
print(datetime.time(datetime.now()))

# current date time in specific timezone using pytz module
import pytz

utc = pytz.utc
pst = pytz.timezone('America/Los_Angeles')
ist = pytz.timezone('Asia/Calcutta')

print('Current Date Time in UTC =', datetime.now(tz=utc))
print('Current Date Time in PST =', datetime.now(pst))
print('Current Date Time in IST =', datetime.now(ist))

# print(pytz.all_timezones)

# pendulum module to get current date and time in specific timezones
import pendulum

# print(pendulum.timezones)

utc = pendulum.timezone('UTC')
pst = pendulum.timezone('America/Los_Angeles')
ist = pendulum.timezone('Asia/Calcutta')

print('Current Date Time in UTC =', datetime.now(utc))
print('Current Date Time in PST =', datetime.now(pst))
print('Current Date Time in IST =', datetime.now(ist))
