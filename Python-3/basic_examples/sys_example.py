import sys

variable = "JournalDev"

print(sys.getrefcount(0))
print(sys.getrefcount(variable))
print(sys.getrefcount(None))
