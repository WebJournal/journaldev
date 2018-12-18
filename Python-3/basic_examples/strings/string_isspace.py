s = '   '
print(s.isspace())

s = '\t\n\r\t '
print(s.isspace())

s = '\u0009\t\u200a \u3000'
print(s.isspace())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isspace():
        print(u'{:04x}: ({})'.format(codepoint, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Space Unicode Characters = {count}')
