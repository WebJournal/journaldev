print(round(10, 2))

print(round(10.2))
print(round(10.8))
print(round(11.5))

# Floating Point Arithmetic: Issues and Limitations
# Refer https://docs.python.org/3.7/tutorial/floatingpoint.html
print(round(2.675, 2))

# if both side of rounding is same, even is returned
print(round(10.5))
print(round(12.5))

print(round(1.5))
# OR
print(round(1.5, None))

print(round(1.2356, 2))
print(round(-1.2356, 2))

# round() with negative ndigit
print(round(100, 0))
print(round(100.1234, -2))
print(round(100.1234, -5))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __round__(self, n):
        return round(self.id, n)


d = Data(10.5234)
print(round(d, 2))
print(round(d, 1))
