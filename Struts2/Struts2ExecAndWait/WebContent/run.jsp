<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Long Process Input Page</title>
</head>
<body>
<h3>ExecAndWait Interceptor Example</h3>
<s:form action="ExecuteTask">
<s:textfield name="processingTime" label="Enter seconds to execute task"></s:textfield>
<s:token />
<s:submit name="submit" label="Run" align="center"></s:submit>
</s:form>
</body>
</html>