s = 5 #numbers
print(ascii(s))

s = True # boolean
print(ascii(s))

# strings
s = 'abc'
print(ascii(s))

s = 'èvõłvé'
print(ascii(s))

# list, tuple, dict
l = ['æ', 'b', 'č']
print(ascii(l))

t = (1, 'æ', 'b', 'č', 5)
print(ascii(t))

d = {'â':'å', '2':2, 'ç':'ć'}
print(ascii(d))

# custom objects
class Employee:
    name = ""

    def __init__(self, n):
        self.name = n

    def __repr__(self):
        return self.name

e = Employee('Pànkáj')
print(ascii(e))