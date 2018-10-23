s = '  Hello  World   From Pankaj \t\n\r\tHi There  '

print(f'Removing Leading and Trailing spaces using strip():\n{s.strip()}')

print(f'Removing all spaces using replace():\n{s.replace(" ", "")}')  # doesn't remove new lines

print(f'Removing all duplicate spaces using join():\n{" ".join(s.split())}')  # remove new lines too

import string

print(s.translate({ord(c): None for c in string.whitespace}))

# using regular expressions
import re

print('Remove all spaces using RegEx:\n', re.sub(r"\s+", "", s), sep='')  # \s matches all white spaces
print('Remove leading spaces using RegEx:\n', re.sub(r"^\s+", "", s), sep='')  # ^ matches start
print('Remove trailing spaces using RegEx:\n', re.sub(r"\s+$", "", s), sep='')  # $ matches end
print('Remove leading and trailing spaces using RegEx:\n', re.sub(r"^\s+|\s+$", "", s), sep='')  # | for OR condition
