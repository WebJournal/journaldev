def is_even(x):
    if x % 2 == 0:
        return True
    else:
        return False


def print_filter_items(my_filter):
    for item in my_filter:
        print(item, end=' ')
    print()


l1 = [1, 2, 3, 4, 5]
fl = filter(is_even, l1)
print(type(fl))
print_filter_items(fl)

t = (1, 2, 3, 4, 5)
fl = filter(is_even, t)
print_filter_items(fl)

# filter() example without function
t = (True, False, 1, 0, 0.0, 0.5, '', 'A', None)
fl = filter(None, t)
print_filter_items(fl)
