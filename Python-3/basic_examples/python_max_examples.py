# max of string
s = 'abcCba'
print(max(s))
print('c' > 'C')

# max with tuple
tuple_numbers = (1, 2, 3, 4)
print(max(tuple_numbers))

# max of list
list_numbers = [1, 2, 3, -4]

print(max(list_numbers))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __str__(self):
        return 'Data[%s]' % self.id


def get_data_id(data):
    return data.id


# max() with objects and key argument
list_objects = [Data(1), Data(2), Data(-10)]

print(max(list_objects, key=get_data_id))

# max() with empty iterable and default value
print(max([], default=20))

# max() with arguments
print(max(1, 2, 3, 4))


# max() with arguments and key function
def str_length(s):
    return len(s)


print(max('a', 'abc', 'ab', key=str_length))

# max() with multiple iterables
x1 = [10, 20, 30]
x2 = [5, 15, 40, 25]

print(max(x1, x2, key=len))

# max() with multiple iterables objects
x1 = [Data(10), Data(20), Data(30)]
x2 = [Data(5), Data(15), Data(40), Data(25)]

max_list = max(x1, x2, key=len)
for x in max_list:
    print(x)
