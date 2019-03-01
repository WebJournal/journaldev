# two types of and operator - Binary and Logical

# Logical AND operator example
x = int(input('Please enter a single digit integer:\n'))

if x > 0 and x < 10:
    print('You entered positive single digit number')
elif x < 0 and x > -10:
    print('You entered negative single digit number')
else:
    print('You did not entered single digit integer')

# Binary AND Operator example
a = int(input('Please enter an integer:\n'))
b = int(input('Please enter another integer:\n'))

print(f'{a} in binary is {str(bin(a))[2:]}')
print(f'{b} in binary is {str(bin(b))[2:]}')
print(f'Binary AND of {a} and {b} is {a&b}')
