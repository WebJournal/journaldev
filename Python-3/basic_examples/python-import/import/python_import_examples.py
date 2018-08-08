# python import module example
import utils

print(utils.add(10,10))
print(utils.uppercase('java'))

# python import as
import utils as u

print(u.add(10,10))
print(u.uppercase('java'))

# python import from another directory
# Refer: https://docs.python.org/3/library/importlib.html#importing-a-source-file-directly
# Refer: https://stackoverflow.com/questions/4383571/importing-files-from-different-folder
import importlib, importlib.util

def module_from_file(module_name, file_path):
    spec = importlib.util.spec_from_file_location(module_name, file_path)
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module

strutils = module_from_file("strutils", "../mymodule/strutils.py")

print(strutils.uppercase('java'))
print(strutils.lowercase('DATA'))

#python import class from another file
mc = module_from_file("myclasses", "../mymodule/myclasses.py")

p = mc.Person('Pankaj')
p.showName()

s = mc.Student('David',25)
s.showName()
print(s.getId())

# python import class from another file
import sys
sys.path.append("../mymodule/")
from myclasses import Person as PC
p = PC('Meghna')
p.showName()