<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page Example</title>
</head>
<body>
<h3>Struts 2 OGNL Examples</h3>
Name = <s:property value="name"></s:property><br>
True/False? = <s:property value="flag" ></s:property><br>
Current Year? = <s:property value="age"></s:property><br>
Todays Date (mm/dd/yyyy)? = <s:date name="date" format="MM/dd/yyyy"></s:date><br><br>

Stocks Array = <s:property value="stocks"/><br>
Roles Array = <s:property value="roles"/><br><br>
Users List = <s:iterator value="usersList"><s:property value="name"/>  </s:iterator><br>
Fruits List = <s:iterator value="fruitsList"><s:property value="name"/>  </s:iterator><br>
Fruit 1 Name = <s:property value="fruitsList[0].name"/><br><br>

Users Map = <s:iterator value="usersMap">{<s:property value="key"/>,<s:property value="value.name"/>}  </s:iterator><br><br>

Rectangle Dimensions: x = <s:property value="rectangle.x"/> and y = <s:property value="rectangle.y"/><br>
</body>
</html>