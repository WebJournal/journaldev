# iterable has all True
list_bools = [True, True, True]

print(all(list_bools))

# iterable all elements are not True
list_bools = [True, True, False]

print(all(list_bools))

# iterable is empty
list_bools = []

print(all(list_bools))

# iterable elements are True string
list_strs = ['True', 'True']

print(all(list_strs))

# iterable all elements are true string with different case
list_strs = ['True', 'true']

print(all(list_strs))

# iterable all elements are not true string
list_strs = ['abc', 'true']

print(all(list_strs))

# iterable all elements are empty string
list_strs = ['', 'true']

print(all(list_strs))

# iterable objects example
class Person:
    name = ""

    def __init__(self, n):
        self.name = n

    #comment and check output
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



list_objs = [Person("Pankaj"), Person("Lisa")]
print(all(list_objs))

list_objs = [Person("A"), Person("David")]
print(all(list_objs))
