obj = object()

print(type(obj))

print(dir(obj))

print(obj.__hash__())

# obj.i = 10  # AttributeError: 'object' object has no attribute 'i'

# setattr(obj, 'name', 'pankaj')  # AttributeError: 'object' object has no attribute 'name'
