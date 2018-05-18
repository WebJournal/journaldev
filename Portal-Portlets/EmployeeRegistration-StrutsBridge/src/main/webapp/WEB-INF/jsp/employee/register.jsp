<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
<body>
	<s:form action="register">
		<s:textfield name="id" label="Identifier"></s:textfield>
		<s:textfield name="name" label="Name"></s:textfield>
		<s:textfield name="job" label="Job"></s:textfield>
		<s:textfield name="salary" label="Salary"></s:textfield>
		<s:submit value="Register"></s:submit>
	</s:form>
</body>
</html>