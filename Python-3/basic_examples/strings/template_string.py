from string import Template

t = Template('$name is the $job of $company')
s = t.substitute(name='Tim Cook', job='CEO', company='Apple Inc.')
print(s)

# dictionary as substitute argument
d = {"name": "Tim Cook", "job": "CEO", "company": "Apple Inc."}
s = t.substitute(**d)
print(s)

# TypeError: substitute() got multiple values for keyword argument 'name'
# s = t.substitute(**d, name='Timothy D. Cook')


s = t.safe_substitute(name='Tim Cook', job='CEO')
print(s)

print('Template String =', t.template)

# escaping $ sign
t = Template('$$ is called $name')
s = t.substitute(name='Dollar')
print(s)

# complex example
t = Template('$noun adjective is ${noun}ing')
s = t.substitute(noun='Test')
print(s)
