s = 'My name is {name} and I am a {job_title}'

my_dict = {'name': 'Pankaj', 'job_title': 'Software Engineer'}

print(s.format_map(my_dict))
print(s.format(**my_dict))

my_dict = {'name': 'Meghna', 'job_title': 'Editor', 'company': 'JournalDev'}
print(s.format_map(my_dict))
print(s.format(**my_dict))


# my_dict = {'name': 'Pankaj'}
# print(s.format_map(my_dict))  # KeyError: 'job_title'
# print(s.format(**my_dict))  # KeyError: 'job_title'

class MyDict(dict):
    def __missing__(self, key):
        return '#Not Found#'


s = 'My name is {name} and I am a {job_title}'
my_dict = MyDict(name='Pankaj')
print(my_dict)
print(s.format_map(my_dict))

# KeyError: 'job_title' because new dict is created from mapping, so __missing__ is not called.
# print(s.format(**my_dict))
