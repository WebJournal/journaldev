s = 'abc'
print(s.islower())

s = 'Abc'
print(s.islower())

s = '123'
print(s.islower())

s = 'a123'
print(s.islower())

s = 'åçĕń'
print(s.islower())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.islower():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Lowercase Unicode Characters = {count}')
