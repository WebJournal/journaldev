def print_iterator(it):
    for x in it:
        print(x, end=' ')
    print('\n')


# reversed string
r = reversed('abc')
print(type(r))
print(r)
print_iterator(r)

# reversed list
r = reversed([1, 2, 3])
print_iterator(r)

# reversed tuple
r = reversed((1, 2, 3))
print_iterator(r)

# reversed bytes
r = reversed(bytes('abc', 'utf-8'))
print_iterator(r)

# reversed bytearray
r = reversed(bytearray('abc', 'utf-8'))
print_iterator(r)


# object with __reversed__ method
class Data:
    name = ''

    def __init__(self, n):
        self.name = n

    def __reversed__(self):
        return reversed(self.name)


d = Data('ABC')

r = reversed(d)

print_iterator(r)


# object supporting sequence protocol i.e.
# implementing __len__() and __getitem__ method
class MyTupleWrapper:
    t = ()

    def __init__(self, tu):
        if not isinstance(tu, tuple):
            return ValueError('Only accepts tuple')
        self.t = tu

    def __len__(self):
        return len(self.t)

    def __getitem__(self, index):
        return self.t[index]


mt = MyTupleWrapper((1, 2, 3, 4))
r = reversed(mt)
print_iterator(r)
