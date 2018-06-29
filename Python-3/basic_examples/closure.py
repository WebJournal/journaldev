def closureFunc(up):
    val = 0

    def nestedFunc(arg):
        nonlocal val
        print("Welcome To Closure ")
        for i in range(up + 1):
            val += i
        val *= arg
        print("Total is =  %d" % val)

    return nestedFunc

retFunc = closureFunc(5)
print(retFunc.__closure__)
print(retFunc.__closure__[0].cell_contents)
print(retFunc.__closure__[1].cell_contents)

retFunc(10)
print(retFunc.__closure__)
print(retFunc.__closure__[0].cell_contents)
print(retFunc.__closure__[1].cell_contents)

retFunc(4)
print(retFunc.__closure__)
print(retFunc.__closure__[0].cell_contents)
print(retFunc.__closure__[1].cell_contents)
