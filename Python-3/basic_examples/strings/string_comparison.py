fruit1 = 'Apple'

print(fruit1 == 'Apple')
print(fruit1 != 'Apple')
print(fruit1 < 'Apple')
print(fruit1 > 'Apple')
print(fruit1 <= 'Apple')
print(fruit1 >= 'Apple')


fruit1 = input('Please enter the name of first fruit:\n')
fruit2 = input('Please enter the name of second fruit:\n')

if fruit1 < fruit2:
    print(fruit1 + " comes before " + fruit2 + " in dictionary.")
elif fruit1 > fruit2:
    print(fruit1 + " comes after " + fruit2 + " in dictionary.")
else:
    print(fruit1 + " and " + fruit2 + " are same.")

print('apple' == 'Apple')
print('apple' > 'Apple')
print('A unicode is', ord('A'), ',a unicode is', ord('a'))

print('Apple' < 'ApplePie')

print('apple' < 'apple')
print('apple' > 'apple')
