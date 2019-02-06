x = 10
y = 10
z = 20

print(f'x is not equal to y = {x!=y}')

flag = x != z
print(f'x is not equal to z = {flag}')

# python is strongly typed language
s = '10'
print(f'x is not equal to s = {x!=s}')


class Data:
    id = 0
    record = ''

    def __init__(self, i, s):
        self.id = i
        self.record = s

    # def __ne__(self, other):
    #     # return true if different types
    #     if type(other) != type(self):
    #         return True
    #     if self.record != other.record:
    #         return True
    #     else:
    #         return False


d1 = Data(1, 'Java')
d2 = Data(2, 'Java')
d3 = Data(3, 'Python')

print(d1 != d2)
print(d2 != d3)
