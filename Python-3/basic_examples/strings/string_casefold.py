s = 'My name is Pankaj'

print(s.casefold())

s1 = 'Python'
s2 = 'PyThon'
print(s1.casefold() == s2.casefold())

# some comparison examples with special characters
s1 = 'ß'  # typed with Option+s in Mac OS
s2 = 'ss'
s3 = 'SS'
if s1.casefold() == s2.casefold():
    print('s1 and s2 are equals in case-insensitive comparison')
else:
    print('s1 and s2 are not-equal in case-insensitive comparison')

if s1.casefold() == s3.casefold():
    print('s1 and s3 are equals in case-insensitive comparison')
