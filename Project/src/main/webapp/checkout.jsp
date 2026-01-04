<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart, com.tap.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Snap Eat | Check Out</title>

<link rel="stylesheet" href="./cartStyles.css">
<link rel="icon" href="./assets/tab_logo.jpeg" type="image/jpeg">
</head>
<body>

	<%
	Cart cart = (Cart) request.getAttribute("cart");
	%>

	<div class="cart-nav">
		<div class="logo">
			<a href="restaurents">
					<img alt="logo" src="./assets/logo_no_bg.png" style="width: auto; height: 60px;">	
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

	<form action="OrderServlet" class="details" method="post">
		<fieldset>
			<legend>Delivery Details</legend>

			<table class="details-table">
				<tr>
					<td><label for="">Name</label></td>
					<td><input placeholder="Enter Your Name" required
						style="height: 25px;" class="name" type="text" name="name"></td>
				</tr>

				<tr>
					<td><label for="">Address</label></td>
					<td><textarea placeholder="Enter Your Complete Address" required
							name="address" id="" cols="30" rows="5" value="address"></textarea></td>
				</tr>
				<tr>
					<td><label for="">Payment Mode</label></td>

					<td class="payment-mode">
						<div>
							<input type="radio" name="paymentmode" value="upi" checked><label
								for="">UPI</label>
						</div>
						<div>
							<input type="radio" name="paymentmode" value="debit/credit"><label
								for="">Debit/Credit</label>
						</div>
						<div>
							<input type="radio" name="paymentmode" value="cashondelivery"><label
								for="">Cash On Delivery(COD)</label>
						</div>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="checkout-action"><a href="cart.jsp"
						class="go-back">Go Back</a> <input class="place-order"
						type="submit" value="Place Order"></td>
				</tr>
			</table>
		</fieldset>

	</form>


</body>
</html>