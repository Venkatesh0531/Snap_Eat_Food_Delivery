package com.tap.Servlets;

import java.io.IOException;

import com.mysql.cj.Session;
import com.tap.DAO_Impl.RestaurentMenu_DAO_Imple;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.RestaurentMenu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cart")

public class CartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		Integer oldRestaurentId = (Integer)session.getAttribute("oldRestaurentId");
		
		int restaurentId = Integer.parseInt(req.getParameter("restaurentId"));
		
		if(cart == null || oldRestaurentId != restaurentId) {
			
			cart = new Cart();
			
			session.setAttribute("cart", cart);
			session.setAttribute("oldRestaurentId", restaurentId);	
			
		}
		
		
		String action = req.getParameter("action");
		
		if(action.equals("add")) {
			addItemToCart(req,cart);
		}
		else if(action.equals("update")) {
			updateItemOfCart(req, cart);
		}
		else if(action.equals("delete")) {
			deleteItemFromCart(req, cart);
		}
		
		
		
		resp.sendRedirect("cart.jsp");
	}
	

	
	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int restaurentId = Integer.parseInt(req.getParameter("restaurentId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		RestaurentMenu_DAO_Imple restaurentMenu_DAO_Imple = new RestaurentMenu_DAO_Imple();
		
		RestaurentMenu restaurentMenu = restaurentMenu_DAO_Imple.getMenuByItemID_RestID(itemId, restaurentId);
		
		String name  = restaurentMenu.getName();
		String contents  = restaurentMenu.getContents();
		double price  = restaurentMenu.getPrice();
		String image_url  = restaurentMenu.getImg_url();
		String type  = restaurentMenu.getType();

		
		CartItem cartItem = new CartItem(restaurentId, name, contents, price, image_url, type, itemId, quantity);
		
		cart.addItem(cartItem);
	}
		
	private void updateItemOfCart(HttpServletRequest req, Cart cart) {
		
		
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(itemId, quantity);
		
		
	}
	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		String action = req.getParameter("action");
		
		cart.removeItem(itemId);
	}
		
}
