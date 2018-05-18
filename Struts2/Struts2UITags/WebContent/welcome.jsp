<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body>
<h3>User Details</h3>
User Name: <s:property value="name"></s:property><br>
<s:hidden name="password"></s:hidden>
About You: <s:property value="bio"></s:property><br>
Receiving Updates: <s:property value="receiveUpdates"></s:property><br>
Roles Selected: <s:property value="rolesSelect"/><br>
Role Checkbox Value: <s:property value="roleCheckbox"/><br>
Roles Radio Value: <s:property value="rolesRadio"/><br><br>
Double Select Role: <s:property value="doubleSelectRole"/><br>
Double Select Expertise: <s:property value="doubleSelectExpertise"/><br>
<h4>Thank You</h4>

</body>
</html>