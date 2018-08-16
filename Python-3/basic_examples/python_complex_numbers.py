c = complex()
print(type(c))
print(c)

c = complex(1, 1)
print(c)

c = complex(1.5, -2.1)
print(c)

c = complex(0xF)  # hexadecimal
print(c)

c = complex(0b1010, -1)  # binary
print(c)

# underscores in numeric literals, PEP 515, Python version 3.6+, https://www.python.org/dev/peps/pep-0515/
c = complex(10_000_000.0, -2)
print(c)

c = 1 + 2j
c = complex(c, -4)
print(c)
c = complex(1+2j, 1+2J)
print(c)

# c = complex("1 + 2j")  # ValueError: complex() arg is a malformed string
c = complex("1+2j")
print(c)

# c = complex("1+j", 2)  # TypeError: complex() can't take second arg if first is a string

# c = complex(2, "-2j")  # TypeError: complex() second arg can't be a string
