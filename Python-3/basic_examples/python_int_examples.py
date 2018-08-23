# int from numbers
x = int()
print(type(x))
print(x)

print(int(0xF))
print(int(0b111))

# int from float
x = int(10.043)
print(x)

x = int(10.8901)
print(x)

# int from string
x = int("5")
print(x)

x = int("-0xf", base=16)
print(x)

x = int("0b111", base=2)
print(x)

# int from bytes and bytearray
x = int(bytes("-0xf", "utf-8"), 16)
print(x)

x = int(bytearray("-20", "utf-8"))
print(x)


# int from object
class Emp:
    id = 0

    def __int__(self):
        print('__int__ function called')
        return self.id

    def __trunc__(self):
        print('__trunc__ function called')
        return self.id


x = Emp()
x.id = 100
print(int(x))
