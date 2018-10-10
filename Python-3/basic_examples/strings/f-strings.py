name = 'Pankaj'
age = 34

f_string = f'My Name is {name} and my age is {age}'

print(f_string)
print(F'My Name is {name} and my age is {age}')

name = 'David'
age = 40

# f_string is already evaluated and won't change now
print(f_string)

# f-strings can run expressions, conversions etc.
from datetime import datetime

d = datetime.now()

print(f'Age after five years will be {age+5}')  # age = 40
print(f'Name with quotes = {name!r}')  # name = David
print(f'Default Formatted Date = {d}')
print(f'Custom Formatted Date = {d:%m/%d/%Y}')

# f-strings supports raw-strings too
print(f'Default Formatted Date:\n{d}')
print(fr'Default Formatted Date:\n {d}')


# f-string with objects
class Employee:
    id = 0
    name = ''

    def __init__(self, i, n):
        self.id = i
        self.name = n

    def __str__(self):
        return f'E[id={self.id}, name={self.name}]'


emp = Employee(10, 'Pankaj')
print(emp)

print(f'Employee: {emp}\nName is {emp.name} and id is {emp.id}')


# calling function
def add(x, y):
    return x + y


print(f'Sum(10,20) = {add(10, 20)}')

# with whitespaces
print(f'   Age = {  age   }  ')

# lambda with f-string
x = -20.45
print(f'Lambda Example: {(lambda x: abs(x)) (x)}')

print(f'Lambda Square Example: {(lambda x: pow(x, 2)) (5)}')

# miscellaneous examples
print(f'{"quoted string"}')
print(f'{{ {4*10} }}')
print(f'{{{4*10}}}')
