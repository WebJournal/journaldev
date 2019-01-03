s = 'Python is Good!'
print(s.title())

s = 'PYTHON IS GOOD'
print(s.title())

s = "Let's go to Party"
print(s.title())

import re


def titlecase(s):
    return re.sub(r"[A-Za-z]+('[A-Za-z]+)?",
                  lambda mo:
                  mo.group(0)[0].upper() +
                  mo.group(0)[1:].lower(), s)


s = "Let's go to Party"
print(titlecase(s))
print(titlecase('Python is Good!'))
print(titlecase('PYTHON IS GOOD'))
