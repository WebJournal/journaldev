#sample syntax of python generator
def gereratorName(argument):
   #statements
       yield argument
   #statements


#calling the generator
variableName = gereratorName(10)
print(next(variableName))