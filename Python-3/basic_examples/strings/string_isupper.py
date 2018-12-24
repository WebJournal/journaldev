s = 'HELLO WORLD'
print(s.isupper())

s = 'Hello World'
print(s.isupper())

s = 'HELLO WORLD 2019'
print(s.isupper())

s = ''
print(s.isupper())

s = '2019'
print(s.isupper())

# special characters
s = 'ÂƁȻ2019'
print(s.isupper())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isupper():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Uppercase Unicode Characters = {count}')
