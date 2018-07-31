## NOTE: Requires Python 3.7 or higher

from collections import namedtuple

emp1 = ('Pankaj', 35, 'Editor')
emp2 = ('David', 40, 'Author')

for p in [emp1, emp2]:
    print(p)

for p in [emp1, emp2]:
    print(p[0], 'is a', p[1], 'years old working as', p[2])

# pythonic way
for p in [emp1, emp2]:
    print('%s is a %d years old working as %s' % p)

# converting to namedtuple
# Employee = namedtuple('Employee', 'name age role')
# Employee = namedtuple('Employee', 'name,age,role')

Employee = namedtuple('Employee', ['name', 'age', 'role'])

emp1 = Employee('Pankaj', 35, 'Editor')
emp2 = Employee(name='David', age=40, role='Author')

for p in [emp1, emp2]:
    print(p)

# accessing via index value
for p in [emp1, emp2]:
    print('%s is a %d years old working as %s' % p)

# accessing via name of the field
for p in [emp1, emp2]:
    print(p.name, 'is a', p.age, 'years old working as', p.role)

# namedtuple invalid keys and rename parameter
try:
    Person = namedtuple('Person', 'def class')
except ValueError as error:
    print(error)

# rename=True will rename invalid names to index value with underscore prefix
Person = namedtuple('Person', 'name def class', rename=True)
print(Person._fields)

# namedtuple module parameter - introduced in 3.6
Person = namedtuple('Person', 'name', module='MyPersonModule')
print(Person.__module__)

# namedtuple additional methods

# _make(iterable)
t = ('Lisa', 35, 'Contributor')
emp3 = Employee._make(t)
print(emp3)

# _asdict()
od = emp3._asdict()
print(od)

# _replace(**kwargs)
emp3 = emp3._replace(name='Lisa Tamaki', age=40)
print(emp3)

# namedtuple additional attributes

# _fields

print(emp3._fields)
Gender = namedtuple('Gender', 'gender')
Person = namedtuple('Person', Employee._fields + Gender._fields)
print(Person._fields)

# _fields_defaults - introduced in Python 3.7
# Python 3.7 removed verbose parameter and _source attribute

Person1 = namedtuple('Person1', ['name', 'age'], defaults=['Pankaj', 20])
print(Person1._fields_defaults)

# Miscellaneous examples

# getattr
emp3_name = getattr(emp3, 'name')
print(emp3_name)

# Dict to Named Tuple
d = {'age': 10, 'name': 'pankaj', 'role':'CEO'}
emp4 = Employee(**d)
print(d)
print(emp4)