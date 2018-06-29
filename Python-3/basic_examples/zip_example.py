list1 = ['Alpha', 'Beta', 'Gamma', 'Sigma']
list2 = ['one', 'two', 'three']

test = zip(list1, list2)  # zip the values

testList = list(test)

a, b = zip(*testList)

print('The first list was ', list(a));
print('The second list was ', list(b));
