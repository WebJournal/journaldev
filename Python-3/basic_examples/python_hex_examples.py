print(hex(255))
print(hex(0b111))
print(hex(0o77))
print(hex(0XFF))


class Data:
    id = 0

    def __index__(self):
        print('__index__ function called')
        return self.id


d = Data()
d.id = 100

print(hex(d))
