s = 'Hello'

# rjust() examples
s1 = s.rjust(20)
print(f'***{s1}***')

s1 = s.rjust(20, '#')
print(f'***{s1}***')

s1 = s.rjust(20, 'ç')
print(f'***{s1}***')

s1 = s.rjust(4)
print(f'***{s1}***')  # when string size is more than specified width, original string is returned


# ljust() examples
s = 'Hello'

s1 = s.ljust(20)
print(f'***{s1}***')

s1 = s.ljust(20, '#')
print(f'***{s1}***')

s1 = s.ljust(20, 'ç')
print(f'***{s1}***')

s1 = s.ljust(4)
print(f'***{s1}***')  # when string size is more than specified width, original string is returned

# some error scenarios

# s.ljust('#')  # TypeError: 'str' object cannot be interpreted as an integer
# s.rjust('#')  # TypeError: 'str' object cannot be interpreted as an integer


# s1 = s.ljust()  # TypeError: ljust() takes at least 1 argument (0 given)
# s1 = s.rjust()  # TypeError: rjust() takes at least 1 argument (0 given)


# s.ljust(20, '#$')  # TypeError: The fill character must be exactly one character long
# s.rjust(20, '#$')  # TypeError: The fill character must be exactly one character long