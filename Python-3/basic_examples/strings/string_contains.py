s = 'abc'

print('s contains a =', s.__contains__('a'))
print('s contains A =', s.__contains__('A'))
print('s contains X =', s.__contains__('X'))

print(str.__contains__('ABC', 'A'))
print(str.__contains__('ABC', 'D'))


input_str1 = input('Please enter first input string\n')

input_str2 = input('Please enter second input string\n')

print('First Input String Contains Second String? ', input_str1.__contains__(input_str2))
