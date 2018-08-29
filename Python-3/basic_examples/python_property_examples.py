class Person:

    def __init__(self):
        self._name = None

    def get_name(self):
        print('get_name called')
        return self._name

    def set_name(self, i):
        print('set_name called')
        self._name = i

    def del_name(self):
        print('del_name called')
        del self._name

    name = property(get_name, set_name, del_name, "Person's Name Attribute")

    # for non-deletable attribute
    # name = property(get_name, set_name, None)

    # for read-only attribute
    # name = property(get_name, None)


p = Person()

p.name = 'Pankaj'

print(p.name)

del p.name


# Using @property decorator to achieve same results

class Data:
    def __init__(self):
        self._id = None

    @property
    def id(self):
        print('id getter')
        return self._id

    @id.setter
    def id(self, i):
        print('id setter')
        self._id = i

    @id.deleter
    def id(self):
        print('id deleter')
        del self._id


d = Data()

d.id = 100
print(d.id)

del d.id
