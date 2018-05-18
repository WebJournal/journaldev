from collections import Counter

# creating Counter

# empty Counter
counter = Counter()
print(counter)

# Counter with initial values
counter = Counter(['a', 'a', 'b'])
print(counter)

counter = Counter(a=2, b=3, c=1)
print(counter)

# Iterable as argument for Counter
counter = Counter('abc')
print(counter)

# List as argument to Counter
words_list = ['Cat', 'Dog', 'Horse', 'Dog']
counter = Counter(words_list)
print(counter)

# Dictionary as argument to Counter
word_count_dict = {'Dog': 2, 'Cat': 1, 'Horse': 1}
counter = Counter(word_count_dict)
print(counter)

# Counter works with non-numbers too
special_counter = Counter(name='Pankaj', age=20)
print(special_counter)

# getting count
counter = Counter({'Dog': 2, 'Cat': 1, 'Horse': 1})
countDog = counter['Dog']
print(countDog)

# getting count for non existing key, don't cause KeyError
print(counter['Unicorn'])

counter = Counter({'Dog': 2, 'Cat': 1, 'Horse': 1})
# setting count
counter['Horse'] = 0
print(counter)

# setting count for non-existing key, adds to Counter
counter['Unicorn'] = 1
print(counter)

# Delete element from Counter
del counter['Unicorn']
print(counter)


# specific Counter methods

# elements()
elements = counter.elements()  # doesn't return elements with count 0 or less
for value in elements:
    print(value)

# most_common()
print(counter)
most_common_element = counter.most_common(1)
print(most_common_element)
least_common_element = counter.most_common()[:-2:-1]
print(least_common_element)



counter = Counter('ababab')
print(counter)  # Counter({'a': 3, 'b': 3})
c = Counter('abc')
print(c)  # Counter({'a': 1, 'b': 1, 'c': 1})

# subtract
counter.subtract(c)
print(counter)  # Counter({'a': 2, 'b': 2, 'c': -1})

# update
counter.update(c)
print(counter)  # Counter({'a': 3, 'b': 3, 'c': 0})

counter = Counter({'a': 3, 'b': 3, 'c': 0})
# miscellaneous examples
print(sum(counter.values()))  # 6

print(list(counter))  # ['a', 'b', 'c']
print(set(counter))  # {'a', 'b', 'c'}
print(dict(counter))  # {'a': 3, 'b': 3, 'c': 0}
print(counter.items())  # dict_items([('a', 3), ('b', 3), ('c', 0)])

# remove 0 or negative count elements
counter = Counter(a=2, b=3, c=-1, d=0)
counter = +counter
print(counter)  # Counter({'b': 3, 'a': 2})

# clear all elements
counter.clear()
print(counter)  # Counter()

# arithmetic operations
c1 = Counter(a=2, b=0, c=-1)
c2 = Counter(a=1, b=-1, c=2)

c = c1 + c2  # works with items having +ve count
print(c)  # Counter({'a': 3, 'c': 1})

c = c1 - c2  # keeps only +ve count elements
print(c)  # Counter({'a': 1, 'b': 1})

c = c1 & c2  # intersection min(c1[x], c2[x])
print(c)  # Counter({'a': 1})

c = c1 | c2  # union max(c1[x], c2[x])
print(c)  # Counter({'a': 2, 'c': 2})
