import random

random.seed(10)

print('1st random number = ', random.random())
print('2nd random number = ', random.random())
print('1st random int = ', random.randint(1, 100))
print('2nd random int = ', random.randint(1, 100))

# resetting the seed to 10 i.e. first value
random.seed(10)

print('3rd random number = ', random.random())
print('4th random number = ', random.random())
print('3rd random int = ', random.randint(1, 100))
print('4th random int = ', random.randint(1, 100))
