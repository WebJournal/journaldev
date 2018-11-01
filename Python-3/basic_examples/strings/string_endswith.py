s = 'I Love Python'

# without start and end
print(s.endswith('Python'))  # True

# with start index
print(s.endswith('Python', 2))  # True
print(s.endswith('Python', 9))  # False

# with start and end index
print(s.endswith('hon', 7, len(s)))  # True
print(s.endswith('Pyt', 0, 10))  # True
print(s.endswith('Python', 8))  # False

# suffix as tuple
print(s.endswith(('is', 'Python')))  # True
print(s.endswith(('Love', 'Python'), 1, 6))  # True
