s = 'abc12321cba'

print(s.replace('a', ''))

s = 'abc12321cba'

print(s.translate({ord('a'): None}))

print(s.translate({ord(i): None for i in 'abc'}))

# removing spaces from a string
s = ' 1 2 3 4 '
print(s.replace(' ', ''))
print(s.translate({ord(i): None for i in ' '}))

# remove substring from string
s = 'ab12abc34ba'
print(s.replace('ab', ''))

# remove newline
s = 'ab\ncd\nef'
print(s.replace('\n', ''))
print(s.translate({ord('\n'): None}))

# remove specific number of times
s = 'abababab'
print(s.replace('a', 'A', 2))
