s = 'A Big Cat'
print(s.istitle())

s = 'A BIG Cat'
print(s.istitle())

s = 'A big Cat'
print(s.istitle())

s = 'a big cat'
print(s.istitle())

s = 'A'
print(s.istitle())

s = ''
print(s.istitle())

s = '2019'
print(s.istitle())

# special characters
s = 'Â Ɓig Ȼat'
print(s.istitle())


import unicodedata

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if ch.istitle():
        print(u'{:04x}: {} ({})'.format(codepoint, ch, unicodedata.name(ch, 'UNNAMED')))
        count = count + 1
print(f'Total Number of Title Unicode Characters = {count}')


