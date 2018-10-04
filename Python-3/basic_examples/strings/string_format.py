print("My Name is {0}".format("Pankaj"))

print("I like {0} and {1}".format("Java", "Python"))
# same as above
print("I like {} and {}".format("Java", "Python"))

# index can be in any order
print("I like {1} and {0}".format("Java", "Python"))

# unpacking from sequences
t = ("Java", "Python")
print("I like {1} and {0}".format(*t))

l = ["Java", "Python"]
print("I like {} and {}".format(*t))

# keyword arguments
print("{name} is the {job} of {company}".format(name="Pankaj", job="CEO", company="JournalDev"))

d = {"name": "Pankaj", "job": "CEO", "company": "JournalDev"}
print("{company} {job} is {name}".format(**d))


# accessing object attributes
class Data:
    id = 0
    name = ''

    def __init__(self, i, n):
        self.id = i
        self.name = n


dt = Data(1, 'Test')

print("{obj_name} id is {obj.id} and name is {obj.name}".format(obj_name="Data", obj=dt))

# string with specified character length and alignment
print("{:30}".format("data without align"))
print("{:<30}".format("data left aligned"))
print("{:>30}".format("data right aligned"))
print("{:^30}".format("data center aligned"))
print("{:|^30}".format("data with fill character"))

# formatting numbers
print('{:+f}; {:+f}'.format(1.23, -1.23))
print('{: f}; {: f}'.format(1.23, -1.23))
print('{:-f}; {:-f}'.format(1.23, -1.23))

print("int: {0:d};  hex: {0:x};  oct: {0:o};  bin: {0:b}".format(28))
print("int: {0:d};  hex: {0:x};  oct: {0:o};  bin: {0:b}".format(0x1c))
print("int: {0:d};  hex: {0:#x};  oct: {0:#o};  bin: {0:#b}".format(28))

complex_number = 4 + 2j
print("Real: {0.real}, Imaginary: {0.imag}".format(complex_number))

print('{:,}'.format(1234567890))
print('Percentage: {:.3%}'.format(19 / 28))
print('{0:7.2f}'.format(2.344))
print('{0:10.2f}'.format(22222.346))

# calling str and repr functions
print("With Quotes: {0!r}, Without Quotes: {0!s}".format("Data"))


class Test:

    def __str__(self):
        return 'test str'

    def __repr__(self):
        return 'test repr'


print("Test Representation: {0!r}, Test String Representation: {0!s}".format(Test()))
