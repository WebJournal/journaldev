is_fast = True
car = "Ferrari" if \
    is_fast else\
    "Sedan"

print("Fast Car is ", car)

car = ("Sedan", "Ferrari")[is_fast]

print("Fast car from tuple is ", car)
