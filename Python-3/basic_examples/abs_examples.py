import sys
x = 5 # int
print(abs(x))

x = sys.maxsize # long
print(abs(x))

x = 50.23434 # float
print(abs(x))

x = 10 - 4j # complex
print(abs(x))

x = complex(10, 2) # another complex example
print(abs(x))

# numbers in different formats
x = 10.23e1/2 # exponential
print(abs(x))

x = 0b1010 # binary
print(abs(x))

x = 0o15 # octal
print(abs(x))

x = 0xF # hexadecimal
print(abs(x))