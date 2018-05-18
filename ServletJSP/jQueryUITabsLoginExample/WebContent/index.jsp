<!DOCTYPE html>
<html>
<head>
<title>Login and Registration Page</title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">

<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>

</head>

<body>
	<div class="wrapper">
		<div class="container">
			<div id="tabs">
				<ul>
					<li><a href="#login">Login</a></li>
					<li><a href="#register">Register</a></li>
				</ul>
				<div id="login">
					<% 
  	if((String)session.getAttribute("error") != null){ %>
					<h4>Invalid Email or Password. Please try again.</h4>
					<%} %>
					<form method="post" action="LoginController">
						<label for="email">Email:</label> <br /> <input type="text"
							name="email" id="email" /> <br /> <label for="password">Password:</label>
						<br /> <input type="password" name="password" id="password" /> <br />
						<br /> <input type="submit" value="Login">
					</form>
				</div>
				<div id="register">
					<% 
  	if((String)session.getAttribute("errorReg") != null){ %>
					<h4><%=session.getAttribute("errorReg") %></h4>
					<%} %>
					<form method="post" action="RegistrationController">
						<label for="name">Name:</label><br /> <input type="text"
							name="name" id="name" /> <br /> <label for="email">Email:</label><br />
						<input type="text" name="email" id="email" /> <br /> <label
							for="password">Password:</label><br /> <input type="password"
							name="password" id="password" /> <br /> <label for="address">Address:</label><br />
						<input type="text" name="address" id="address" /> <br /> <br /> <input
							type="submit" value="Register">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>