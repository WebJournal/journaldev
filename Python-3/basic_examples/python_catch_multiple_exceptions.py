import math


def square(x):
    if int(x) is 0:
        raise ValueError('Input argument cannot be zero')
    if int(x) < 0:
        raise TypeError('Input argument must be positive integer')
    return math.pow(int(x), 2)


# while True:
#
#     try:
#         y = square(input('Please enter a number\n'))
#         print(y)
#     except ValueError as ve:
#         print(type(ve), '::', ve)
#     except TypeError as te:
#         print(type(te), '::', te)


while True:

    try:
        y = square(input('Please enter a number\n'))
        print(y)
    except (ValueError, TypeError) as e:
        print(type(e), '::', e)

