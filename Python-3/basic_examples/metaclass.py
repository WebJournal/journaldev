def init(self, name, roll):

    self.name = name
    self.roll = roll
    self.marks = 0.0


Student = type('Student', (), {'__init__' : init})