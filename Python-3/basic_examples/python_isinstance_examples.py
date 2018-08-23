class Person:
    name = ''


class Employee(Person):
    id = 0


p = Person()
e = Employee()

print('p isinstance of Person:', isinstance(p, Person))
print('p isinstance of Employee:', isinstance(p, Employee))

print('e isinstance of Person:', isinstance(e, Person))
print('e isinstance of Employee:', isinstance(e, Employee))

# class info as tuple
print('p is an instance of Person or Employee:', isinstance(p, (Person, Employee)))
print('e is an instance of Person or Employee:', isinstance(e, (Person, Employee)))

# some more examples
i = 10
print('i is int:', isinstance(i, int))

f = 10.5
print('f is float:', isinstance(f, float))

s = 'a'
print('s is str:', isinstance(s, str))

b = bytes('abc', 'utf-8')
print('b is bytes:', isinstance(b, bytes))

t = (1, 2)
print('t is tuple:', isinstance(t, tuple))

li = []
print('li is list:', isinstance(li, list))

d = {}
print('d is dict:', isinstance(d, dict))

