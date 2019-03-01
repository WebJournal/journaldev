# Logical and operator
x = 10
y = 20

if x > 0 and y > 0:
    print('Both x and y are positive numbers')

# same
if (x > 0) and (y > 0):
    print('Both x and y are positive numbers')

# In Python, every variable/object has a boolean value
if x and y:
    print('Both x and y have boolean value as True')


# If first expression is False, then next one is not evaluated
class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __bool__(self):
        print('Data bool method called')
        return True if self.id > 0 else False


d1 = Data(-10)
d2 = Data(10)
if d1 and d2:
    print('Both d1 and d2 ids are positive')
else:
    print('At least one of d1 and d2 ids is negative')

# Logical OR operator
x = 10
y = 20

if x > 0 or y > 0:
    print('At least one of x and y is positive number')

d1 = Data(10)
d2 = Data(20)

# The expressions are evaluated until it's required
if d1 or d2:
    print('At least one of d1 and d2 id is a positive number')
else:
    print('Both d1 and d2 id are negative')

d1 = Data(-10)
d2 = Data(-20)

# The expressions are evaluated until it's required
if d1 or d2:
    print('At least one of d1 and d2 id is a positive number')
else:
    print('Both d1 and d2 id are negative')

# Logical not operator
a = 37
if not (a % 3 == 0 or a % 4 == 0):
    print('37 is not divisible by either 3 or 4')


# combination of multiple operators
def my_bool(data):
    print('Data bool method called, id =', data.id)
    return True if data.id > 0 else False


Data.__bool__ = my_bool

d1 = Data(10)
d2 = Data(-20)
d3 = Data(20)

# evaluated from left to right, confirmed from the __bool__() print statement
if d1 and d2 or d3:
    print('At least one of them have a positive id.')
