package com.tap.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import com.tap.DAO_Impl.User_DAO_Impl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String createpassword = req.getParameter("createpassword");
		String confirmpassword = req.getParameter("confirmpassword");
		String address = req.getParameter("address");
		String phonenumber = req.getParameter("phonenumber");
		int age = Integer.parseInt(req.getParameter("age"));
		
		User user = new User(name, email,createpassword, address, phonenumber, age);
		
		User_DAO_Impl udi = new User_DAO_Impl();
		
		
		int res = udi.addUser(user);
		resp.setContentType("text/html");
		
		
		if(res==1) {
			writer.println("<div style=\"\r\n"
					+ "				      margin-bottom: 15px;\r\n"
					+ "				      padding: 12px;\r\n"
					+ "				      background-color: #e6ffe6;\r\n"
					+ "				      color: #1f7a1f;\r\n"
					+ "				      text-align: center;\r\n"
					+ "				      font-weight: bold;\r\n"
					+ "				      border-bottom-left-radius: 10px;\r\n"
					+ "				      border-bottom-right-radius: 10px;\r\n"
					+ "				  \">\r\n"
					+ "				    Welcome "+name+"! Your Registration is Successfull.! Login to Continue\r\n"
					+ "				  </div>");
				    
			RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
			rd.include(req, resp);
		}
		else {
			writer.println(name+"! Sorry Your Registration was UnSuccessfull. UserName Already Exist");	
		}
		
	}
}
