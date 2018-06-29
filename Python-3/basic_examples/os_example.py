import os

try:
    # If the file does not exist or we dont have,
    # then it would throw an IOError
    filename = 'JournalDevsas.txt'
    jdFile = open(filename, 'rU')
    text = jdFile.read()
    jdFile.close()

# Control jumps here if of the above statement throws IOError.
except IOError:
    # Below statement logs <class 'OSError'>
    print(os.error)

    # In any case, the code will continue
    # after it logs the error.