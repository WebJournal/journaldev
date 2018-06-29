class Person:

    def static_method():
        print("This is a static method")

    def object_method(self):
        print("I can do something with self.")


p = Person()

Person.static_method()
p.object_method()