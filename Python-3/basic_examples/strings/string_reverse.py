# reverse using while loop, string is a sequence
def reverse_while_loop(s):
    s1 = ''
    length = len(s) - 1
    while length >= 0:
        s1 = s1 + s[length]
        length = length - 1
    return s1


# reverse using for loop
def reverse_for_loop(s):
    s1 = ''
    for c in s:
        s1 = c + s1  # appending chars in reverse order
    return s1


# reverse using slicing
def reverse_slicing(s):
    return s[::-1]


# using join with reversed iterator
def reverse_join_reversed_iter(s):
    s1 = ''.join(reversed(s))
    return s1


# reverse using recursion
def reverse_recursion(s):
    if len(s) == 0:
        return s
    else:
        return reverse_recursion(s[1:]) + s[0]


# using list reverse()
def reverse_list(s):
    temp_list = list(s)
    temp_list.reverse()
    return ''.join(temp_list)


input_str = 'ABç∂EF'

if __name__ == "__main__":
    print('Reverse String using while loop =', reverse_while_loop(input_str))
    print('Reverse String using for loop =', reverse_for_loop(input_str))
    print('Reverse String using slicing =', reverse_slicing(input_str))
    print('Reverse String using reversed() and join() =', reverse_join_reversed_iter(input_str))
    print('Reverse String using Recursion =', reverse_recursion(input_str))
    print('Reverse String using list reverse =', reverse_list(input_str))

'''
Running these functions one by one with timeit module to identify the best one. 
Slicing is the fastest and smallest way to reverse a string and should be preferred to reverse a string.

$python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_slicing("ABç∂EF"*10)'
100000 loops, best of 5: 0.449 usec per loop

$python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_list("ABç∂EF"*10)'
100000 loops, best of 5: 2.46 usec per loop

$python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_join_reversed_iter("ABç∂EF"*10)'
100000 loops, best of 5: 2.49 usec per loop

$python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_for_loop("ABç∂EF"*10)'
100000 loops, best of 5: 5.5 usec per loop


$ python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_while_loop("ABç∂EF"*10)'
100000 loops, best of 5: 9.4 usec per loop


$python3.7 -m timeit --number 100000 --unit usec 'import string_reverse' 'string_reverse.reverse_recursion("ABç∂EF"*10)'
100000 loops, best of 5: 24.3 usec per loop

'''