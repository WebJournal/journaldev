s = 'My Name is Pankaj'

# create substring using slice
name = s[11:]
print(name)

# list of substrings using split
l1 = s.split()
print(l1)

# if present or not
if 'Name' in s:
    print('Substring found')

if s.find('Name') != -1:
    print('Substring found')

# substring count
print('Substring count =', s.count('a'))

s = 'This Is The Best Theorem'
print('Substring count =', s.count('Th'))


# substring index positions
def find_all_indexes(input_str, substring):
    l2 = []
    length = len(input_str)
    index = 0
    while index < length:
        i = input_str.find(substring, index)
        if i == -1:
            return l2
        l2.append(i)
        index = i + 1
    return l2


print(find_all_indexes(s, 'Th'))
