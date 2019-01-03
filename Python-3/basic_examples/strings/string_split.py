s = 'Java is Nice'

# simple string split example
str_list = s.split(sep=' ')
print(str_list)

# maxsplit example
str_list = s.split(sep=' ', maxsplit=1)
print(str_list)

# sep is not provider or None
s = '  Java  Python iOS    Android  '
str_list = s.split()
print(str_list)

# multiline string split
multiline_str = 'Hi There\nHow are you?\nI am fine'
multiline_str_split_list = multiline_str.split(sep='\n')
for s in multiline_str_split_list:
    print(s)

# multi character separator
s = 'Hi||Hello||Adios'
str_list = s.split('||')
print(str_list)

# using split() with str class
print(str.split('ABACAD', sep='A'))
print(str.split('ABACAD', sep='A', maxsplit=2))

# csv and user input example
input_csv = input('Please enter CSV Data\n')
input_csv_split_list = input_csv.split(sep=',')
print('Input Data Length =', len(input_csv_split_list))
print('List of inputs =', input_csv_split_list)

# rsplit() example
s = 'Python is Awesome'
str_list = s.rsplit(sep=' ')
print(str_list)

str_list = s.rsplit(sep=' ', maxsplit=1)
print(str_list)

s = '  Java  Python iOS    Android  '
str_list = s.rsplit()
print(str_list)

multiline_str = 'Hi There\nHow are you?\nI am fine'
multiline_str_split_list = multiline_str.rsplit(sep='\n')
for s in multiline_str_split_list:
    print(s)

s = 'Hi||Hello||Adios'
str_list = s.rsplit('||')
print(str_list)

# using split() with str class
print(str.rsplit('ABACAD', sep='A'))
print(str.rsplit('ABACAD', sep='A', maxsplit=2))

# csv and user input example
input_csv = input('Please enter CSV Data\n')
input_csv_split_list = input_csv.rsplit(sep=',')
print('Input Data Length =', len(input_csv_split_list))
print('List of inputs =', input_csv_split_list)