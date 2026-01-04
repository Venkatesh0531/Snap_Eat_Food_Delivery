<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8" />
<title>Snap Eat | Login</title>
<link rel="stylesheet" href="styles.css" />
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">

<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

:root {
	--orange: #ff5100;
}

body {
	background: #F1F3F6;
}

.main {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 80vh;
}

form {
/* 	background: rgba(218, 232, 237, 0.95); */
	padding: 32px 40px;
	border-radius: 14px;
	box-shadow: 0 15px 35px rgba(0, 0, 0, 0.3);
	backdrop-filter: blur(6px);
}

.heading {
	margin-bottom: 25px;
	text-align: center;
	font-size: 35px;
	font-weight: bold;
	color: #1e3c72;
}

td {
	padding: 10px 14px;
	font-size: 15px;
	color: #333;
}

label {
	color: #1e3c72;
	font-size: 16px;
}

input {
    background: rgba(255, 255, 255, 0.35); /* semi-transparent */
    color: #1e3c72;
    font-weight: 500;
    width: 240px;
    height: 38px;
    padding: 6px 10px;
    border-radius: 6px;
	border: 1px solid #1E3C72;
    outline: none;
    font-size: 14px;
    transition: 0.3s ease;

    backdrop-filter: blur(4px); /* glass effect */
}

input:focus {
	border-color: #2a5298;
	box-shadow: 0 0 6px rgba(42, 82, 152, 0.4);
}

input[type="submit"] {
	background: linear-gradient(135deg, #1e3c72, #2a5298);
	color: rgb(255, 240, 240);
	border: none;
	justify-content: center;
	border-radius: 8px;
	cursor: pointer;
	font-size: 15px;
	font-weight: bold;
	transition: 0.3s ease;
}

input[type="submit"]:hover {
	background: linear-gradient(135deg, #2a5298, #1e3c72);
	transform: scale(1.05);
}

.login {
	padding-top: 30px;
	text-align: center;
}

.register {
	text-align: center;
	font-size: 14px;
}

.register a {
	margin-left: 5px;
	text-decoration: none;
	transition: text-shadow 0.1s ease, font-weight 0.1s ease;
}

.register a:hover {
	text-decoration: underline;
	text-shadow: 0 0 1px currentColor;
}

.header {
	position: sticky;
	top: 0;
	z-index: 1000;
}

.nav-bar {
backdrop-filter: blur(4px);
	height: 80px;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: space-around;
	border-bottom: 1px solid #ddd;
	box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

.user-actions {
	display: flex;
	gap: 80px;
}

.actions {
	display: flex;
	gap: 10px;
}

.search-box {
	width: 300px;
	padding: 10px 20px;
	border-radius: 20px;
	border: none;
	box-shadow: 0px 0px 3px gray;
}

.search-box:focus {
	box-shadow: 0px 0px 8px gray;
	outline: none;
}

.login-btn, .register-btn {
	padding: 10px 20px;
	border-radius: 20px;
	cursor: pointer;
	text-decoration: none;
}

.login-btn {
	border: 2px solid var(--orange);
	background-color: white;
}

.register-btn {
	border: none;
	background-color: var(--orange);
	color: white;
	font-weight: 600;
}

.login-btn:hover, .register-btn:hover {
	box-shadow: 0px 0px 5px var(--orange);
}

.register-btn:hover {
	color: white;
}

img[alt="login-icon"] {
	height: 15px;
	width: 15px;
	margin-right: 8px;
	margin-bottom: -2px;
}

img[alt="register-icon"] {
	height: 20px;
	width: 20px;
	margin-right: 8px;
	margin-bottom: -5px;
}

.bg-video {
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	object-fit: cover;
	z-index: -2;
	opacity: 0.4;
}

.main-content {
	min-height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
</head>

<body>

	<video autoplay muted loop playsinline class="bg-video">
		<source src="./assets/bg-video.mp4" type="video/mp4">
	</video>
	<section class="header">
		<div class="nav-bar">
			<div>
				<a href="restaurents"> <img alt="logo"
					src="./assets/logo_no_bg.png" style="width: auto; height: 60px;">
				</a>
			</div>
			<div class="user-actions">
				<input type="text" class="search-box"
					placeholder="Search restaurents, items">
				<div class="actions">

					<%
					User user = (User) session.getAttribute("user");

					if (user == null) {
					%>

					<a href="Login.jsp" class="login-btn"><span><img
							src="./assets/logout.png" alt="login-icon"></span>Login</a> <a
						href="Register.jsp" class="register-btn"><span><img
							src="./assets/add-friend.png" alt="register-icon"></span>Register</a>
					<%
					} else {
					%>
					<div class="cart-icon1">
						<a href="cart.jsp" class="cart-icon"> <img
							src="<%=request.getContextPath()%>/assets/shopping-cart.png"
							alt="cart-logo-img"> <span>View Cart</span>
						</a>
					</div>

					<div class="user-info">
						<div href="" class="profile-box">


							<img
								style="width: 20px; height: 20px; margin: 5px 2px -2px 15px;"
								src="./assets/user (1).png" alt="user-logo">
							<%=user.getName().toString().toUpperCase()%>
							<div class="profile-menu">
								<a href="orderhistory">Order History</a> <a href="logout">Logout</a>
							</div>
						</div>
						<%
						}
						%>
					</div>
				</div>
			</div>
		</div>
	</section>

	<div class="main">
		<form action="login" method="get">
			<table>
				<tr>
					<td class="heading" colspan="2">Login</td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input type="email" name="email" required
						placeholder="Enter your Email"></td>
				</tr>

				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password" required
						placeholder="Enter your Password"></td>
				</tr>

				<tr>
					<td colspan="2" class="login"><input type="submit"
						value="Login"></td>
				</tr>

				<tr>
					<td colspan="2" class="register">Don't have an Account<a
						href="Register.jsp">Register</a></td>
				</tr>
			</table>
		</form>

	</div>
</body>

</html>