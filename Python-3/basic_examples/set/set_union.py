set1 = {1, 2, 3, 4}
set2 = {2, 3, 5, 6}
set3 = {3, 4, 6, 7}

print(set1.union(set2))
print(set2.union(set3))
print(set3.union(set1))

print(set1.union(set2, set3))
#  OR
print(set1.union(set2).union(set3))
