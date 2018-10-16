s = 'abcd1234dcba'

print(s.find('a'))
print(s.find('cd'))
print(s.find('1', 0, 5))
print(s.find('1', 0, 2))

print(s.rfind('a'))
print(s.rfind('a', 0, 20))
print(s.rfind('cd'))
print(s.rfind('1', 0, 5))
print(s.rfind('1', 0, 2))


def find_all_indexes(input_str, search_str):
    l1 = []
    length = len(input_str)
    index = 0
    while index < length:
        i = input_str.find(search_str, index)
        if i == -1:
            return l1
        l1.append(i)
        index = i + 1
    return l1


s = 'abaacdaa12aa2'
print(find_all_indexes(s, 'a'))
print(find_all_indexes(s, 'aa'))
