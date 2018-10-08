# concatenating multiple strings
s1 = 'Apple'
s2 = 'Pie'
s3 = 'Sauce'

s4 = s1 + s2 + s3

print(s4)

# string concatenation from user input
s1 = input('Please enter the first string:\n')
s2 = input('Please enter the second string:\n')

print('Concatenated String =', s1 + s2)

# using join() method
s1 = 'Hello'
s2 = 'World'

print('Concatenated String using join() =', "".join([s1, s2]))

print('Concatenated String using join() and whitespaces =', " ".join([s1, s2]))

# string concatenation with other objects
print('Hello' + str(4))


class Data:
    id = 0

    def __init__(self, i):
        self.id = i

    def __str__(self):
        return 'Data[' + str(self.id) + ']'


print('Hello ' + str(Data(10)))

# using % operator
s1 = 'Hello'
s2 = 'World'

s3 = "%s %s" % (s1, s2)
print('String Concatenation using % Operator =', s3)

s3 = "%s %s from JournalDev - %d" % (s1, s2, 2018)
print('String Concatenation using % Operator with Formatting =', s3)


# using format() function
s1 = 'Hello'
s2 = 'World'

s3 = "{}-{}".format(s1, s2)
print('String Concatenation using format() =', s3)

s3 = "{in1} {in2}".format(in1=s1, in2=s2)
print('String Concatenation using format() =', s3)

# using f-string, PEP 498 Literal String Interpolation
s1 = 'Hello'
s2 = 'World'

s3 = f'{s1} {s2}'
print('String Concatenation using f-string =', s3)

name = 'Pankaj'
age = 34
d = Data(10)

print(f'{name} age is {age} and d={d}')
