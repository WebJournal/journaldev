# integers
print(format(10, '+'))
print(format(15, 'b'))

print(format(15, 'x'))
print(format(15, 'X'))

# float
print(format(.2, '%'))
print(format(10.5, 'e'))
print(format(10.5, 'e'))
print(format(10.5345678, 'f'))
print(format(10.5, 'F'))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __format__(self, format_spec):
        print('__format__ method called')
        if format_spec == 's':
            return "Data[id=%s]" % self.id
        if format_spec == 'i':
            return str(self.id)
        else:
            return 'invalid format spec'


d = Data(20)
print(format(d, 's'))
print(format(d, 'i'))
print(format(d, 'x'))
