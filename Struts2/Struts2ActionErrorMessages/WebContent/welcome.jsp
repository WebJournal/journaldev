<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
<style type="text/css">
.welcome {
	background-color:green;
	border:1px solid black;
	width:400px;
}
//ul.actionMessage is added by Struts2 API 
ul.actionMessage li {
	color:yellow;
}
</style>

</head>
<body>
<h3>Struts2 ActionMessage Example</h3>
<s:if test="hasActionMessages()">
   <div class="welcome">
      <s:actionmessage/>
   </div>
</s:if>
<br><br>
<s:property value="getText('msg.welcome')" /> <s:property value="username"/>
</body>
</html>