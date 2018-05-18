<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Update Duplicate Request Page</title>
</head>
<body>
<h3>User information is not updated, duplicate request detected.</h3>
<h4>Possible Reasons are:</h4>
<ul>
	<li>Back button usage to submit form again</li>
	<li>Double click on Submit button</li>
	<li>Using "Reload" Option in browser</li>
</ul>
<br>
<s:if test="hasActionErrors()">
	<s:actionerror/>
</s:if>
</body>
</html>