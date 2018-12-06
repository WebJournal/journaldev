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
