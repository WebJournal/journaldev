class UnderAge(Exception):
    pass


def verify_age(age):
    if int(age) < 18:
        raise UnderAge('age is less')
    else:
        print('Age: ' + str(age))


# main program
verify_age(23)  # won't raise exception
try:
    verify_age(17)  # will raise exception
except UnderAge as e:
    print(e)
