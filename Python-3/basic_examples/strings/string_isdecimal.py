s = '100'

print(s.isdecimal())

s = '0xF'
print(s.isdecimal())

s = '10.55'
print(s.isdecimal())

s = ''
print(s.isdecimal())

s = '1٠2𝟜'  # U+0660, U+1D7DC
print(s.isdecimal())
print(int(s))

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isdecimal():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Decimal Unicode Characters = {count}')
