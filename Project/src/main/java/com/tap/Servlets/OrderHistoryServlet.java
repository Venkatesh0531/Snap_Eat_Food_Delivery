package com.tap.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import com.tap.DAO_Impl.OrderHistory_DAO_Imple;
import com.tap.DAO_Impl.OrderItem_DAO_Imple;
import com.tap.model.Order_item;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderhistory")
public class OrderHistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();

		User user = (User) session.getAttribute("user");
		if(user == null) {
			PrintWriter out = resp.getWriter();
			out.println("<h1>Login first To See Your Order History</h1>");
			return;
			
		}
		int user_id = user.getUser_id();
		
		OrderHistory_DAO_Imple odi = new OrderHistory_DAO_Imple();
		OrderItem_DAO_Imple itemDao = new OrderItem_DAO_Imple();
		

		ArrayList<Orders> orderHistory = odi.getOrderHistory(user_id);
		Map<Integer, ArrayList<Order_item>> orderItemsMap = itemDao.getOrderItemsByUser(user.getUser_id());
		
		System.out.println(orderItemsMap);
		
		req.setAttribute("orderHistory", orderHistory);
		req.setAttribute("orderItemsMap", orderItemsMap);
		
		
		req.getRequestDispatcher("/orderHistory.jsp").forward(req, resp);

	}

}
