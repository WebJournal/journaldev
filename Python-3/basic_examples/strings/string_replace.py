s = 'Java is Nice'

# simple string replace example
str_new = s.replace('Java', 'Python')
print(str_new)

# replace character in string
s = 'dododo'
str_new = s.replace('d', 'c')
print(str_new)

# replace with specified count
str_new = s.replace('d', 'c', 2)
print(str_new)

# str.replace example
print(str.replace('abca', 'a', 'A'))

# string replace with user input example
input_str = input('Please provide input data\n')
delimiter = input('Please provide current delimiter\n')
delimiter_new = input('Please provide new delimiter\n')
output_str = input_str.replace(delimiter, delimiter_new)
print('Updated Data =', output_str)
