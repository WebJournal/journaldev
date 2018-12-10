s = 'xyzABC'

print(f'{s} is a valid identifier = {s.isidentifier()}')

s = '0xyz'  # identifier can't start with digits 0-9
print(f'{s} is a valid identifier = {s.isidentifier()}')

s = ''  # identifier can't be empty string
print(f'{s} is a valid identifier = {s.isidentifier()}')

s = '_xyz'
print(f'{s} is a valid identifier = {s.isidentifier()}')

s = 'ꝗꞨꫳ'  # PEP-3131 introduced Non-ASCII characters to identifier list
print(f'{s} is a valid identifier = {s.isidentifier()}')

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isidentifier():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Identifier Unicode Characters = {count}')
