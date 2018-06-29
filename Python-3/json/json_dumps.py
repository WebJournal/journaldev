import json

# initialize different data
str_data = 'normal string'
int_data = 1
float_data = 1.50
list_data = [str_data, int_data, float_data]
nested_list = [int_data, float_data, list_data]
dictionary = {
    'int': int_data,
    'str': str_data,
    'float': float_data,
    'list': list_data,
    'nested list': nested_list
}

# convert them to JSON data and then print it
print('String :', json.dumps(str_data))
print('Integer :', json.dumps(int_data))
print('Float :', json.dumps(float_data))
print('List :', json.dumps(list_data))
print('Nested List :', json.dumps(nested_list, indent=2))
print('Dictionary :', json.dumps(dictionary, indent=2))  # the json data will be indented
