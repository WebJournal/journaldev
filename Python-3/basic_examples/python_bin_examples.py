x = 10
y = bin(x)
print(type(y))
print(bin(x))

x = 0b110 # 6
print(bin(x))

x = 0xF # 15
print(bin(x))

x = 0o70 # 56
print(bin(x))

x = 10
print(format(x, '#b'))
print(format(x, 'b'))
x= 0xF
print(format(x, 'b'))
print(f'{x:b}')

# bin() with float
# x = 10.5
# print(bin(x))

# bin() with object
class Person:
    id = 0
    def __init__(self, i):
        self.id = i

    def __index__(self):
        return self.id

p = Person(10)
print(bin(p))