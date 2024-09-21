<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

h3.alert {
	color: red;
	text-align: center;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 5px;
}

button[type=submit], .cancelbtn {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	border-radius: 5px;
}

button[type=submit]:hover, .cancelbtn:hover {
	opacity: 0.8;
}

.cancelbtn {
	background-color: #f44336;
}

.container .psw {
	float: right;
	padding-top: 16px;
}

.container label {
	font-weight: bold;
}

.container input[type=checkbox] {
	margin-top: 16px;
}

.container-background {
	background-color: #f1f1f1;
	padding: 16px;
	text-align: center;
	border-radius: 0 0 10px 10px;
}

/* Responsive adjustments */
@media screen and (max-width: 400px) {
	.container {
		width: 100%;
	}
}
</style>
</head>
<body>
	<form action="/HelloWorld/login" method="post">
		<c:if test="${alert !=null}">
			<h3 class="alert alert-danger">${alert}</h3>
		</c:if>

		<div class="container">
			<label for="uname"><b>username</b></label> <input type="text"
				placeholder="Enter Username" name="uname" required> <label
				for="psw"><b>Password</b></label> <input type="password"
				placeholder="Enter Password" name="psw" required>

			<button type="submit">Login</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Remember me
			</label>
		</div>

		<div class="container" style="background-color: #f1f1f1">
			<button type="button" class="cancelbtn">Cancel</button>
			<span class="psw">Forgot <a href="/HelloWorld/forgotPassword">password?</a></span>
		</div>
	</form>
</body>
</html>