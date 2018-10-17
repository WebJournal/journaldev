s = 'ABCDBCA'

translation = s.maketrans({ord('A'): 'a', ord('B'): ord('b')})
print(s.translate(translation))

translation = s.maketrans('A', 'a')

print(s.translate(translation))

translation = s.maketrans('ABCD', 'abcd')
print(s.translate(translation))

# translation = s.maketrans('AB', 'a')  # ValueError: the first two maketrans arguments must have equal length
# translation = s.maketrans('AB', 'ab', 'CD', 'c')  #TypeError: maketrans() takes at most 3 arguments (4 given)

translation = s.maketrans('AB', 'ab', 'ACD')
print(s.translate(translation))

# providing dict as translation for characters
print(s.translate({ord('A'): ord('a'), ord('B'): ord('b'), ord('C'): None}))
print(s.translate({ord('A'): 'X', ord('B'): 'YZ', ord('C'): None}))
