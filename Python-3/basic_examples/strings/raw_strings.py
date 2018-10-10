s = 'Hi\nHello'

print(s)

raw_s = r'Hi\nHello'
print(raw_s)

# raw string \ escapes quotes (',") but \ remains in the result
# raw string can't be single \ or end with odd numbers of \
raw_s = r'\''
print(raw_s)

raw_s = r'ab\\'
print(raw_s)

raw_s = R'\\\"'  # prefix can be 'R' or 'r'
print(raw_s)
