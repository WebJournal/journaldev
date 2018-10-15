s = 'Year is '

y = 2018

# print(s + y)  # this will throw error: TypeError: can only concatenate str (not "int") to str

# other ways to concatenate string and int
print(s + str(y))

# using %
print("%s%s" % (s, y))

# using format()
print("{}{}".format(s, y))

# using f-strings, Python 3.6+ only
print(f'{s}{y}')
