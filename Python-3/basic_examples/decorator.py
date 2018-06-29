array = ['a', 'b', 'c']


def decorator(func):
    def newValueOf(pos):
        if pos >= len(array):
            print("Oops! Array index is out of range")
            return
        func(pos)

    return newValueOf


@decorator
def valueOf(index):
    print(array[index])


valueOf(10)
