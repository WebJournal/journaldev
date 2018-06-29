try:
    print('Please enter year to check for leap year')
    year = int(input())
except ValueError:
    print('Please input a valid year')
    exit(1)

if year % 400 == 0:
    print('Leap Year')
elif year % 100 == 0:
    print('Not Leap Year')
elif year % 4 == 0:
    print('Leap Year')
else:
    print('Not Leap Year')