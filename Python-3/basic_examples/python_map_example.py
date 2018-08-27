# function to be used with map()
def to_upper_case(s):
    return str(s).upper()


# utility function for pretty print iterator elements
def print_iterator(it):
    for x in it:
        print(x, end=' ')
    print('')  # for new line


# map() with string
map_iterator = map(to_upper_case, 'abc')
print(type(map_iterator))
print_iterator(map_iterator)

# map() with tuple
map_iterator = map(to_upper_case, (1, 'a', 'abc'))
print_iterator(map_iterator)

# map() with list
map_iterator = map(to_upper_case, ['x', 'a', 'abc'])
print_iterator(map_iterator)

# converting map object to list, set etc.
map_iterator = map(to_upper_case, ['a', 'b', 'c'])
my_list = list(map_iterator)
print(my_list)

map_iterator = map(to_upper_case, ['a', 'b', 'c'])
my_set = set(map_iterator)
print(my_set)

map_iterator = map(to_upper_case, ['a', 'b', 'c'])
my_tuple = tuple(map_iterator)
print(my_tuple)

# using lambda function with map
list_numbers = [1, 2, 3, 4]

map_iterator = map(lambda x: x * 2, list_numbers)
print_iterator(map_iterator)

# map() with multiple iterable arguments
list_numbers = [1, 2, 3, 4]
tuple_numbers = (5, 6, 7, 8)
map_iterator = map(lambda x, y: x * y, list_numbers, tuple_numbers)
print_iterator(map_iterator)

# map() with multiple iterable arguments of different sizes
list_numbers = [1, 2, 3, 4]
tuple_numbers = (5, 6, 7, 8, 9, 10)
map_iterator = map(lambda x, y: x * y, list_numbers, tuple_numbers)
print_iterator(map_iterator)

# map() with function None
# map_iterator = map(None, 'abc')
# print(map_iterator)
# for x in map_iterator:
#     print(x)

map_iterator = map(lambda x: x, 'abc')
print_iterator(map_iterator)
