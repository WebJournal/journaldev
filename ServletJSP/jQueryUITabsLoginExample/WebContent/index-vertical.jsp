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
  $( "#tabs" ).tabs().addClass( "ui-tabs-vertical ui-helper-clearfix" );
  $( "#tabs li" ).removeClass( "ui-corner-top" ).addClass( "ui-corner-left" );
});
</script>

<!-- Below style for Vertical Tabs -->
<style>
  .ui-tabs-vertical { width: 45em; }
  .ui-tabs-vertical .ui-tabs-nav { padding: .1em .1em .1em .1em; float: left; width: 8em; }
  .ui-tabs-vertical .ui-tabs-nav li { clear: left; width: 100%; border-bottom-width: 1px !important; border-right-width: 0 !important; margin: 0 -1px .2em 0; }
  .ui-tabs-vertical .ui-tabs-nav li a { display:block; }
  .ui-tabs-vertical .ui-tabs-nav li.ui-tabs-active { padding-bottom: 0; padding-right: .1em; border-right-width: 1px; border-right-width: 1px; }
  .ui-tabs-vertical .ui-tabs-panel { padding: 1em; float: right; width: 30em;}
  </style>
  
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
  		<h4> Invalid Email or Password. Please try again.</h4>
  	<%} %>
    <form method="post" action="LoginController">
    	<label for="email">Email:</label>
    	<br/>
    	<input type="text" name="email" id="email"/>
    	<br/>
    	<label for="password">Password:</label>
    	<br/>
    	<input type="password" name="password" id="password"  />
    	<br/>
    	<br/>
    	<input type="submit" value="Login">
    </form>
  </div>
  <div id="register">
  	<% 
  	if((String)session.getAttribute("errorReg") != null){ %>
  		<h4><%=session.getAttribute("errorReg") %></h4>
  	<%} %>
  	<form method="post" action="RegistrationController">
  		<label for="name">Name:</label><br/>
    	<input type="text" name="name" id="name" />
    	<br/>
    	<label for="email">Email:</label><br/>
    	<input type="text" name="email" id="email" />
    	<br/>
    	<label for="password">Password:</label><br/>
    	<input type="password" name="password" id="password" />
    	<br/>
    	<label for="address">Address:</label><br/>
    	<input type="text" name="address" id="address" />
    	<br/>
    	<br/>
    	<input type="submit" value="Register">
  	</form>
  </div>
</div>
</div>
</div>
</body>
</html>