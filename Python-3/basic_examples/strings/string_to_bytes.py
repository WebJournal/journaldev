s = 'abc'

# string to bytes using bytes()
b = bytes(s, encoding='utf-8')

print(type(b))
print(b)

# bytes to string using decode()
s = b.decode()
print('Original String =', s)

s = 'xyz'

# string to bytes using encode()
b = s.encode(encoding='utf-8')
print(b)

s = b.decode()
print('Original String =', s)
