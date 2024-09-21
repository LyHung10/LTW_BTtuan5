<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="fun" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forgot Password</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
	margin: 0;
	padding: 0;
}

.container {
	padding: 16px;
	background-color: white;
	width: 300px;
	margin: auto;
	margin-top: 100px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
}

input[type=text], input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 5px;
}

button[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border-radius: 5px;
}

button[type=submit]:hover {
	opacity: 0.8;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Forgot Password</h2>
		<form action="/HelloWorld/forgotPassword" method="post">
		<label for="username"><b>Enter your user:</b></label> <input
				type="text" placeholder="Enter User" name="username" required>
			<label for="email"><b>Enter your email address:</b></label> <input
				type="email" placeholder="Enter Email" name="email" required>
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>
