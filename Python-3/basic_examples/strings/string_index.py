s = 'abcd1234dcba'

print(s.index('a'))
print(s.index('cd'))
print(s.index('1', 0, 5))

try:
    print(s.index('1', 0, 2))
except ValueError as ve:
    print(ve)

print(s.rindex('a'))
print(s.rindex('cd'))
print(s.rindex('1', 0, 5))

try:
    print(s.rindex('1', 0, 2))
except ValueError as ve:
    print(f'Error Message = {ve}')


def find_all_indexes(input_str, search_str):
    l1 = []
    length = len(input_str)
    position = 0
    while position < length:
        try:
            i = input_str.index(search_str, position)
            l1.append(i)
            position = i + 1
        except ValueError as ve1:
            # finally exception will be raised because all the indexes are found
            return l1


s = 'abaacdaa12aa2'
print(find_all_indexes(s, 'a'))
print(find_all_indexes(s, 'aa'))
