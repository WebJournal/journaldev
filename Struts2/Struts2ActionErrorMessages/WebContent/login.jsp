<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Page</title>
<!-- Adding CSS for Styling of error messages -->
<style type="text/css">
.errorDiv{
	background-color:gray;
	border:1px solid black;
	width:400px;
	margin-bottom:8px;
}
</style>
</head>
<body>
<h3>Struts2 ActionError Example</h3>

<%-- hasActionErrors() method is defined in ActionSupport --%>
<s:if test="hasActionErrors()">
	<div class="errorDiv">
		<s:actionerror/>
	</div>
</s:if>

<s:form action="Welcome">
<s:textfield name="username" key="label.username"></s:textfield>
<s:password name="password" key="label.password"></s:password>
<s:submit key="label.submit.login" align="center" name="submit"></s:submit>
</s:form>
</body>
</html>