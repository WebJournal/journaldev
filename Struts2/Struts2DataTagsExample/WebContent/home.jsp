<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Home Page</title>
</head>
<body>
<h4>Struts 2 property tag example</h4>

User Name = <s:property value="user.name"/><br>
User Address = <s:property value="user.address" default="USA"/><br>

<h4>Struts 2 set tag example</h4>
<s:set var="defaultGender" value="user.gender" scope="application"></s:set>
Default Gender = <s:property value="#application.defaultGender"/><br>
Default Gender = <s:property value="#application['defaultGender']"/><br>

<h4>Struts 2 push tag example</h4>
<s:push value="user">
User Name = <s:property value="name" /><br>
User Address = <s:property value="address" default="USA"/><br>
User Address = <s:property value="gender" default="female"/><br>
</s:push>

<h4>Struts 2 bean tag example</h4>
<s:bean name="com.journaldev.struts2.model.User" var="myUser">
	<s:param name="name">Lisa</s:param>
	<s:param name="gender" value="#application.defaultGender"></s:param>
	<s:param name="address">India</s:param>
</s:bean>

MyUser Name = <s:property value="#myUser.name"/><br>
MyUser Gender = <s:property value="#myUser.gender"/><br>
MyUser Address = <s:property value="#myUser.address"/><br>
Default Name = <s:property value="#myUser.getDefaultName()"/><br>

<h4>Struts 2 action tag example</h4>

Data from footer action = <s:action name="footer" namespace="/" executeResult="true"></s:action>

<h4>Struts 2 Miscellaneous Data tags example</h4>

a tag example: <s:a href="#top">Go To Top</s:a><br>
date tag example: <s:date name="user.date" format="MM/dd/yyyy"/><br>
include tag example: <s:include value="/footer.jsp"></s:include><br>
text tag example: <s:text name="home.title"></s:text><br>
i18n tag example: <s:i18n name="global"><s:text name="home.name"></s:text></s:i18n><br>
debug tag example: <s:debug></s:debug>

</body>
</html>