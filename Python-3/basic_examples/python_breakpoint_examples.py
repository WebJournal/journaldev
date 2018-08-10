x = 10
y = 'Hi'
z = 'Hello'
print(y)

# breakpoint() is introduced in Python 3.7
breakpoint()

print(z)

# Execution Steps

# Default:
# $python3.7 python_breakpoint_examples.py

# Disable Breakpoint:
# $PYTHONBREAKPOINT=0 python3.7 python_breakpoint_examples.py

# Using Other Debugger (for example web-pdb):
# $PYTHONBREAKPOINT=web_pdb.set_trace python3.7 python_breakpoint_examples.py
