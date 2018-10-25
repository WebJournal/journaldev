import string

# string module constants
print(string.ascii_letters)
print(string.ascii_lowercase)
print(string.ascii_uppercase)
print(string.digits)
print(string.hexdigits)
print(string.whitespace)  # ' \t\n\r\x0b\x0c'
print(string.punctuation)

s = '  Welcome TO  \n\n JournalDev '
print(string.capwords(s))

from string import Formatter

formatter = Formatter()
print(formatter.format('{website}', website='JournalDev'))
print(formatter.format('{} {website}', 'Welcome to', website='JournalDev'))

print('{} {website}'.format('Welcome to', website='JournalDev'))


from string import Template

t = Template('$name is the $title of $company')
s = t.substitute(name='Pankaj', title='Founder', company='JournalDev.')
print(s)
