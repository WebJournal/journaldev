def add_two_numbers(a, b):
    return a + b


def add_three_numbers(a, b, c):
    return a + b + c


print(add_two_numbers(1, 2))
print(add_three_numbers(1, 2, 3))


# type of args and kwargs
def zap(*args, **kwargs):
    print(type(args))
    print(type(kwargs))


zap()


# using *args
def add(*args):
    total = 0
    for arg in args:
        total = total + arg
    return total


print(add(1, 2))
print(add(1, 2, 3))
print(add(1, 2, 3, 4))

# we can pass tuple values as *args
t = (10, 30, 60)
print(add(*t))


# using **kwargs
def kwargs_processor(**kwargs):
    for k, v in kwargs.items():
        print(f'Key={k} and Value={v}')


kwargs_processor(name='Pankaj', age=34)
kwargs_processor(country='India', capital='New Delhi')

# we can pass dict too for **kwargs
d = {'name': 'Pankaj', 'age': 34}
kwargs_processor(**d)


# Usage of *args and **kwargs
# for quickly simulating a function response
class APIHelper:

    def call_api(self, url, input_json):
        # some complex logic
        return 'complex_response_data'


class MyTestClass:

    def test_call_api(self, *args, **kwargs):
        return "test_response_data"


APIHelper.call_api = MyTestClass.test_call_api

ah = APIHelper()
print(ah.call_api())
print(ah.call_api(1, url='https://www.journaldev.com', input_json={}))
print(ah.call_api(1, 2, url='https://www.journaldev.com'))


# with decorators
def log_arguments(func):
    def inner(*args, **kwargs):
        print(f'Arguments for args:{args}, kwargs:{kwargs}')
        return func(*args, **kwargs)

    return inner


@log_arguments
def foo(x, y, z):
    return x + y + z


sum_ints = foo(1, 2, z=5)
print(sum_ints)


@log_arguments
def bar(x, *args, **kwargs):
    total = x
    for arg in args:
        total = total + arg
    for key, value in kwargs.items():
        total = total + value
    return total


sum_ints = bar(1, 2, 3, a=4, b=5)
print(sum_ints)
