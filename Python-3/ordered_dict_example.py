from collections import OrderedDict

# creating a simple dict
my_dict = {'kiwi': 4, 'apple': 5, 'cat': 3}

# creating empty ordered dict
ordered_dict = OrderedDict()
print(ordered_dict)

# creating ordered dict from dict
ordered_dict = OrderedDict(my_dict)
print(ordered_dict)

# adding elements to dict
ordered_dict['dog'] = 3

# replacing a dict key value
ordered_dict['kiwi'] = 10
print(ordered_dict)

# removing and adding a value
ordered_dict.pop('kiwi')
print(ordered_dict)
ordered_dict['kiwi'] = 4
print(ordered_dict)

# moving apple to end and dog to start
ordered_dict.move_to_end('apple')
ordered_dict.move_to_end('dog', False)
print(ordered_dict)

# pop last item
item = ordered_dict.popitem(True)
print(item)
print(ordered_dict)

# reversed iteration
for item in reversed(ordered_dict):
    print(item)

# equality tests
d1 = {'a': 'A', 'b': 'B'}
d2 = {'b': 'B', 'a': 'A'}

# From python 3.6 onwards, order is retained for keyword arguments passed to the OrderedDict constructor
# Reference: https://www.python.org/dev/peps/pep-0468/
od1 = OrderedDict({'a': 'A', 'b': 'B'})
od2 = OrderedDict({'b': 'B', 'a': 'A'})

print(d1 == d2)
print(od1 == od2)
print(d1 == od1)