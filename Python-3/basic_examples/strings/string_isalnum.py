s = 'Hello World 2019'

print(s.isalnum())

s = 'HelloWorld2019'
print(s.isalnum())

s = ''
print(s.isalnum())

s='A.B'
print(s.isalnum())

s = '10.50'
print(s.isalnum())

s = 'çåøÉ'
print(s.isalnum())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isalnum():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Alphanumeric Unicode Characters = {count}')
