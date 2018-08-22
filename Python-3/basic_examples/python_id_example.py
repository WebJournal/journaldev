# integers
a = 10
b = 10
c = 11
d = 12

print(id(a))
print(id(b))
print(id(c))
print(id(d))

# tuples
t = ('A', 'B')
print(id(t))

t1 = ('A', 'B')
print(id(t1))

# strings
s1 = 'ABC'
s2 = 'ABC'
print(id(s1))
print(id(s2))

# dict
d1 = {"A": 1, "B": 2}
d2 = {"A": 1, "B": 2}
print(id(d1))
print(id(d2))
d1['A'] = 2
print(id(d1))


# custom object
class Emp:
    a = 0


e1 = Emp()
e2 = Emp()

print(id(e1))
print(id(e2))
