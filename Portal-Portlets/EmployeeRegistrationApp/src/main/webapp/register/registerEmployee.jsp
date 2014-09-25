<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
	<portlet:actionURL var="registerLink"/>
	<form action="<%=registerLink%>" method="POST">
		<table width="100%">
			<tr width="60%">
				<td>Enter Employee ID:</td>
				<td><input name="employeeID" /></td>
			</tr>		
			<tr width="60%">
				<td>Enter Employee Name:</td>
				<td><input name="employeeName" /></td>
			</tr>
			<tr width="60%">
				<td>Enter Employee Job:</td>
				<td><input name="employeeJob" /></td>
			</tr>
			<tr width="60%">
				<td>Enter Employee Salary:</td>
				<td><input name="employeeSalary" /></td>
			</tr>
			<tr width="60%" align="center">
				<td colspan="2"><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>
</body>
</html>