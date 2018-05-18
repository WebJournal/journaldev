<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Update User Success Page</title>
</head>
<body>
<h3>User information updated successfully.</h3>

Name: <s:property value="name"/><br>
Address: <s:property value="address"/><br>
Update Time: <s:date name="updateTime"/><br>

<h4>Thank You!</h4>
</body>
</html>