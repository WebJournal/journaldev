s = 'Java\nPython\nAndroid'

lines = s.splitlines()
print(lines)

lines = s.splitlines(keepends=True)
print(lines)

# \r\n is treated as a single line boundary
s = 'Java\n\n\n\nPython\n\r\nAndroid'
lines = s.splitlines()
print(lines)

lines = s.splitlines(keepends=True)
print(lines)

s = 'A\tB\vC\fD'
lines = s.splitlines()
print(lines)

lines = s.splitlines(keepends=True)
print(lines)

s = 'A\x1cB\x1dC\x1eD\x85E\u2028F\u2029G'
lines = s.splitlines()
print(lines)

lines = s.splitlines(keepends=True)
print(lines)

# split() vs splitlines()
print("".split('\n'))
print("".splitlines())

print("Hi\n".split('\n'))
print("Hi\n".splitlines())
