print('\ndir() with no argument\n')
print(dir())

print('\ndir() with tuple argument\n')
t = (1, 2)
print(dir(t))

print('\ndir() with list argument\n')
l = [1, 2]
print(dir(l))


class Data:
    id = 0
    name = ''


print('\ndir() with custom object argument\n')
d = Data()
print(dir(d))

from collections import namedtuple

n = namedtuple('Vowels', 'a,e,i,o,u')
print('\ndir() with module object argument\n')
print(dir(n))


class Color:

    def __dir__(self):
        print('__dir__() function called')
        return ['Red', 'Green', 'Blue']


print('\ndir() with __dir__ method defined in object\n')
c = Color()
print(dir(c))
