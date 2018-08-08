# iterable has at least one True
list_bools = [True, True, True]

print(any(list_bools))

# iterable none of the elements are True
list_bools = [False, False]

print(any(list_bools))

# iterable is empty
list_bools = []

print(any(list_bools))

# iterable elements are True string (at least one)
list_strs = ['True', 'false']

print(any(list_strs))

# iterable any elements is true string with different case
list_strs = ['fff', 'true']

print(any(list_strs))

# iterable any elements are not true string
list_strs = ['abc', 'def']

print(any(list_strs))

# iterable all elements are empty string
list_strs = ['', '']

print(any(list_strs))


# iterable objects example
class Employee:
    name = ""

    def __init__(self, n):
        self.name = n

    # comment and check output
    def __bool__(self):
        print('bool function called')
        if len(self.name) > 3:
            return True
        else:
            return False

    # comment and check output
    def __len__(self):
        print('len function called')
        return len(self.name)


list_objs = [Employee("Pankaj"), Employee("Lisa")]
print(any(list_objs))

list_objs = [Employee("A"), Employee("D")]
print(any(list_objs))
