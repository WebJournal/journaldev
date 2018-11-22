s = 'Hello'

s1 = s.center(20)
print(f'***{s1}***')

s1 = s.center(20, '#')
print(f'***{s1}***')

s1 = s.center(20, 'ç')
print(f'***{s1}***')

s1 = s.center(4)
print(f'***{s1}***')  # when string size is more than specified width, original string is returned

# s.center('#')  # TypeError: 'str' object cannot be interpreted as an integer

# s1 = s.center()  # TypeError: center() takes at least 1 argument (0 given)

# s.center(20, '#$')  # TypeError: The fill character must be exactly one character long

