class Person:

    #name made in constructor
    def __init__(another, n):
        another.name = n;

    def get_person_name(another):
        return another.name

    def something(another, arg1, arg2):
        pass

p1 = Person("David")
p2 = Person("Lisa")

Person.something(p1,"a","b")

print("Name", p1.get_person_name())
print("Name", p2.get_person_name())