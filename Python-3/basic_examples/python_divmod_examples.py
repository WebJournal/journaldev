# simple example, returns (a // b, a % b) for integers
dm = divmod(10, 3)
print(dm)

x, y = divmod(10, 3)
print(x)
print(y)

dm = divmod(0xF, 0xF)
print(dm)

# floats, returns usually (math.floor(a / b), a % b)
dm = divmod(10.3, 3)
print(dm)

dm = divmod(11.51, 3)
print(dm)

dm = divmod(-11.51, 3)
print(dm)


# complex numbers, TypeError: can't take floor or mod of complex number.
# dm = divmod(3 + 2J, 3)
