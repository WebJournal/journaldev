set1 = set('abcde')

set2 = set('ae')

print(set1)
print(set2)

# two sets intersection
print(set1.intersection(set2))

# multiple sets intersection
set3 = {'a'}
print(set1.intersection(set2, set3))

# intersection() without arguments
set1 = set('ab')
set4 = set1.intersection()
print(set4)
# check if shallow copy or deep copy
set1.add('0')
set1.remove('a')
set4.add('c')
print(set1)
print(set4)
