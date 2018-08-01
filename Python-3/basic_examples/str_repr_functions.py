class Person:
    name = ""
    age = 0

    def __init__(self, personName, personAge):
        self.name = personName
        self.age = personAge

    # must return String if repr() function is used, otherwise any valid python expression
    # can be returned, such as dict, tuple etc.
    def __repr__(self):
        return '{name:'+self.name+', age:'+str(self.age)+ '}'
        #return {'name':self.name, 'age':self.age}

    # must return string object
    def __str__(self):
        return 'Person(name='+self.name+', age='+str(self.age)+ ')'


p = Person('Pankaj', 34)

# __str__() example
print(p)
print(p.__str__())

s = str(p)
print(s)

# __repr__() example
print(p.__repr__())
print(type(p.__repr__()))
print(repr(p))