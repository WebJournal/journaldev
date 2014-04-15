<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Login Page</title>
</head>
<body>
	<h3>Login with Username and Password</h3>
	<c:url var="loginUrl" value="/j_spring_security_check"></c:url>
	<form action="${loginUrl}" method="POST">
		<table>
			<tr>
				<td>User ID:</td>
				<td><input type='text' name='username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
		</table>
	</form>
</body>
</html>