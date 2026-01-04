<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.tap.model.Cart, com.tap.model.CartItem, com.tap.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snap Eat | Cart</title>
<link rel="stylesheet" href="./cartStyles.css">
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
</head>

<body>

	<!-- NAVBAR -->
	<div class="cart-nav">
		<div class="logo">
			<a href="restaurents"> <img alt="logo"
				src="./assets/logo_no_bg.png" style="width: auto; height: 60px;">
			</a>
		</div>
		<div class="cart-nav-links">
			<a class="nav-links-cart" href="">HELP</a>

			<%
			User user = (User) session.getAttribute("user");

			if (user == null) {
			%>
			<div class="user-info">
				<img style="width: 20px; height: 20px; margin-right: 10px;"
					src="./assets/user (1).png" alt="user-logo">Guest
			</div>
			<%
			} else {
			%>
			<div class="user-info">

				<div href="" class="profile-box">


					<img style="width: 20px; height: 20px; margin: 5px 2px -2px 15px;"
						src="./assets/user (1).png" alt="user-logo">
					<%= user.getName().toString().toUpperCase()%>
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

	<section class="cart">

		<%
		Cart cart = (Cart) session.getAttribute("cart");
		%>

		<div class="main-cart">

			<div class="main-cart-inside">

				<%
				if (cart == null || cart.getItems().isEmpty()) {
				%>
				<div class="empty-cart-wrapper">

					<div class="empty-cart">
						<img src="./assets/empty-cart.png" alt="Empty Cart"
							class="empty-cart-img">

						<h2>Your cart is empty</h2>
						<p>Looks like you haven’t added anything yet</p>

						<a href="restaurents" class="add-items-btn">Browse Restaurants</a>
					</div>
				</div>
				<%
				} else {
				%>

				<h2 class="cart-heading">Cart Items</h2>

				<%
				for (CartItem item : cart.getItems().values()) {
				%>


				<div class="cart-item">

					<div class="item-left">
						<div class="img-sec">
							<img class="cart-img" src="<%=item.getImg_url()%>" alt="item">
						</div>

						<div class="item-count">
							<form action="cart">
								<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
								<input type="hidden" name="restaurentId"
									value="<%=item.getRes_id()%>"> <input type="hidden"
									name="quantity" value="<%=item.getQuantity() - 1%>"> <input
									type="hidden" name="action" value="update">
								<button class="quantity-btn" <%if (item.getQuantity() == 1) {%>
									style="opacity: .4; pointer-events: none;" <%}%>>-</button>
							</form>

							<p><%=item.getQuantity()%></p>

							<form action="cart">
								<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
								<input type="hidden" name="restaurentId"
									value="<%=item.getRes_id()%>"> <input type="hidden"
									name="quantity" value="<%=item.getQuantity() + 1%>"> <input
									type="hidden" name="action" value="update">
								<button class="quantity-btn" <%if (item.getQuantity() >= 10) {%>
									style="opacity: .4; pointer-events: none;" <%}%>>+</button>
							</form>
						</div>
					</div>

					<div class="item-info">
						<p class="item-name"><%=item.getName()%></p>
						<p class="item-desc"><%=item.getContents()%></p>
						<p class="item-price">
							₹
							<%=String.format("%.2f", item.getPrice())%></p>
						<p class="item-total" style="margin-top: 30px; color: green;">
							₹Item Total:
							<%=item.getPrice() * item.getQuantity()%>
						</p>
					</div>

					<div class="dlt-sec">
						<form action="cart">
							<input type="hidden" name="itemId" value="<%=item.getItemId()%>">
							<input type="hidden" name="restaurentId"
								value="<%=item.getRes_id()%>"> <input type="hidden"
								name="action" value="delete">
							<button class="remove-btn">Remove</button>
						</form>
					</div>

				</div>

				<%
				}
				%>

				<a class="add-more-items btn"
					href="restaurentMenu?restaurantId=<%=session.getAttribute("oldRestaurentId")%>">Add
					More Items</a> <a class="proceed-to-checkout btn" href="checkout.jsp">Proceed
					to Checkout</a>

				<%
				}
				%>

			</div>

			<!-- RIGHT : PRICE DETAILS -->
			<%
			if (cart != null && !cart.getItems().isEmpty()) {
				double total = cart.getTotalPrice();
				double discount = total * 0.05;
				double afterDiscount = total - discount;
				double gst = afterDiscount * 0.08;
				double finalPrice = afterDiscount + gst + 29;

				session.setAttribute("finalPrice", finalPrice);
			%>

			<div class="price-sec">
				<div class="price-sec-heading">PRICE DETAILS</div>
				<div class="line"></div>

				<div class="cart-each-item">
					<span>Price</span> <span>₹ <%=total%></span>
				</div>

				<div class="cart-each-item">
					<span>Discount</span> <span>- ₹ <%=discount%></span>
				</div>

				<div class="cart-each-item">
					<span>GST</span> <span>₹ <%=String.format("%.2f", gst)%></span>
				</div>

				<div class="cart-each-item">
					<span>Protect Fee</span> <span>₹ 29</span>
				</div>

				<div class="line"></div>

				<div class="cart-each-item total">
					<span>Total Amount</span> <span>₹ <%= String.format("%.2f", finalPrice) %></span>
				</div>
			</div>

			<%
			}
			%>

		</div>
	</section>

</body>
</html>
