l1 = [1, 2, 3]
print(l1)

l1 = ['A', 'B', 'C']
print(l1)

l1 = ['A', 'B', 'C', 1, 2, 3.5]
print(l1)

# stripping brackets
print(str(l1).strip('[]'))
print(str(l1)[1:-1])


class Data:
    id = 0

    def __init__(self, i):
        id = i

    def __str__(self):
        return f'D[{self.id}]'

    def __repr__(self):
        return f'Data[{self.id}]'


l1 = [Data(10), Data(20)]
print(l1)  # repr() function will be called on elements

# calling str function
print(', '.join(map(str, l1)))
print(', '.join(str(e) for e in l1))

print('|'.join(map(str, l1)))
print('#'.join(str(e) for e in l1))

