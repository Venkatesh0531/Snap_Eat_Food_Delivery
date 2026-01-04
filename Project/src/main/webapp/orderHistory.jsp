<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.tap.model.Orders, com.tap.model.User"%>
<%@ page
	import="com.tap.model.Order_item, com.tap.DAO_Impl.Restaurents_DAO_Imple"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./homePageStyles.css">
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
<title>Snap Eat | My Orders</title>

<style>

*{
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}
body {
	font-family: "Segoe UI", Arial, sans-serif;
	background-color: #f4f6f8;
	margin: 0;
}

:root {
	--orange: #ff5100;
}

h2 {
	text-align: center;
	margin: 50px 0px 30px 0px;
	color: #333;
}

.orders-container {
	max-width: 900px;
	margin: auto;
}

.order-card {
	background: #ffffff;
	padding: 20px;
	border-radius: 14px;
	box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
	margin-bottom: 25px;
}

.order-header {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 12px;
}

.order-id {
	font-weight: 700;
	font-size: 16px;
}

.order-total {
	font-weight: 700;
	color: #2c7e2c;
}

.order-meta {
	font-size: 14px;
	color: #555;
	margin-bottom: 10px;
}

.status {
	font-weight: 600;
	color: green;
}

/* Order items section */
.order-items {
	margin-top: 15px;
	padding: 14px;
	background: #fafafa;
	border-radius: 10px;
}

.order-items h4 {
	margin: 0 0 10px 0;
	font-size: 15px;
	color: #333;
}

.item-row {
	display: flex;
	justify-content: space-between;
	font-size: 14px;
	padding: 8px 0;
	border-bottom: 1px dashed #ddd;
}

.item-row:last-child {
	border-bottom: none;
}

.item-name {
	font-weight: 500;
}

.item-price {
	font-weight: 600;
}

.no-orders {
	text-align: center;
	font-size: 18px;
	color: #777;
	margin-top: 80px;
}


/* Responsive */
@media ( max-width : 600px) {
	.order-header {
		flex-direction: column;
		align-items: flex-start;
		gap: 6px;
	}
}

.no-orders-container {
	min-height: 60vh;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	text-align: center;
	gap: 14px;
	color: #333;
}

.no-orders-img {
	margin-top: 30px;
	width: 100px;
	opacity: 0.9;
	margin-bottom: 10px;
	width: 100px;
}

.no-orders-hint {
	font-size: 14px;
	color: #ff6a00;
	font-weight: 600;
}

.no-orders-container h2 {
	font-size: 22px;
	font-weight: 700;
	margin-top: 8px;
}

.no-orders-subtext {
	font-size: 14px;
	color: #777;
}

.browse-btn {
	margin-top: 14px;
	padding: 10px 26px;
	background: linear-gradient(135deg, #ff6a00, #ff3d00);
	color: white;
	text-decoration: none;
	border-radius: 22px;
	font-size: 14px;
	font-weight: 600;
	transition: all 0.25s ease;
}

.browse-btn:hover {
	transform: translateY(-2px);
	color: white;
	box-shadow: 0 8px 18px rgba(255, 106, 0, 0.4);
}
</style>

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
	ArrayList<Orders> orders = (ArrayList<Orders>) request.getAttribute("orderHistory");

	Map<Integer, ArrayList<Order_item>> orderItemsMap = (Map<Integer, ArrayList<Order_item>>) request
			.getAttribute("orderItemsMap");

	if (orders != null && !orders.isEmpty()) {
	%>
	<h2>My Order History</h2>
	<div class="orders-container">


		<%
		for (Orders order : orders) {
		%>

		<div class="order-card">

			<div class="order-header">
				<div class="order-id">
					<%=Restaurents_DAO_Imple.getRestaurentsDetailsById(order.getRestaurent_id()).getName()%>
				</div>
				<div class="order-total">
					Total Paid(incl. tax) ₹<%=order.getTotal_amount()%>
				</div>
			</div>

			<div class="order-meta">

				<div>
					<strong>Date:</strong>
					<%=order.getDateTime().toString().substring(0, 19)%></div>
				<div>
					<strong>Delivery Address: </strong>
					<%=order.getAddress()%>
				</div>
				<div>
					<strong>Payment Mode:</strong>
					<%=order.getPayment_mode()%></div>
				<div class="status">
					<strong>Status:</strong>
					<%=order.getStatus()%></div>
			</div>

			<!-- ORDER ITEMS -->
			<div class="order-items">
				<h4>Items</h4>

				<%
				ArrayList<Order_item> items = orderItemsMap.get(order.getOrder_id());

				if (items != null && !items.isEmpty()) {
					for (Order_item item : items) {
				%>

				<div class="item-row">
					<span class="item-name"> <%=item.getItem_name()%> x <%=item.getQuantity()%>
					</span> <span class="item-price"> ₹ <%=item.getTotal_price()%>
					</span>
				</div>

				<%
				}
				} else {
				%>
				<p>No items found for this order.</p>
				<%
				}
				%>

			</div>
		</div>

		<%
		}
		%>

	</div>

	<%
	} else if (user == null) {
	%>
	<h2>Login To See Your Order History</h2>


	<%
	} else {
	%>
	<div class="no-orders-container">
		<img src="./assets/angry-face.png" alt="No Orders"
			class="no-orders-img">

		<p class="no-orders-hint">Go ahead and find some awesome
			restaurants near you...</p>

		<h2>No Orders</h2>
		<p class="no-orders-subtext">You haven't placed any order yet.</p>

		<a href="restaurents" class="browse-btn">Browse Restaurants</a>
	</div>

	<%
	}
	%>

</body>
</html>
