<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Custom Tag Example</title>
<%@ taglib uri="http://journaldev.com/jsp/tlds/mytags" prefix="mytags"%>
</head>
<body>

<h2>Number Formatting Example</h2>

<mytags:formatNumber number="100050.574" format="#,###.00"/><br><br>

<mytags:formatNumber number="1234.567" format="$# ###.00"/><br><br>

<p><strong>Thanks You!!</strong></p>
</body>
</html>