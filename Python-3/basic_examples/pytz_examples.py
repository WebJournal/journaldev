import pytz
from datetime import datetime

# prints all supported timezone list by pytz
print('all_timezones =', pytz.all_timezones, '\n')
print('all_timezones_set =', pytz.all_timezones_set, '\n')
print('common_timezones =', pytz.common_timezones, '\n')
print('common_timezones_set =', pytz.common_timezones_set, '\n')

print('country_names =')
for key, val in pytz.country_names.items():
    print(key, '=', val, end=',')
print('\n')
print('IN full name =', pytz.country_names['IN'])

print('country_timezones =')
for key, val in pytz.country_timezones.items():
    print(key, '=', val, end=',')
print('\n')
print('Supported timezones by US =', pytz.country_timezones['US'])

# getting utc timezone
utc = pytz.utc

# getting timezone by name
ist = pytz.timezone('Asia/Kolkata')

# getting datetime of specified timezone
print('UTC Time =', datetime.now(tz=utc))
print('IST Time =', datetime.now(tz=ist))

# using localize() function, my system is on IST timezone
local_datetime = ist.localize(datetime.now())
print('IST Current Time =', local_datetime.strftime('%Y-%m-%d %H:%M:%S %Z%z'))
print('Wrong UTC Current Time =', utc.localize(datetime.now()).strftime('%Y-%m-%d %H:%M:%S %Z%z'))

# converting IST to UTC
utc_datetime = local_datetime.astimezone(utc)
print('IST Current Time =', local_datetime.strftime('%Y-%m-%d %H:%M:%S %Z%z'))
print('UTC Time =', utc_datetime.strftime('%Y-%m-%d %H:%M:%S %Z%z'))

