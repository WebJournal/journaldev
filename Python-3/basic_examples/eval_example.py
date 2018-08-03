# eval() simple example
x = 1

print(eval('x==1')) # True

print(eval('x+2')) # 3

# eval() with user input
from math import *

for l in range(1, 3):

    func = input("Enter Math Function to Evaluate:\n")
    try:
        print(eval(func))
    except Exception as ex:
        print(ex)
        break
print('Done')

# globals and locals to restrict usage
from math import *

def square_root(n):
   return sqrt(n)

print(globals()) # dictionary representing the current global symbol table.
print(locals()) # dictionary representing the current local symbol table.
print(dir()) # list of names in the current local scope

print(eval('dir()',{})) # prove that __builtins__ are included by default

print(eval('min(1,2)',{'__builtins__':{'min': min}}))

y=5
print(eval('y+1',{'__builtins__': None}, {'y': y})) # remove __builtins__ methods


# globals example
from math import *

for l in range(1, 3):
    func = input("Enter Math Function to Evaluate.\nAllowed Functions are: square_root(x) and pow(x,y):\n")
    try:
        print(eval(func, {'square_root': sqrt, 'pow': pow}))
    except Exception as ex:
        print(ex)
        break
print('Done')