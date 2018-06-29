import theano
import numpy

# declare variables
x = theano.tensor.fvector('x')
target = theano.tensor.fscalar('target')
W = theano.shared(numpy.asarray([0.2, 0.7]), 'W')

# create expressions
y = (x * W).sum()
cost = theano.tensor.sqr(target - y)
gradients = theano.tensor.grad(cost, [W])

W_updated = W - (0.1 * gradients[0])
updates = [(W, W_updated)]

# create a callable object from expression
f = theano.function([x, target], y, updates=updates)

# call the function and print results
for i in range(10):
    result = f([1.0, 1.0], 40.0)
    print(result)
