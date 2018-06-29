class Student:
    def __init__(self, name, marks):
        self.name = name
        self.marks = marks
        # self.gotmarks = self.name + ' obtained ' + self.marks + ' marks'

    @property
    def gotmarks(self):
        return self.name + ' obtained ' + self.marks + ' marks'

    @gotmarks.setter
    def gotmarks(self, sentence):
        name, rand, marks = sentence.split(' ')
        self.name = name
        self.marks = marks


st = Student("Jaki", "25")
print(st.name)
print(st.marks)
print(st.gotmarks)
print("##################")
st.name = "Anusha"
print(st.name)
print(st.gotmarks)
print("##################")
st.gotmarks = 'Golam obtained 36'
print(st.gotmarks)
print(st.name)
print(st.marks)
