# Boolean and None examples
from decimal import Decimal
from fractions import Fraction

x = True
b = bool(x)

print(type(x))  # <class 'bool'>
print(type(b))  # <class 'bool'>
print(b)  # True

x = False
b = bool(x)
print(b)  # False

x = None
b = bool(x)

print(type(x))  # <class 'NoneType'>
print(type(b))  # <class 'bool'>
print(b)  # False

# string examples
x = 'True'
b = bool(x)

print(type(x))  # <class 'str'>
print(type(b))  # <class 'bool'>
print(b)  # True

x = 'False'
b = bool(x)
print(b)  # True because len() is used

x = ''
print(bool(x))  # False, len() returns 0

# bool() with numbers
print(bool(10))  # True
print(bool(10.55))  # True
print(bool(0xF))  # True
print(bool(10 - 4j))  # True

print(bool(0))  # False
print(bool(0.0))  # False
print(bool(0j))  # False
print(bool(Decimal(0)))  # False
print(bool(Fraction(0, 2)))  # False

# bool() with collections and sequences
tuple1 = ()
dict1 = {}
list1 = []
print(bool(tuple1))  # False
print(bool(dict1))  # False
print(bool(list1))  # False


# bool() with custom object
class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    # returns True for id > 0 else False
    def __bool__(self):
        print('bool function called')
        return self.id > 0

    # returns 0 for id <= 0, else id
    def __len__(self):
        print('len function called')
        if self.id > 0:
            return self.id
        else:
            return 0


d = Data(0)
print(bool(d))
d = Data(10)
print(bool(d))
