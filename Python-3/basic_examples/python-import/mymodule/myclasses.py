class Person:  
	name = ""  
	  
	def __init__(self, personName):  
		self.name = personName  
  
	def showName(self):  
		print(self.name)  

class Student(Person):
	id = 0
	
	def __init__(self, studentName, studentId):  
		Person.__init__(self, studentName)
		self.id = studentId  
  
	def getId(self):  
		return self.id