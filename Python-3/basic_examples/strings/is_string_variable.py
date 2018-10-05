i = 5  # not str

print(isinstance(i, str))

s = 'abc'  # string

print(isinstance(s, str))

# without validation
def process_string(input_str):
    print('Processing', input_str)

process_string('abc')

process_string(100)

# validating input is string
def process_string(input_str):
    if (isinstance(input_str, str)):
        print('Processing', input_str)
    else:
        print('Input Must be String')


process_string('abc')

process_string(100)
