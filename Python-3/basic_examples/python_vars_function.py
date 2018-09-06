class Data:
    # class variables
    id = 0
    name = ''

    def __init__(self, i, n):
        self.id = i
        self.name = n
        # instance variable
        self.repr = 'Data[%s,%s]' % (i,n)


d = Data(1, 'Pankaj')

# vars of object
print(vars(d))

# update __dict__ and then call vars()
d.__dict__['id'] = 100
print(vars(d))

# vars of class
print(vars(Data))

# vars of module
import math

print(vars(math))

# vars without argument
print(vars())

