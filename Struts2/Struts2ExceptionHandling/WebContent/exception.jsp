<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Generic Exception Page</title>
</head>
<body>
Some Exception Occured!!<br><br>

Exception Name: <s:property value="exception"/><br><br>

Exception Stack Trace: <br>
<s:property value="exceptionStack"/>
</body>
</html>