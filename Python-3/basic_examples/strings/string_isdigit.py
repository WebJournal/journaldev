s = '100'

print(s.isdigit())

s = '0xF'
print(s.isdigit())

s = '10.55'
print(s.isdigit())

s = ''
print(s.isdigit())

s = '1٠2𝟜'  # U+0660=0, U+1D7DC=4
print(s.isdigit())
print(int(s))

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isdigit():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Digit Unicode Characters = {count}')

import unicodedata

count = 0
for codepoint in range(2**16):
    ch = chr(codepoint)
    if ch.isnumeric() and not ch.isdigit():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Numeric and Non-Digit Unicode Characters = {count}')
