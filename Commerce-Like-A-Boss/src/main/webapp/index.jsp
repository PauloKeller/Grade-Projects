<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="css/login-style.css">
		<title>Login</title>
	</head>
	<body>
	<section>
		<center>
			<h1 class="title-container">Login Here</h1>
			
			<div class="login-container">
				<form action="LoginService" method="POST" class="login-form">
					<div class="username-container">
						<label for="fname">User Name</label>
					    <input type="text" id="fname" name="username" placeholder="Username">
					</div>
					
					<div class="password-container">
						<label for="lname">Password</label>
					    <input type="password" id="lname" name="password" placeholder="Password">
					</div>
				  
			   		<input type="submit" value="Submit" class="btn-login">
				</form>
			</div>
		</center>
	</section>
	</body>
</html>