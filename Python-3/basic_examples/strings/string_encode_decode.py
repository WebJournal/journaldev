str_original = 'Hello'

bytes_encoded = str_original.encode(encoding='utf-8')
print(type(bytes_encoded))

str_decoded = bytes_encoded.decode()
print(type(str_decoded))

print('Encoded bytes =', bytes_encoded)
print('Decoded String =', str_decoded)
print('str_original equals str_decoded =', str_original == str_decoded)

str_original = input('Please enter string data:\n')

bytes_encoded = str_original.encode()

str_decoded = bytes_encoded.decode()

print('Encoded bytes =', bytes_encoded)
print('Decoded String =', str_decoded)
print('str_original equals str_decoded =', str_original == str_decoded)