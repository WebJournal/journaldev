fs = frozenset()
print(fs)
print(type(fs))

# frozenset from iterable
list_vowels = ['A', 'E', 'I', 'O', 'U']
fs = frozenset(list_vowels)
print(fs)

tuple_numbers = (1, 2, 3, 4, 5, 4, 3)
fs = frozenset(tuple_numbers)
print(fs)

# frozenset iteration
fs = frozenset([1, 2, 3, 4, 5, 4, 3])
for x in fs:
    print(x)

# frozenset functions
# since frozen set is immutable, add(), remove(), update(), pop() etc. functions are not defined
fs = frozenset([1, 2, 3, 4, 5])
size = len(fs)
print('frozenset size =', size)

contains_item = 5 in fs
print('fs contains 5 =', contains_item)

not_contains_item = 6 not in fs
print('fs not contains 6 =', not_contains_item)

is_disjoint = fs.isdisjoint(frozenset([1, 2]))
print(is_disjoint)

is_disjoint = fs.isdisjoint(frozenset([10, 20]))
print(is_disjoint)

is_subset = fs.issubset(set([1, 2]))
print(is_subset)

is_subset = fs.issubset(set([1, 2, 3, 4, 5, 6, 7]))
print(is_subset)

is_superset = fs.issuperset(frozenset([1, 2]))
print(is_superset)

is_superset = fs.issuperset(frozenset([1, 2, 10]))
print(is_superset)

fs1 = fs.union(frozenset([1, 2, 10]), set([99, 98]))
print(fs1)

fs1 = fs.intersection(set((1, 2, 10, 20)))
print(fs1)

fs1 = fs.difference(frozenset([1, 2, 3]))
print(fs1)

fs1 = fs.symmetric_difference(frozenset([1, 2, 10, 20]))
print(fs1)

fs1 = fs.copy()
print(fs1)

# python frozenset to list, tuple
fs = frozenset([1, 2, 3, 4, 5])
l1 = list(fs)
print(l1)

t1 = tuple(fs)
print(t1)
