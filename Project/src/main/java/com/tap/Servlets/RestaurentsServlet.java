package com.tap.Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.DAO_Impl.Restaurents_DAO_Imple;
import com.tap.model.Restaurents;
import com.tap.utility.DB_Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/restaurents")
public class RestaurentsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Restaurents_DAO_Imple res = new Restaurents_DAO_Imple();

		ArrayList<Restaurents> restaurantDetails = res.getAllRestaurantDetails();

		req.setAttribute("restaurents", restaurantDetails);

		RequestDispatcher rd = req.getRequestDispatcher("restaurents.jsp");

		rd.forward(req, resp);
	}

}
