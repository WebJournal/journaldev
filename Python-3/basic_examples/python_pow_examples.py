# pow() with integers
print(pow(10, 2))
print(pow(-10, 3))
print(pow(10, 2, 3))

# pow() with floats
print(pow(100, -1))

print(pow(100.0, 2))

# pow() with different formats
print(pow(0b11, 2))  # 0b11 = 3
print(pow(0b11, 2, 2))

print(pow(0o11, 2))  # 0o11 = 9
print(pow(0o11, 2, 2))

print(pow(0xF, 2))  # 0xF = 15
print(pow(0xF, 2, 2))

# pow() with complex numbers
print(pow(2 + 3j, 2))

# print(pow(2 + 3j, 2, 3))  # ValueError: complex modulo

# print(pow(100.0, 2, 3))  # TypeError: pow() 3rd argument not allowed unless all arguments are integers

# print(pow(100, -1, 2))  # ValueError: pow() 2nd argument cannot be negative when 3rd argument specified
