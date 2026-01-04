
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="java.util.*, com.tap.model.Restaurents, com.tap.model.User"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Snap Eat</title>
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
<link rel="stylesheet" href="./homePageStyles.css">
</head>

<body>
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

	<section class="home-page">
		<div class="slideshow">
			<img src="./assets/home1.jpeg" class="slide"> <img
				src="./assets/home2.jpg" class="slide">
		</div>

		<div class="dots">
			<span class="dot active"></span> <span class="dot"></span>
		</div>
	</section>



	<section class="main-content">
		<div>
			<h1>Top Restaurents</h1>
		</div>

		<%
		List<Restaurents> res = (List<Restaurents>) request.getAttribute("restaurents");
		%>

		<div class="main-content-inside">

			<%
			for (Restaurents r : res) {
			%>

			<a href="restaurentMenu?restaurantId=<%=r.getId()%>"
				class="restaurant-link">
				<div class="food-items">
					<img class="restaurents-images" src="<%=r.getImage()%>" alt="img1">
					<div class="res-details1">
						<p class="res-name"><%=r.getName()%></p>
						<p class="res-rating"><%=r.getRating()%>
							&starf;
						</p>
					</div>
					<div class="res-details2">
						<p class="res-desc"><%=r.getDescription()%></p>
						<p class="res-time"><%=r.getDistance_time()%></p>
					</div>
				</div>
			</a>

			<%
			}
			%>
		</div>

	</section>


	<section class="footer">
		<div class="footer-content">

			<div class="footer-brand">
				<img src="./assets/logo_no_bg.png" alt="SnapEat Logo">
				<p>© 2026 SnapEat Limited</p>
			</div>

			<div class="footer-details">

				<ul>
					<li class="header">Contact us</li>
					<li><a href="#">Help & Support</a></li>
					<li><a href="#">Partner with us</a></li>
					<li><a href="#">Ride with us</a></li>
				</ul>

				<ul>
					<li class="header">Legal</li>
					<li><a href="#">Terms & Conditions</a></li>
					<li><a href="#">Cookie Policy</a></li>
					<li><a href="#">Privacy Policy</a></li>
				</ul>

				<ul>
					<li class="header">Available in</li>
					<li>Bangalore</li>
					<li>Hyderabad</li>
					<li>Delhi</li>
					<li>Mumbai</li>
					<li>Pune</li>
				</ul>

				<ul>
					<li class="header">Social Links</li>
					<li>
						<div class="social-links">
							<a href="#"><img src="./assets/linkedin.png" alt="LinkedIn"></a>
							<a href="#"><img src="./assets/instagram.png" alt="Instagram"></a>
							<a href="#"><img src="./assets/twitter.png" alt="Twitter"></a>
							<a href="#"><img src="./assets/facebook.png" alt="Facebook"></a>
						</div>
					</li>
				</ul>

			</div>

		</div>
	</section>
</body>

</html>