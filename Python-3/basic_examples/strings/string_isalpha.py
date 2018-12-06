s = 'Hello'

print(s.isalpha())

s = '123'
print(s.isalpha())

s = ''
print(s.isalpha())

s = 'çå'
print(s.isalpha())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isalpha():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Alpha Unicode Characters = {count}')
