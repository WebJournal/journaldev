class Student:
    def __init__(self, age, name):
        self.age = age
        self.name = name
"""
    def __hash__(self):
        return hash((self.age, self.name))
"""
"""
    def __eq__(self, other):
        return self.age == other.age and self.name == other.name
"""




student = Student(23, 'Shubham')
print("The hash is: %d" % hash(student))
