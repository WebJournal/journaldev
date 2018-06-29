class CT:
    # declare a integer type variable
    var_int = 12

    # declare a string type variable
    var_str = 'monday'

    # declare a tuple type variable
    var_tup = (1, 2, 'mono')

# it will show the ClassTest as a 'type'
print('Type of ClassTest :', type(CT))

ct = CT()

# it will show the ClassTest as a 'class'
print('Type of ct :', type(ct))

# it will print the type of var_int as 'int'
print('Type of var_int :', type(ct.var_int))

# it will print the type of var_str as 'str'
print('Type of var_str :', type(ct.var_str))

# it will print the type of var_tup as 'tuple'
print('Type of var_tup :', type(ct.var_tup))
