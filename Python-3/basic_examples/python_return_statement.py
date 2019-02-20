def print_something(s):
    print('Printing::', s)


output = print_something('Hi')

print(f'A function without return statement returns {output}')


# function with return statement
def add(x, y):
    result = x + y
    return result


output = add(5, 4)
print(f'Output of add(5, 4) function is {output}')


# function with return having expression
def add(x, y):
    return x + y


output = add(5, 4)
print(f'Output of add(5, 4) function is {output}')


# return boolean
def bool_value(x):
    return bool(x)


print(f'Boolean value returned by bool_value(False) is {bool_value(False)}')
print(f'Boolean value returned by bool_value(True) is {bool_value(True)}')
print(f'Boolean value returned by bool_value("Python") is {bool_value("Python")}')


# return string
def str_value(s):
    return str(s)


print(f'String value returned by str_value(False) is {str_value(False)}')
print(f'String value returned by str_value(True) is {str_value(True)}')
print(f'String value returned by str_value(10) is {str_value(10)}')


# return tuple
def create_tuple(*args):
    my_list = []
    for arg in args:
        my_list.append(arg * 10)
    return tuple(my_list)


t = create_tuple(1, 2, 3)
print(f'Tuple returned by create_tuple(1,2,3) is {t}')


# return function, Currying https://en.wikipedia.org/wiki/Currying
def get_cuboid_volume(h):
    def volume(l, b):
        return l * b * h

    return volume


volume_height_10 = get_cuboid_volume(10)
cuboid_volume = volume_height_10(5, 4)
print(f'Cuboid(5, 4, 10) volume is {cuboid_volume}')

cuboid_volume = volume_height_10(2, 4)
print(f'Cuboid(2, 4, 10) volume is {cuboid_volume}')


# return outer function
def outer(x):
    return x * 10


def my_func():
    return outer


output_function = my_func()
print(type(output_function))

output = output_function(5)
print(f'Output is {output}')


# return multiple values
def multiply_by_five(*args):
    for arg in args:
        yield arg * 5


a = multiply_by_five(4, 5, 6, 8)

print(a)
# showing the values
for i in a:
    print(i)
