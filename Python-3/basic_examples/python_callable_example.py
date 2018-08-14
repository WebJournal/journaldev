class Person:
    i = 0

    def __init__(self, id):
        self.i = id


p = Person(10)
print('Person Class is callable = ', callable(Person))
print('Person object is callable = ', callable(p))


class Employee:
    id = 0
    name = ""

    def __init__(self, i, n):
        self.id = i
        self.name = n

    def __call__(self, *args, **kwargs):
        print('printing args')
        print(*args)

        print('printing kwargs')
        for key, value in kwargs.items():
            print("%s == %s" % (key, value))


e = Employee(10, 'Pankaj')  # creating object

print(e)  # printing object

print(callable(e))

if callable(e):
    e()  # object called as a function, no arguments

    e(10, 20)  # only args
    e.__call__(10, 20)

    e(10, 20, {'x': 1, 'y': 2})  # only args of different types

    e(10, 'A', name='Pankaj', id=20)  # args and kwargs both
