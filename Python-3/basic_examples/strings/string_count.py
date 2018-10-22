s = 'I like Python programming. Python is Awesome!'

print(f'Number of occurrence of "Python" in String = {s.count("Python")}')

print(f'Number of occurrence of "Python" in String between index 0 to 20 = {s.count("Python", 0, 20)}')

s = input('Please enter a string:\n')

sub = input('Please enter a sub-string:\n')

print(f'Number of occurrence of "{sub}" in the "{s}" is {s.count(sub)}')
