import sys

print(type(sys.argv))
print('The command line arguments are:')
for i in sys.argv:
    print(i)
