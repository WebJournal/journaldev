s = 'A\tB\tC\tD'

print(s)
print(s.expandtabs())

s = 'ABCD\tE\tF'
print(s)
print(s.expandtabs())

s = 'ABCDEFGHIJK\tG'
print(s.expandtabs())

s = 'ABCDEFGHIJK\t\tG'
print(s.expandtabs())

s = 'ABC\tD'
print(s)
print(s.expandtabs())
print(s.expandtabs(tabsize=0))
print(s.expandtabs(tabsize=1))
print(s.expandtabs(tabsize=2))
print(s.expandtabs(tabsize=3))
print(s.expandtabs(tabsize=4))
print(s.expandtabs(tabsize=5))
print(s.expandtabs(tabsize=6))
print(s.expandtabs(tabsize=7))

s = 'ABC\tD'
print(s.expandtabs(tabsize=-1))
print(s.expandtabs(tabsize=-3))
