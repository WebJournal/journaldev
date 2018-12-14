s = '2019'

print(s.isnumeric())

s = 'Hello 2019'
print(s.isnumeric())

s = ''
print(s.isnumeric())

s = '¼'  # 00bc: ¼ (VULGAR FRACTION ONE QUARTER)
print(s)
print(s.isnumeric())

s = '⒈⒗'  #2488: ⒈ (DIGIT ONE FULL STOP), 2497: ⒗ (NUMBER SIXTEEN FULL STOP)
print(s)
print(s.isnumeric())

import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.isnumeric():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Numeric Unicode Characters = {count}')
