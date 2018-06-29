import numpy


# initialize two array
x = numpy.array([[1, 2], [3, 4]], dtype=numpy.float64)
y = numpy.array([[3, 4], [5, 6]], dtype=numpy.float64)

print('Print the two matrices')
print('X = \n', x)
print('Y = \n', y)

# Elementwise sum; both produce the array
print('\nElementwise addition of two matrices: ( X + Y of Matlab )')
print('Add using add operator: \n', x + y)
print('Add using add function: \n', numpy.add(x, y))

# Elementwise difference; both produce the array
print('\nElementwise subtraction of two matrices: ( X - Y of Matlab )')
print('Subtract using operator: \n', x - y)
print('Subtract using function: \n', numpy.subtract(x, y))

# Elementwise product; both produce the array
print('\nElementwise Multiplication of two matrices: ( X .* Y of Matlab )')
print('Multiply using operator: \n', x * y)
print('Multiply using function: \n', numpy.multiply(x, y))

# Elementwise division; both produce the array
print('\nElementwise division of two matrices: ( X ./ Y of Matlab )')
print('Division using operator: \n', x / y)
print('Division using function: \n', numpy.divide(x, y))

# Elementwise square root; produces the array
print('\nSquare root each element of X matrix\n', numpy.sqrt(x))

# Matrix Multiplication
print('\nMatrix Multiplication of two matrices: ( X * Y of Matlab )')
print(x.dot(y))
