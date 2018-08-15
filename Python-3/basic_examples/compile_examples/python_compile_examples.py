# compile() with string source
code_str = 'x=5\ny=10\nprint("sum =",x+y)'
code = compile(code_str, 'sum.py', 'exec')
print(type(code))
exec(code)

# reading code from a file
f = open('my_code.py', 'r')
code_str = f.read()
f.close()
code = compile(code_str, 'my_code.py', 'exec')
exec(code)

# eval example
x = 5
code = compile('x == 5', '', 'eval')
result = eval(code)
print(result)

code = compile('x + 5', '', 'eval')
result = eval(code)
print(result)

# byte string example
bytes_str = bytes('x == 5', 'utf-8')
print(type(bytes_str))
code = compile(bytes_str, '', 'eval')
result = eval(code)
print(result)

# AST object example
import ast

ast_object = ast.parse("print('Hello world!')")
print(type(ast_object))
code = compile(ast_object, filename="", mode="exec")
print(type(code))
exec(code)
