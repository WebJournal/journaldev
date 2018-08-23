class Super:
    pass


class Child(Super):
    pass


class GrandChild(Child):
    pass


print(issubclass(Child, Super))  # 1st level inheritance
print(issubclass(GrandChild, Super))  # multilevel inheritance
print(issubclass(Child, Child))  # same class
print(issubclass(Super, tuple))  # no inheritance

# class info as tuple
print(issubclass(GrandChild, (str, list, Super)))

print(issubclass(Super, object))

from collections import OrderedDict

print(issubclass(OrderedDict, dict))
