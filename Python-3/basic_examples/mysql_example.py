import pymysql

#database connection
connection = pymysql.connect(host="localhost", user="root", passwd="Tata!!11", database="Test")
cursor = connection.cursor()
# Query for creating table
ArtistTableSql = """CREATE TABLE Artists(
ID INT(20) PRIMARY KEY AUTO_INCREMENT,
NAME  CHAR(20) NOT NULL,
TRACK CHAR(10))"""

cursor.execute(ArtistTableSql)
connection.close()