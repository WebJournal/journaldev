class Employee:
    id = 0
    name = ''

    def __init__(self, i, n):
        self.id = i
        self.name = n


d = Employee(10, 'Pankaj')

if hasattr(d, 'name'):
    print(getattr(d, 'name'))

attr = input('\nPlease enter Employee attribute to get details:\n')

if hasattr(d, attr):
    print(attr, '=', getattr(d, attr))
else:
    print('invalid employee attribute')
