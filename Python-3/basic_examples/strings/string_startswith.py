s = 'Python is Awesome'

# without start and end
print(s.startswith('Python'))

# with start index
print(s.startswith('Python', 3))
print(s.startswith('hon', 3))

# with start and end index
print(s.startswith('is', 7, 10))
print(s.startswith('Python is', 0, 10))
print(s.startswith('Python is', 0, 5))

# prefix as tuple
print(s.startswith(('is', 'Python')))
print(s.startswith(('is', 'hon'), 7))



