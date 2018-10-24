import random
from random import randint
import string


def random_string_generator(str_size, allowed_chars):
    return ''.join(random.choice(allowed_chars) for x in range(str_size))


def random_string_generator_variable_size(min_size, max_size, allowed_chars):
    return ''.join(random.choice(allowed_chars) for x in range(randint(min_size, max_size)))


chars = string.ascii_letters + string.punctuation
size = 12

print(chars)
print('Random String of length 12 =', random_string_generator(size, chars))
print('Random String of random length (6-12) =', random_string_generator_variable_size(6, 12, chars))

import uuid

print('Random UUID from uuid1() =', uuid.uuid1())
print('Random UUID from uuid4() =', uuid.uuid4())
