import arrow

# getting current time in different timezones
utc_time = arrow.utcnow()
print('Current UTC Time =', utc_time)

ist_time = arrow.now('Asia/Calcutta')
print('Current IST Time =', ist_time)
print('tzinfo =', ist_time.tzinfo)

local_time = arrow.now()
print('Current Local Time =', local_time)

# converting one timezone to another
pst_time = ist_time.to('US/Pacific')
print('Current PST Time =', pst_time)

# date to timestamp
print('Current Local Timestamp =', local_time.timestamp)

# converting date to formatted string
print('Formatted Date =', local_time.format())
print('Specific Formatted Date =', local_time.format('YYYY-MM-DD HH:mm:ss ZZ'))

# date from timestamp
dt = arrow.get(1537941232)
print('Date from Timestamp =', dt)

# parse string to date
dt = arrow.get('2013-05-05 12:30:45', 'YYYY-MM-DD HH:mm:ss')
print(type(dt))
print(dt)

# instantiating date from arguments
dt = arrow.get(2018, 9, 26)
print(dt)

# datetime manipulations
utc_time = arrow.utcnow()
print('Current UTC Time =', utc_time)
utc_time_updated = utc_time.replace(year=2019, month=6)
print('Updated UTC Time =', utc_time_updated)
utc_time_updated = utc_time.shift(years=-2, weeks=4)
print('Updated UTC Time =', utc_time_updated)

# human readable formatting
past = arrow.utcnow().shift(hours=-1)
print(past.humanize())
future = arrow.utcnow().shift(hours=+1)
print(future.humanize())
print(future.humanize(locale='de_DE'))
print(future.humanize(past))

# creating arrow instance from datetime
from datetime import datetime
dt = datetime.now()
arrow_dt = arrow.Arrow.fromdate(dt)
print(dt)
print(arrow_dt)


