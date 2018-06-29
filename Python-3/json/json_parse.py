import json

# initialize different JSON data
arrayJson = '[1, 1.5, ["normal string", 1, 1.5]]'
objectJson = '{"a":1, "b":1.5 , "c":["normal string", 1, 1.5]}'

# convert them to Python Data
list_data = json.loads(arrayJson)
dictionary = json.loads(objectJson)

print('arrayJson to list_data :\n', list_data)
print('\nAccessing the list data :')
print('list_data[2:] =', list_data[2:])
print('list_data[:1] =', list_data[:1])

print('\nobjectJson to dictionary :\n', dictionary)
print('\nAccessing the dictionary :')
print('dictionary[\'a\'] =', dictionary['a'])
print('dictionary[\'c\'] =', dictionary['c'])