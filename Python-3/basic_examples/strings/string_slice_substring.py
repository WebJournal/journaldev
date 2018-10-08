s = 'HelloWorld'

# s[:i] + s[i:] == s

print(s[:])

print(s[::])

s = 'HelloWorld'
first_five_chars = s[:5]
print(first_five_chars)

third_to_fifth_chars = s[2:5]
print(third_to_fifth_chars)

# reverse a string using slicing
s = 'HelloWorld'
reverse_str = s[::-1]
print(reverse_str)

s1 = s[2:8:2]
print(s1)

s1 = s[8:1:-1]
print(s1)

s1 = s[8:1:-2]
print(s1)

s1 = s[-4:-2]
print(s1)

s1 = s[100:]
print(s1)
