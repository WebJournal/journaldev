s = slice(1, 10, 2)  # indexes 1,3,5,7,9
print(type(s))
print(s.start)
print(s.stop)
print(s.step)

s = slice(5)  # indexes 0,1,2,3,4
print(s.start)
print(s.stop)
print(s.step)

# slice string
s = slice(1, 10, 2)  # indexes 1,3,5,7,9
print('abcde'[s])

# slice with negative indexes
s = slice(-1, -3, -1)  # indexes -1, -2
print('abcde'[s])

# python slice list/array
s = slice(0, 3)  # indexes 0, 1, 2
my_list = [1, 2, 3, 4, 5, 6]
print(my_list[s])

# python slice tuple
s = slice(2)
my_tuple = [1, 2, 3, 4, 5, 6]
print(my_tuple[s])

# slice using extended indexing syntax
x = 'abcde'
y = x[1:3:1]  # 1,2
print(y)

y = x[1:3]  # 1,2
print(y)

y = x[2:]  # 2 to length of sequence
print(y)

y = x[:5:2]  # 0,2,4
print(y)

y = x[:]  # copy of sequence
print(y)

y = x[-1:-4:-1]  # reverse iteration, end to start
print(y)
