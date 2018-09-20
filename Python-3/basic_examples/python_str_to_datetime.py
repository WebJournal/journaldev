from datetime import datetime

# string to datetime object
datetime_str = '09/19/18 13:55:26'

datetime_object = datetime.strptime(datetime_str, '%m/%d/%y %H:%M:%S')

print(type(datetime_object))
print(datetime_object)  # printed in default format

# string to date object
date_str = '09-19-2018'

date_object = datetime.strptime(date_str, '%m-%d-%Y').date()
print(type(date_object))
print(date_object)  # printed in default formatting

# string to time object
time_str = '13::55::26'
time_object = datetime.strptime(time_str, '%H::%M::%S').time()
print(type(time_object))
print(time_object)

# time module
import time

time_obj = time.strptime(time_str, '%H::%M::%S')
print(type(time_obj))
print(time_obj)

# default formatting - "%a %b %d %H:%M:%S %Y"
print(time.strptime('Wed Sep 19 14:55:02 2018'))

# exception handling example
datetime_str = '09/19/18 13:55:26'

try:
    datetime_object = datetime.strptime(datetime_str, '%m/%d/%y')
except ValueError as ve:
    print('ValueError Raised:', ve)

time_str = '99::55::26'

try:
    time_object = time.strptime(time_str, '%H::%M::%S')
except ValueError as e:
    print('ValueError:', e)

# str to datetime with locale
import locale

locale.setlocale(locale.LC_ALL, 'de_DE')
date_str_de_DE = '10-Dezember-2018 Montag'  # de_DE locale
datetime_object = datetime.strptime(date_str_de_DE, '%d-%B-%Y %A')
print(datetime_object)
