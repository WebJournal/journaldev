<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page Form</title>
</head>
<body>
<h3>Struts 2 OGNL Examples</h3>
<s:form action="welcome" method="post">
<table>
<s:textfield name="name" label="Name" ></s:textfield>
<s:textfield name="flag" label="True/False?"></s:textfield>
<s:textfield name="age" label="Current Year?"></s:textfield>
<s:textfield name="date" label="Todays Date (mm/dd/yyyy)?"></s:textfield>
</table>
<h3>Struts 2 Array OGNL Example</h3>

<strong>Array with same name example</strong><br>
<table>
<s:textfield name="stocks" label="Stock 1"></s:textfield>
<s:textfield name="stocks" label="Stock 2"></s:textfield>
<s:textfield name="stocks" label="Stock 3"></s:textfield>
</table>

<strong>Array with indexed name example</strong><br>
<table>
<s:textfield name="roles[0]" label="Role 1"></s:textfield>
<s:textfield name="roles[1]" label="Role 2"></s:textfield>
<s:textfield name="roles[2]" label="Role 3"></s:textfield>
</table>

<h3>Struts 2 List OGNL Example</h3>

<strong>List with same name example</strong><br>
<table>
<s:textfield name="usersList.name" label="User 1 Name"></s:textfield>
<s:textfield name="usersList.name" label="User 2 Name"></s:textfield>
<s:textfield name="usersList.name" label="User 3 Name"></s:textfield>
</table>
<strong>List with indexed name example</strong><br>
<table>
<s:textfield name="fruitsList[0].name" label="Fruit 1"></s:textfield>
<s:textfield name="fruitsList[1].name" label="Fruit 2"></s:textfield>
<s:textfield name="fruitsList[2].name" label="Fruit 3"></s:textfield>
</table>

<strong>Map Example</strong>
<table>
<s:textfield name="usersMap['first'].name" label="User 1"></s:textfield>
<s:textfield name="usersMap['second'].name" label="User 2"></s:textfield>
<s:textfield name="usersMap['third'].name" label="User 3"></s:textfield>
</table>

<strong>Custom Converter Example</strong>
<table>
<s:textfield name="rectangle" label="Rectangle in format R:x,y"></s:textfield>
</table>
<s:submit label="Submit" align="left"></s:submit>
</s:form>
</body>
</html>