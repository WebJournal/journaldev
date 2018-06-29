import copy

list_of_list = [[1, 2], [3, 4], ["A", "B"]]

# python deep copy
new_list_of_list = copy.deepcopy(list_of_list)

new_list_of_list[0].append(10)
new_list_of_list[1].remove(3)

list_of_list[2].append("C")

print("list_of_list items : ", list_of_list)
print("new_list_of_list items : ", new_list_of_list)