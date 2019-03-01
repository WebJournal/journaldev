# Learn how to override comparison operators for custom objects


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __eq__(self, other):
        print('== operator overloaded')
        if isinstance(other, Data):
            return True if self.id == other.id else False
        else:
            return False

    def __ne__(self, other):
        print('!= operator overloaded')
        if isinstance(other, Data):
            return True if self.id != other.id else False
        else:
            return False

    def __gt__(self, other):
        print('> operator overloaded')
        if isinstance(other, Data):
            return True if self.id > other.id else False
        else:
            return False

    def __lt__(self, other):
        print('< operator overloaded')
        if isinstance(other, Data):
            return True if self.id < other.id else False
        else:
            return False

    def __le__(self, other):
        print('<= operator overloaded')
        if isinstance(other, Data):
            return True if self.id <= other.id else False
        else:
            return False

    def __ge__(self, other):
        print('>= operator overloaded')
        if isinstance(other, Data):
            return True if self.id >= other.id else False
        else:
            return False


d1 = Data(10)
d2 = Data(7)

print(f'd1 == d2 = {d1 == d2}')
print(f'd1 != d2 = {d1 != d2}')
print(f'd1 > d2 = {d1 > d2}')
print(f'd1 < d2 = {d1 < d2}')
print(f'd1 <= d2 = {d1 <= d2}')
print(f'd1 >= d2 = {d1 >= d2}')
