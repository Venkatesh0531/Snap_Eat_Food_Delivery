package com.tap.DAO_Impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tap.model.Orders;
import com.tap.utility.DB_Connection;


public class Order_DAO_Imple {
	
	
	Connection connection = DB_Connection.getConnection();
	
	public int addOrder(Orders order){
		
		int orderId = 0;
		
		String INSERT_ORDER_DETAILS = "insert into orders (`user_id`, `restaurent_id`, `address`, "
				+ "`payment_mode`, `status`, `order_date`, `total_amount`) values (?,?,?,?,?,?,?)";
		
		try(PreparedStatement stmt = connection.prepareStatement(INSERT_ORDER_DETAILS, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, order.getUser_id());
			stmt.setInt(2, order.getRestaurent_id());
			stmt.setString(3, order.getAddress());
			stmt.setString(4, order.getPayment_mode());
			stmt.setString(5, order.getStatus());
			stmt.setTimestamp(6, order.getDateTime());
			stmt.setDouble(7, order.getTotal_amount());
			
			
			int affecttedrows = stmt.executeUpdate();
			
			
			try(ResultSet generatedKeys  = stmt.getGeneratedKeys()){
				if(generatedKeys.next()) {
					orderId = generatedKeys.getInt(1);
				}
				else {
					throw new SQLException("Creating Order Failed. No Order id Obtained");
				}
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderId;
	}
}
