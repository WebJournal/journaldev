s = 'Hi Hello World'

print(s.isprintable())

s = ''
print(s.isprintable())

s = 'Hi\tHello'
print(s.isprintable())

s = 'Hi\nHello'
print(s.isprintable())

s = 'Hi\'Hello'
print(s.isprintable())
print(s)

s = 'Hi\bHello'
print(s.isprintable())
print(s)

s = 'Hi\aHello'
print(s.isprintable())
print(s)

s = 'Hi\u0066Hello'
print(s.isprintable())
print(s)

s = 'Hi\u0009Hello'
print(s.isprintable())
print(s)

count = 0
for codepoint in range(2 ** 16):
    ch = chr(codepoint)
    if not ch.isprintable():
        print(u'{:04x}'.format(codepoint))
        count = count + 1
print(f'Total Number of Non-Printable Unicode Characters = {count}')
