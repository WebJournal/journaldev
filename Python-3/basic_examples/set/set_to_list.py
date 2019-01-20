s = {"A", "B", "C"}

l1 = list(s)

print(type(l1))
print(l1)

s = set()
s.add("A")
s.add("B")

l1 = list(s)

print(l1)

# list to set
l1 = [1, 2, 3, 2, 1]
s1 = set(l1)
print(type(s1))
print(s1)

# frozenset to list
s = frozenset({"A", "B"})

l1 = list(s)

print(l1)