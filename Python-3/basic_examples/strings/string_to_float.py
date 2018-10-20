s = '10.5674'

f = float(s)

print(type(f))
print('Float Value =', f)

input_1 = input('Please enter first floating point value:\n')
input_1 = float(input_1)

input_2 = input('Please enter second floating point value:\n')
input_2 = float(input_2)

print(f'Sum of {input_1} and {input_2} is {input_1+input_2}')

f1 = 10.23
f2 = 20.34
f3 = 30.45

# using f-string from Python 3.6+, change to format() for older versions
print(f'Concatenation of {f1} and {f2} is {str(f1) + str(f2)}')
print(f'CSV from {f1}, {f2} and {f3}:\n{str(f1)},{str(f2)},{str(f3)}')
print(f'CSV from {f1}, {f2} and {f3}:\n{", ".join([str(f1),str(f2),str(f3)])}')
