# empty byte array
b = bytes()
print(b)

# string to bytes
# encoding is mandatory, otherwise "TypeError: string argument without an encoding"
b = bytes('abc', 'UTF-8')
print(b)

# Below code will throw error:
# TypeError: 'bytes' object does not support item assignment
# b[1] = 65  # immutable

# bytes of given size, elements initialized to null
b = bytes(5)
print(b)

# bytes from iterable
b = bytes([1, 2, 3])
print(b)
