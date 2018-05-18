<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Failure</title>
</head>
<body>
	<span style="color:red">Unfortunately! The Employee hasn't been registered successfully</span>
	</br>
	<a href="<s:url action="index" portletMode="view"/>">Try Again!</a>
</body>
</html>