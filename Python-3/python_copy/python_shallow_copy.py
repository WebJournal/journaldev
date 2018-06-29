import copy

old_list = [[1, 2], [3, 4]]

new_list = copy.copy(old_list)

new_list[0].append(10)

print("new_list items : ", new_list)
print("old_list items : ", old_list)