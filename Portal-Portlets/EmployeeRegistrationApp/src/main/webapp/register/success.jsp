<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
	<portlet:renderURL var="registerAnother">
		<portlet:param name="status" value="initiate"/>
	</portlet:renderURL>
	<img src="<%=request.getContextPath()%>/images/success.jpg" name="<portlet:namespace/>Success"/>
	<body>
		<span>Congratulations ! you've just add a new employee</span><br/><a href="<%=registerAnother%>">Register Another</a>
	</body>
</html>