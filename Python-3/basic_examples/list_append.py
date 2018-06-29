"""
    Part 1: Append item data into the list
"""

# initial list
py_list = [1, 'apple']

# print the list
print('Initial List :', py_list)

# append some data
py_list.append('Appended data 1')
py_list.append('Appeded data 2')

# print the updated list data
print('Updated List :', py_list)

'''
    Part 2: Append another list into the list
'''

# declare another list
parent_list = [['to', 'be', 'or'], ['not', 'to', 'be']]

# print the new list
print('Initial Parent List :', parent_list)

# append the previous list to this list
parent_list.append(py_list)

# print the updated list
print('Updated Parent List :', parent_list)