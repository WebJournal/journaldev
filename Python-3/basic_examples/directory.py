import os

#change directory
os.chdir('/Users/pankaj/temp')

#print current working directory
print(os.getcwd())

#create directory
os.mkdir("data")
print(os.listdir(os.getcwd()))

#rename directory
os.rename("data","data1")
print(os.listdir(os.getcwd()))

#delete directory
os.rmdir("data1")
print(os.listdir(os.getcwd()))

#delete non-empty directory
os.rmdir("test")
print(os.listdir(os.getcwd()))