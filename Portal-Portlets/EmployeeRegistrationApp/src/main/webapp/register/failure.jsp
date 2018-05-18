<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/portlet' prefix='portlet'%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Employee</title>
</head>
	<portlet:defineObjects/>
	<portlet:renderURL var="registerAnother">
		<portlet:param name="status" value="initiate"/>
	</portlet:renderURL>
	<body>
		<span>Unfortunately ! you may not be able of registering a new employee cause the reason below</span>
		<br/>
		<br/>
		<img src="<%=request.getContextPath()%>/images/failed.jpg" name="<portlet:namespace/>Failed"/>
		<span style="font-size:small ;font-style: italic;color: red;font-weight: bold;">
			<%=renderRequest.getAttribute("exception")%>
		</span>
		<br/>
		<br/>
		<a href="<%=registerAnother%>">Try Again</a>
	</body>
</html>