<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*, com.tap.model.RestaurentMenu, com.tap.model.Restaurents, com.tap.model.User"%>
<%@ page import="com.tap.model.Cart, com.tap.model.CartItem" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SnapEat | Menu</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/restaurentsMenuStyles.css">
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
<link rel="stylesheet" href="./footerStyles.css">

</head>
<body>
	<section class="nav">
		<div class="nav-bar">
			<div>
				<a href="restaurents">
					<img alt="logo" src="./assets/logo_no_bg.png" style="width: auto; height: 60px;">	
				</a>
			</div>
						<div class="user-actions">
				<input type="text" class="search-box"
					placeholder="Search restaurents, items">
				<div class="actions">

				<%
				
					User user = (User)session.getAttribute("user"); 

					if(user == null){ 
				%>
					
					<a href="Login.jsp" class="login-btn"><span><img
							src="./assets/logout.png" alt="login-icon"></span>Login</a> 
							<a
						href="Register.jsp" class="register-btn"><span><img
							src="./assets/add-friend.png" alt="register-icon"></span>Register</a>
<%
					} 
					else{
%>	
					<div class="cart-icon1">
						<a href="cart.jsp" class="cart-icon">
							<img src="<%=request.getContextPath()%>/assets/shopping-cart.png"
							alt="cart-logo-img"> <span>View Cart</span>
						</a>
					</div>
					
					<div class="user-info">
					
					<div href="" class="profile-box">
							
														
							<img style="width: 20px; height: 20px; margin: 5px 2px -2px 15px;" src="./assets/user (1).png" alt="user-logo"> 
							 <%= user.getName().toString().toUpperCase() %>
								<div class="profile-menu">
									<a href="orderhistory">Order History</a>
									<a href="logout">Logout</a>
								</div>
							</div>
					</div>
<%
					}
%>
				</div>
			</div>
		</div>
	</section>
	<%
	Restaurents sr = (Restaurents) request.getAttribute("singlerestaurent");
	
	if (sr != null) {
	%>

	<div class="home">
		<div class="res-info">
			<div class="res-title"><%=sr.getName()%></div>
			<div class="res-desc"><%=sr.getDescription()%></div>
			<div class="address"><%=sr.getAddress()%></div>
			<div class="timing">
				<span class="time">Timing(Every day): <%=sr.getStarttime()%>
					– <%=sr.getEndtime()%>
				</span><span><img src="./assets/phone-call.png" alt="phone-icon"><a
					href="tel: <%=sr.getContact()%>" class="contact"><%=sr.getContact()%></a></span>
			</div>
		</div>

		<div class="rating-info">
			<div class="rating-heading" style="margin-bottom: 5px;">Overall
				ratings</div>
			<div class="rating"><%=sr.getRating()%>
				&starf;
			</div>
		</div>
	</div>

	<div class="home-imgs">
		<div class="home-img box1" style="grid-area: box1;">
			<img src="<%=sr.getImg1()%>" alt="home-img1">
		</div>
		<div class="home-img box2" style="grid-area: box2;">
			<img src="<%=sr.getImg2()%>" alt="home-img2">
		</div>
		<div class="home-img box3" style="grid-area: box3;">
			<img src="<%=sr.getImg3()%>" alt="home-img3">
		</div>
		<div class="home-img box4" style="grid-area: box4;">
			<img src="<%=sr.getImg4()%>" alt="home-img4">
		</div>

	</div>

	<%
	} else {
	%>
	<p style="color:red">Restaurant details not available</p>
	<%
	}
	%>
	
	<div class="main-content">
		<div class="filters"></div>

		<div class="menu-items">
			<div class="order-head">Order Online</div>
			<div class="menu">


				<%
				List<RestaurentMenu> res = (List<RestaurentMenu>) request.getAttribute("restaurentmenu");

				if (res != null && !res.isEmpty()) {

					for (RestaurentMenu r : res) {
				%>

				<%-- single item start --%>

				<div class="item">

					<div class="item-info">
						<div class="item-img">
							<img src="<%=r.getImg_url()%>" alt="item-img">
						</div>
						<div class="item-desc">
							<div class="item-desc-head"><%=r.getName()%></div>
							<div class="item-desc-price">₹ <%= String.format("%.2f", r.getPrice()) %></div>
							<div class="item-contents"><%=r.getContents()%></div>
							<div class="item-type">
								<%
								if ("veg".equalsIgnoreCase(r.getType())) {
								%>
								<abbr title="Veg"><img src="./assets/Veg-logo.jpg"
									alt="veg"></abbr>
								<%
								} else {
								%>
								<abbr title="Non-Veg"><img src="./assets/non-veg.avif"
									alt="non-veg"></abbr>
								<%
								}
								%>
							</div>
						</div>
					</div>
					<div class="add-cart">
						<form action="cart" method="get">
							<input type="hidden" name="itemId" value="<%= r.getItemId() %>">
							<input type="hidden" name="restaurentId" value="<%= sr.getId()%>">
							<input type="hidden" name="quantity" value="1">
							<input type="hidden" name="action" value="add">
							<input type="submit" class="add-to-cart" value="Add to Cart">
						</form>
					</div>
				</div>
				
				
				
				<%
				
				}
				}
				else{
					
				%>
					<h3 style="color: red; margin-top: 20px">No Restaurent Items To Show</h3>
				
				
				<%	
				}
				
				%>
			
			</div>
		</div>
	</div>




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