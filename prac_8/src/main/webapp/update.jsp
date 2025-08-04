<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 50px;
	background-color: #f2f2f2;
}

fieldset {
	border: 2px solid #4CAF50;
	border-radius: 8px;
	padding: 20px;
	max-width: 400px;
	background-color: #fff;
}

legend {
	font-size: 1.4em;
	font-weight: bold;
	color: #4CAF50;
	padding: 0 10px;
}

label {
	display: block;
	margin: 10px 0 5px;
}

input[type="text"], input[type="email"], input[type="password"] {
	width: 100%;
	padding: 8px;
	border-radius: 4px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	margin-top: 15px;
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 4px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.Login-link {
	display: inline-block;
	margin-top: 10px;
	background-color: #008CBA;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 4px;
}

.Login-link:hover {
	background-color: #007bb5;
}
</style>
</head>
</head>
<body>

	<form action="edit" method="post">
		<fieldset style="margin: auto;">
			<legend>Update Form</legend>
			<span style="color: green">${msg}</span>
			<span style="color: red">${err}</span>
			<input type="hidden" name="id" value="${user.getId()}">
			<div>
				<label for="username">Username:</label> 
				<input type="text" name="username" id="username"><br> 
				
					<label for="email">Email:</label>
				<input type="email" name="email" id="email"><br> 
				
				<label for="pass">Password:</label>
					 <input type="password" name="pass" id="pass"><br> 
					 
					<label for="cPass">Confirm Password:</label> 
					<input type="password" name="cPass" id="cPass"><br>

				<input type="submit" value="Register"> 
				<a href="login.jsp"	class="Login-link">Login Here</a>
				<a href="display"	class="Login-link">View User</a>
			</div>
		</fieldset>
	</form>
</body>
</html>
