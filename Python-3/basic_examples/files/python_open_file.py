# open file in text and read only mode
f = open('data.txt', mode='r')

print(type(f))

f.close()

# open file in binary and read only mode
f = open('favicon.ico', mode='r+b')

print(type(f))

f.close()

# open file in binary mode, read only with buffering
f = open('favicon.ico', mode='br', buffering=16)
f.close()

# open file in binary mode and no buffering
f = open('favicon.ico', mode='br', buffering=0)
f.close()

# open text file in append mode and line buffering
f = open('data.txt', mode='a', buffering=1)
f.close()

# open text file in write mode with truncate
f = open('data.txt', mode='w')
f.close()

# open text file in exclusive creation mode
try:
    f = open('data.txt', mode='x')
except FileExistsError as e:
    print('file already exists')
