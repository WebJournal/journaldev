# sum of integers
s = sum([1, 2, 3])
print(s)

# sum of integers in different formats
s = sum((1, 0b11, 0o17, 0xFF))
print(s)

s = sum((1, 0b11, 0o17, 0xFF), 0xF)
print(s)

# sum of numbers with start
s = sum([1, 2, 3], 10)
print(s)

# sum of floats
s = sum([1.5, 2.5, 3])
print(s)

# sum of complex numbers
s = sum([1 + 2j, 3 + 4j])
print(s)

s = sum([1 + 2j, 3 + 4j], 2 + 2j)
print(s)

# sum of numbers of different types
s = sum([1 + 2j, 2, 1.5 - 2j])
print(s)

# sum of bytes and bytearray of numbers
s = sum(bytes([1, 2]))
print(s)

s = sum(bytearray([1, 2]), 10)
print(s)
