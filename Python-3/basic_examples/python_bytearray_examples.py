# empty byte array
b = bytearray()
print(b)

# string to bytearray
# encoding is mandatory, otherwise "TypeError: string argument without an encoding"
b = bytearray('abc', 'UTF-8')
print(b)
b[1] = 65  # mutable
print(b)
# bytearray of given size, elements initialized to null
b = bytearray(5)
print(b)

# bytearray from iterable
b = bytearray([1, 2, 3])
print(b)
