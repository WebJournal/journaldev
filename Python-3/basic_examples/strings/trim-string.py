s1 = '  abc  '

print(f'String =\'{s1}\'')

print(f'After Removing Leading Whitespaces String =\'{s1.lstrip()}\'')

print(f'After Removing Trailing Whitespaces String =\'{s1.rstrip()}\'')

print(f'After Trimming Whitespaces String =\'{s1.strip()}\'')


# string with new line
s1 = '  X\n  Y  \nZ  \t'
print(s1)
print(s1.strip())

