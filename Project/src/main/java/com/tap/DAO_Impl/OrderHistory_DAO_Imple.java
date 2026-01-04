package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tap.model.Orders;
import com.tap.utility.DB_Connection;

public class OrderHistory_DAO_Imple {

	public ArrayList<Orders> getOrderHistory(int user_id) {
		
		Connection connection = DB_Connection.getConnection();
		
		
		String GET_ALL_ORDERS = "select * from orders where user_id = ?";
		ArrayList<Orders> orderhistory = null;
		
		try {
			PreparedStatement stmt = connection.prepareStatement(GET_ALL_ORDERS);
			
			stmt.setInt(1, user_id);
			
			ResultSet res = stmt.executeQuery();
			
			orderhistory = new ArrayList<Orders>();
			
//			order_id, user_id, restaurent_id, address, payment_mode, status, order_date, total_amount
			
			while(res.next()) {
				Orders order = new Orders();
				order.setOrder_id(res.getInt(1));
				order.setUser_id(res.getInt(2));
				order.setRestaurent_id(res.getInt(3));
				order.setAddress(res.getString(4));
				order.setPayment_mode(res.getString(5));
				order.setStatus(res.getString(6));
				order.setDateTime(res.getTimestamp(7));
				order.setTotal_amount(res.getDouble(8));
				
				orderhistory.add(order);
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderhistory;
		
		
	}

}

