s1 = 'Apple'

s2 = 'Apple'

s3 = 'apple'

# case sensitive equals check
if s1 == s2:
    print('s1 and s2 are equal.')

if s1.__eq__(s2):
    print('s1 and s2 are equal.')

if s1 != s3:
    print('s1 and s3 are not equal')

# case insensitive equals check
if s1.casefold() == s3.casefold():
    print(s1.casefold())
    print(s3.casefold())
    print('s1 and s3 are equal in case-insensitive comparison')

if s1.lower() == s3.lower():
    print(s1.lower())
    print(s3.lower())
    print('s1 and s3 are equal in case-insensitive comparison')

if s1.upper() == s3.upper():
    print(s1.upper())
    print(s3.upper())
    print('s1 and s3 are equal in case-insensitive comparison')

# some examples with special characters
s1 = '$#ç∂'
s2 = '$#ç∂'

print('s1 == s2?', s1 == s2)
print('s1 != s2?', s1 != s2)
print('s1.lower() == s2.lower()?', s1.lower() == s2.lower())
print('s1.upper() == s2.upper()?', s1.upper() == s2.upper())
print('s1.casefold() == s2.casefold()?', s1.casefold() == s2.casefold())
