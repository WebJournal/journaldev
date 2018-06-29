import fractions

for v in [0.1, 0.5, 1.5, 2.0]:
    print('{} = {}'.format(v, fractions.Fraction(v)))

print(fractions.Fraction(0.1))

print(fractions.Fraction('0.1'))
