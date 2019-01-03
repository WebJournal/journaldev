s = 'Hello World 2019'

parts_tuple = s.partition('World')
print(parts_tuple)

parts_tuple = s.partition('2018')
print(parts_tuple)

# rpartition
s = 'Hello World 2019'

parts_tuple = s.rpartition('World')
print(parts_tuple)

parts_tuple = s.rpartition('2018')
print(parts_tuple)

# partition() and rpartition() difference
s = 'ABCBA'
parts_tuple = s.partition('B')
print(parts_tuple)

parts_tuple = s.rpartition('B')
print(parts_tuple)
