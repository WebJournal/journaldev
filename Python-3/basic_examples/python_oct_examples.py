print(oct(10))

print(oct(0xF))

print(oct(0b1111))

print(type(oct(10)))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __index__(self):
        return self.id


d = Data(20)

print(oct(d))
