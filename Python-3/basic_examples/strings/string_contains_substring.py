str1 = 'I love Python Programming'

str2 = 'Python'

str3 = 'Java'

print(f'"{str1}" contains "{str2}" = {str2 in str1}')
print(f'"{str1}" contains "{str2.lower()}" = {str2.lower() in str1}')
print(f'"{str1}" contains "{str3}" = {str3 in str1}')

if str2 in str1:
    print(f'"{str1}" contains "{str2}"')
else:
    print(f'"{str1}" does not contain "{str2}"')

index = str1.find(str2)
if index != -1:
    print(f'"{str1}" contains "{str2}"')
else:
    print(f'"{str1}" does not contain "{str2}"')

index = str1.find(str3)
if index is not -1:
    print(f'"{str1}" contains "{str3}"')
else:
    print(f'"{str1}" does not contain "{str3}"')
