package com.tap.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.tap.DAO_Impl.RestaurentMenu_DAO_Imple;
import com.tap.DAO_Impl.Restaurents_DAO_Imple;
import com.tap.model.RestaurentMenu;
import com.tap.model.Restaurents;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurentMenu")
public class RestaurentMenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int res_id = Integer.parseInt(req.getParameter("restaurantId"));
		
		Restaurents_DAO_Imple r = new Restaurents_DAO_Imple();
		
		Restaurents res = r.getRestaurentsDetailsById(res_id);
		
		RestaurentMenu_DAO_Imple rm = new RestaurentMenu_DAO_Imple();
		
		ArrayList<RestaurentMenu> rmd = rm.getRestaurantMenuDetails(res_id);
		
		req.setAttribute("singlerestaurent", res);
		
		req.setAttribute("restaurentmenu", rmd);
		
		RequestDispatcher rd = req.getRequestDispatcher("/restaurentsMenu.jsp");
			
		rd.forward(req, resp);
		
	}
}
