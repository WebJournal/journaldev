class Data:
    pass


d = Data()

d.id = 10

print(d.id)

setattr(d, 'id', 20)
print(d.id)

# setattr with dynamic programming
d = Data()
attr_name = input('Enter the attribute name:\n')
attr_value = input('Enter the attribute value:\n')

setattr(d, attr_name, attr_value)

print('Data attribute =', attr_name, 'and its value =', getattr(d, attr_name))


class Person:

    def __init__(self):
        self._name = None

    def get_name(self):
        print('get_name called')
        return self._name

    # for read-only attribute
    name = property(get_name, None)


p = Person()

# below will throw exception "AttributeError: can't set attribute"
# setattr(p, 'name', 'Pankaj')
