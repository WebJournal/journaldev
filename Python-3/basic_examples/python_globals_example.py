print(globals())

name = 'Pankaj'

print(globals())

globals()['name'] = 'David'

print(globals()['name'])


def fx():
    local = ''
    global gl
    gl = 'Global'


fx()  # calling fx() to set the variables
print(globals())
print(globals()['gl'])
