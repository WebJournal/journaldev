# sorted() with string
s = sorted('djgicnem')
print(s)

# sorted() in reverse order
s = sorted('azbyx', reverse=True)
print(s)

# sorted() with tuple
s = sorted((1, 3, 2, -1, -2))
print(s)

s = sorted((1, 3, 2, -1, -2), reverse=True)
print(s)

s = sorted((1, 3, 2, -1, -2), key=abs)
print(s)

# sorted list
s = sorted(['a', '1', 'z'])
print(s)

s = sorted(['a', '1b', 'zzz'])
print(s)

s = sorted(['a', '1b', 'zzz'], key=len)
print(s)

s = sorted(['a', '1b', 'zzz'], key=len, reverse=True)
print(s)


# sorted with list of different types
# s = sorted(['a', 1, 'x', -3])  # TypeError: '<' not supported between instances of 'int' and 'str'


# sorted with custom object
class Employee:
    id = 0
    salary = 0
    age = 0
    name = ''

    def __init__(self, i, s, a, n):
        self.id = i
        self.salary = s
        self.age = a
        self.name = n

    def __str__(self):
        return 'E[id=%s, salary=%s, age=%s, name=%s]' % (self.id, self.salary, self.age, self.name)


# list of employees
e1 = Employee(1, 100, 30, 'Amit')
e2 = Employee(2, 200, 20, 'Lisa')
e3 = Employee(3, 150, 25, 'David')
emp_list = [e1, e2, e3]


# sort list of employees based on id
def get_emp_id(emp):
    return emp.id


emp_sorted_by_id = sorted(emp_list, key=get_emp_id)
for e in emp_sorted_by_id:
    print(e)


# sort list of employees based on age
def get_emp_age(emp):
    return emp.age


emp_sorted_by_age = sorted(emp_list, key=get_emp_age)
for e in emp_sorted_by_age:
    print(e)
