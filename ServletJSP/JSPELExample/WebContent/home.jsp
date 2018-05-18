<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>JSP EL Example Home</title>
</head>
<body>
<% 	List<String> names = new ArrayList<String>();
	names.add("Pankaj");names.add("David");
	pageContext.setAttribute("names", names);
%>
<strong>Simple . EL Example:</strong> ${requestScope.person}
<br><br>
<strong>Simple . EL Example without scope:</strong> ${person}
<br><br>
<strong>Simple [] Example:</strong> ${applicationScope["User.Cookie"]}
<br><br>
<strong>Multiples . EL Example:</strong> ${sessionScope.employee.address.address}
<br><br>
<strong>List EL Example:</strong> ${names[1]}
<br><br>
<strong>Header information EL Example:</strong> ${header["Accept-Encoding"]}
<br><br>
<strong>Cookie EL Example:</strong> ${cookie["User.Cookie"].value}
<br><br>
<strong>pageContext EL Example:</strong> HTTP Method is ${pageContext.request.method}
<br><br>
<strong>Context param EL Example:</strong> ${initParam.AppID}
<br><br>
<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
<br><br>
<strong>Relational Operator EL Example:</strong> ${initParam.AppID < 200}
<br><br>
<strong>Arithmetic Operator EL Example:</strong> ${initParam.AppID + 200}
<br><br>

</body>
</html>