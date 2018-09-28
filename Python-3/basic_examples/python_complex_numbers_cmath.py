# creating complex numbers

c = 1 + 2j
print(type(c))
print(c)

c1 = complex(2, 4)
print(type(c1))
print(c1)

# complex number attributes and functions
c = 1 + 2j
print('Real Part =', c.real)
print('Imaginary Part =', c.imag)
print('Complex conjugate =', c.conjugate())

# complex numbers normal manipulations
c = 1 + 2j
c1 = 2 + 4j
print('Addition =', c + c1)
print('Subtraction =', c - c1)
print('Multiplication =', c * c1)
print('Division =', c1 / c)

# TypeError: '<' not supported between instances of 'complex' and 'complex'
# print('Comparison =', c < c1)

# cmath module
import cmath, math, numpy

c = 2 + 2j

# phase
phase = cmath.phase(c)
print('2 + 2j Phase =', phase)
print('Phase in Degrees =', numpy.degrees(phase))
print('-2 - 2j Phase =', cmath.phase(-2 - 2j), 'radians. Degrees =', numpy.degrees(cmath.phase(-2 - 2j)))

# we can get phase using math.atan2() function too
print('Complex number phase using math.atan2() =', math.atan2(2, 1))

# polar and rectangular coordinates
c = 1 + 2j

modulus = abs(c)
phase = cmath.phase(c)
polar = cmath.polar(c)

print('Modulus =', modulus)
print('Phase =', phase)
print('Polar Coordinates =', polar)
print('Type of polar =', type(polar))

print('Rectangular Coordinates =', cmath.rect(modulus, phase))

# cmath constants
print('π =', cmath.pi)
print('e =', cmath.e)
print('tau =', cmath.tau)
print('Positive infinity =', cmath.inf)
print('Positive Complex infinity =', cmath.infj)
print('NaN =', cmath.nan)
print('NaN Complex =', cmath.nanj)

# power and log functions
c = 2 + 2j
print('e^c =', cmath.exp(c))
print('log2(c) =', cmath.log(c, 2))
print('log10(c) =', cmath.log10(c))
print('sqrt(c) =', cmath.sqrt(c))

# trigonometric functions
c = 2 + 2j
print('arc sine =', cmath.asin(c))
print('arc cosine =', cmath.acos(c))
print('arc tangent =', cmath.atan(c))

print('sine =', cmath.sin(c))
print('cosine =', cmath.cos(c))
print('tangent =', cmath.tan(c))

# hyperbolic functions
c = 2 + 2j
print('inverse hyperbolic sine =', cmath.asinh(c))
print('inverse hyperbolic cosine =', cmath.acosh(c))
print('inverse hyperbolic tangent =', cmath.atanh(c))

print('hyperbolic sine =', cmath.sinh(c))
print('hyperbolic cosine =', cmath.cosh(c))
print('hyperbolic tangent =', cmath.tanh(c))

# classification functions
print(cmath.isfinite(2 + 2j))  # True
print(cmath.isfinite(cmath.inf + 2j))  # False

print(cmath.isinf(2 + 2j))  # False
print(cmath.isinf(cmath.inf + 2j))  # True
print(cmath.isinf(cmath.nan + 2j))  # False


print(cmath.isnan(2 + 2j))  # False
print(cmath.isnan(cmath.inf + 2j))  # False
print(cmath.isnan(cmath.nan + 2j))  # True

print(cmath.isclose(2+2j, 2.01+1.9j, rel_tol=0.05))  # True
print(cmath.isclose(2+2j, 2.01+1.9j, abs_tol=0.005))  # False
