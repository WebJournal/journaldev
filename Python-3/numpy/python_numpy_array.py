import numpy

# Create a rank 1 array
a = numpy.array([3, 2, 3])
print('print rank 1 array:')
# access the array using their index
print('print using their index: a[0]= ', a[0])
a[0] = 5  # modify the array
print('print using slicing : ', a[1:])  # slicing can be used also
# print the whole list
print('Print the whole array : ', a)

# Create a rank 2 array using nested Python list
b = numpy.array([[10, 20, 30], [40, 50, 60]])
print('\nprint rank 2 array')
# access them using their index
print('print using their index: b[0,0]= ', b[0, 0], ' b[0,1]= ',b[0, 1])
print('print using slicing ', b[1:, :2])  # 1st slice for row, 2nd for column

# initialize a zero matrix
a = numpy.zeros((2, 2))
print('\nprint a 2-by-2 zero matrix:\n', a)

# Create an array of all ones
b = numpy.ones((2, 2))
print('\nprint a 2-by-2 all one matrix:\n', b)

# Create a constant array
c = numpy.full((3, 3), 6)
print('\nprint a 3-by-3 constant matrix for value = 6:\n', c)

# Create a 3x3 identity matrix
d = numpy.eye(3)
print('\nprint a 3-by-3 identity matrix:\n', d)
