s = 'hello'

print(s.swapcase())

s = 'HellO'
print(s.swapcase())

s = 'çå†'
print(s.swapcase())
print(s.swapcase().swapcase())
print(s.swapcase().swapcase() == s)

s = 'ß'  # German lowercase letter 'ß' is equivalent to "ss"
print(s.swapcase())
print(s.swapcase().swapcase())
print(s.swapcase().swapcase() == s)
