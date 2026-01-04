package com.tap.Servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DAO_Impl.Order_DAO_Imple;
import com.tap.DAO_Impl.Order_Item_DAO_Imple;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order_item;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			HttpSession session = req.getSession();
			
			Cart cart = (Cart)session.getAttribute("cart");
			User user = (User)session.getAttribute("user");
			
			System.out.println(user);
			
			int restaurentId = (Integer)session.getAttribute("oldRestaurentId");
			double finalPrice = (Double)session.getAttribute("finalPrice");
			
			String address = req.getParameter("address");
			String paymentmode = req.getParameter("paymentmode");
			
			if(user == null) {
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.forward(req, resp);
				return;
			}
			
			if(cart != null && user != null && !cart.getItems().isEmpty()) {
					
				Orders orders = new Orders();
				
				orders.setUser_id(user.getUser_id());
				orders.setRestaurent_id(restaurentId);
				orders.setAddress(address);
				orders.setPayment_mode(paymentmode);
				orders.setStatus("Success");
				orders.setDateTime(new Timestamp(System.currentTimeMillis()));
				orders.setTotal_amount(finalPrice);
				
				Order_DAO_Imple odi = new Order_DAO_Imple();
				
				int orderId = odi.addOrder(orders);
				
				
				for(CartItem item : cart.getItems().values()) {
					
					String itemName = item.getName();
					int quantity = item.getQuantity();
					double price = item.getPrice()*quantity;
					
					Order_item order_item = new Order_item();
					
					order_item.setOrder_id(orderId);
					order_item.setItem_name(itemName);
					order_item.setQuantity(quantity);
					order_item.setTotal_price(price);
					
					Order_Item_DAO_Imple order_Item_DAO_Imple = new Order_Item_DAO_Imple();
					
					order_Item_DAO_Imple.addOrderItem(order_item);
					
				}
				
				
				
				
				session.removeAttribute("cart");
				session.removeAttribute("oldRestaurentId");
				session.removeAttribute("finalPrice");
				
				resp.sendRedirect("orderConfirmation.jsp");
				
				
			}
			else {
				resp.sendRedirect("cart.jsp");
			}
			
			
	}
}	

//private int order_id;
//private int user_id;
//private int restaurent_id;
//private String address;
//private String payment_mode;
//private String status;
//private LocalDateTime dateTime;
//private double total_amount;
