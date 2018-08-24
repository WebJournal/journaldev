# locals() and globals() are same in the module script
print(locals())
print(globals())


# locals() inside function
def fx1():
    var = 1
    global gl
    gl = 'x'
    print('\nlocals() value inside function\n', locals())
    print('\nglobals() value inside function\n', globals())


fx1()


# locals() inside class
class Data:
    x = 0
    print('\nlocals() value inside class\n', locals())
    print('\nglobals() value inside class\n', globals())
