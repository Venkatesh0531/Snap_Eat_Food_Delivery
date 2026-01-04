package com.tap.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.tap.DAO_Impl.User_DAO_Impl;
import com.tap.model.User;
import com.tap.utility.DB_Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User_DAO_Impl udi = new User_DAO_Impl();
		User user = udi.getUser(email);
		
		if(user == null) {
			out.println("<div style=\"\r\n"
					+ "				      margin-bottom: 15px;\r\n"
					+ "				      padding: 12px;\r\n"
					+ "				      background-color: #e6ffe6;\r\n"
					+ "				      color: red;\r\n"
					+ "				      text-align: center;\r\n"
					+ "				      font-weight: bold;\r\n"
					+ "				      border-bottom-left-radius: 10px;\r\n"
					+ "				      border-bottom-right-radius: 10px;\r\n"
					+ "				  \">\r\n"
					+ "				   	User doesn't exist. Register and Try again!\r\n"
					+ "				  </div>");
			
			req.getRequestDispatcher("Register.jsp").include(req, resp);
		}
		else if(user.getPassword().equals(password)) {
			HttpSession session = req.getSession();
			
			session.setAttribute("user", user);
			resp.sendRedirect("restaurents");
			
		}
		else {
			out.println("<div style=\"\r\n"
					+ "      margin-bottom: 15px;\r\n"
					+ "      padding: 12px;\r\n"
					+ "      background-color: #e6ffe6;\r\n"
					+ "      color: red;\r\n"
					+ "      text-align: center;\r\n"
					+ "      font-weight: bold;\r\n"
					+ "      border-bottom-left-radius: 10px;\r\n"
					+ "      border-bottom-right-radius: 10px;\r\n"
					+ "  \">\r\n"
					+ "    Invalid Password!\r\n"
					+ "  </div>");
			
			req.getRequestDispatcher("Login.jsp").include(req, resp);
		}
	}

}
