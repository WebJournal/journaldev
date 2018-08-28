# min of string
s = 'abcC'
print(min(s))
for c in s:
    print(c, 'unicode value =', ord(c))

# min with tuple
tuple_numbers = (1, 2, 3, 4)
print(min(tuple_numbers))

# min of list
list_numbers = [1, 2, 3, -4]

print(min(list_numbers))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __str__(self):
        return 'Data[%s]' % self.id


def get_data_id(data):
    return data.id


# min() with objects and key argument
list_objects = [Data(1), Data(2), Data(-10)]

print(min(list_objects, key=get_data_id))

# min() with empty iterable and default value
print(min([], default=20))

# min() with arguments
print(min(1, 2, 3, 4))


# min() with arguments and key function
def str_length(s):
    return len(s)


print(min('a', 'abc', 'b', key=str_length))

# min() with multiple iterables
x1 = [10, 20, 30]
x2 = [5, 15, 40, 25]

print(min(x1, x2, key=len))

# min() with multiple iterables objects
x1 = [Data(10), Data(20), Data(30)]
x2 = [Data(5), Data(15), Data(40), Data(25)]

min_list = min(x1, x2, key=len)
for x in min_list:
    print(x)
