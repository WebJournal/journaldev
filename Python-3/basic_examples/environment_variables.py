import os

# current environment variables
print(os.environ)

# check if an environment variable is already present?
if 'HOME' in os.environ:
    print('HOME environment variable is already defined. Value =', os.environ['HOME'])
else:
    print('HOME environment variable is not defined.')

# set an environment variable
os.environ['MYSQL_VERSION'] = '5.7.18'

# get the value of environment variable
print('MySQL Version =', os.environ['MYSQL_VERSION'])

# what if the environment variable is missing?
# print(os.environ['DATA'])  # raise KeyError(key) from None, KeyError: 'DATA'
print(os.environ.get('DATA'))  # returns None
print(os.environ.get('DATA', 'TXT'))

# os.environ['Data'] = 123  # TypeError: str expected, not int
