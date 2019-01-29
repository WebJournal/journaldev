skills = ['Java', 'Python', 'Android']

print(skills)

# using list reverse() function to reverse the list
skills.reverse()

print(skills)

# using slicing to reverse and create a new list
numbers_asc = [1, 2, 3, 4, 5]
numbers_desc = numbers_asc[::-1]
print(numbers_asc)
print(numbers_desc)

# Object Oriented approach - using reversed()
vowels = ['a', 'e', 'i', 'o', 'u']
vowels_rev = list(reversed(vowels))
print(vowels)
print(vowels_rev)
