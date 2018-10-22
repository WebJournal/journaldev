l1 = ['A', 'B', 'C', 'D', 'A', 'A', 'C']

# string in list
if 'A' in l1:
    print('A is present in the list')

# string not in list
if 'X' not in l1:
    print('X is not present in the list')

l1 = ['A', 'B', 'C', 'D', 'A', 'A', 'C']
s = input('Please enter a character A-Z:\n')

if s in l1:
    print(f'{s} is present in the list')
else:
    print(f'{s} is not present in the list')

# using count() function
l1 = ['A', 'B', 'C', 'D', 'A', 'A', 'C']
s = 'A'

count = l1.count(s)
if count > 0:
    print(f'{s} is present in the list for {count} times.')

# finding all indexes of string in the list
l1 = ['A', 'B', 'C', 'D', 'A', 'A', 'C']
s = 'A'
matched_indexes = []
i = 0
length = len(l1)

while i < length:
    if s == l1[i]:
        matched_indexes.append(i)
    i += 1

print(f'{s} is present in {l1} at indexes {matched_indexes}')
