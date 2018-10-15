s = 'abc'

print(len(s))

# special characters
s = 'AåB∫Cç'
print(len(s))

# new line, tabs, whitespaces, escape characters
s = '  A  '
print(len(s))

s = 'A\t\t'
print(len(s))

s = 'A\n\nB'
print(len(s))

s = 'A\'B'
print(len(s))

# raw string length
s = r'A\t\t'
print(len(s))
print(s)

# str.__len__() function
print(str.__len__('ABC'))
print('abc'.__len__())

# user input string length
s = input('Please enter a string:\n')
print('Input String Length =', len(s))

