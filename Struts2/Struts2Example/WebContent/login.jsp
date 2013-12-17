<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
</head>
<body>
<s:form action="home" method="post">
<s:textfield label="User Name" name="user"></s:textfield>
<s:textfield label="Password" name="password"></s:textfield>
<s:submit label="Login"></s:submit>
</s:form>
</body>
</html>