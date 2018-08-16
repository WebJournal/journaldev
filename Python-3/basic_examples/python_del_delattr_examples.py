class Employee:
    # class variables
    id = -1
    name = ''

    def __init__(self, i, n, r):
        self.id = i
        self.name = n
        self.role = r  # instance variable

    def __str__(self):
        return "Employee[id={}, name={}, role={}]".format(self.id, self.name, self.role)


e = Employee(10, 'Pankaj', 'CEO')
print(e)
print(e.id)
print(e.name)
print(e.role)

delattr(e, 'id')
# del e.id
print(e)
print(e.id)

delattr(e, 'name')
# del e.name
print(e.name)

# set to None vs del/delattr
e.role = None
print('Role =', e.role)

del e.role
e.role = 'CEO'
print('Role =', e.role)

# del e.role
# print(e.role)  # AttributeError: 'Employee' object has no attribute 'role'

# delattr(e, 'role')
# print(e.role)  # AttributeError: 'Employee' object has no attribute 'role'

# deleting an already deleted attribute
e = Employee(20, 'Lisa', 'Editor')

del e.id
# del e.id # AttributeError: id

delattr(e, 'name')
# delattr(e, 'name')  # AttributeError: name

# deleting non existing attribute
# del e.x  # AttributeError: x
# delattr(e, 'x')  # AttributeError: x

# delattr() benefit with dynamic attribute deletion
e = Employee(20, 'Lisa', 'Editor')

print(e)
attr = input('Please enter attribute to delete, valid values are id, name and role\n')
delattr(e, attr)
print(e)
