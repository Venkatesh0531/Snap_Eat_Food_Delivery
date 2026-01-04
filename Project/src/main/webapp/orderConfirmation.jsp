<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snap Eat | Order Confirmed</title>

<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: Arial, Helvetica, sans-serif;
}

body {
	background: #f6f7f9;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

:root {
	--orange: #ff5100;
}

.confirmation-card {
	background: #fff;
	padding: 40px 50px;
	border-radius: 14px;
	box-shadow: 0 15px 40px rgba(0, 0, 0, 0.15);
	text-align: center;
	width: 420px;
	animation: fadeIn 0.5s ease;
}

.success-icon {
	width: 70px;
	height: 70px;
	border-radius: 50%;
	background: #28a745;
	color: #fff;
	display: flex;
	align-items: center;
	justify-content: center;
	font-size: 38px;
	margin: 0 auto 20px;
}

.confirmation-card h1 {
	font-size: 26px;
	color: #222;
	margin-bottom: 10px;
}

.confirmation-card h2 {
	font-size: 16px;
	font-weight: 400;
	color: #666;
	margin-bottom: 25px;
}

.confirmation-card p {
	font-size: 14px;
	color: #777;
	margin-bottom: 30px;
}

.order-btn {
	display: inline-block;
	padding: 12px 30px;
	background: var(--orange);
	color: #fff;
	text-decoration: none;
	font-weight: 600;
	border-radius: 8px;
	transition: background 0.3s ease, transform 0.2s ease;
}

.order-btn:hover {
	background: #e96c00;
	transform: translateY(-2px);
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(15px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>

</head>
<body>

	<div class="confirmation-card">
		<div class="success-icon">✓</div>

		<h1>Order Confirmed!</h1>
		<h2>
			Thank you for using <b>Snap Eat</b>
		</h2>

		<p>Your delicious food is being prepared and will reach you soon
			🍔🍕</p>

		<a href="restaurents" class="order-btn">Place More Orders</a>
	</div>

</body>
</html>
