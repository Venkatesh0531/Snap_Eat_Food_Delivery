package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.tap.model.Order_item;
import com.tap.utility.DB_Connection;

public class Order_Item_DAO_Imple {
	
	
	
	public void addOrderItem(Order_item orderItem) {
		Connection connection = DB_Connection.getConnection();
		
		String INSERT_ORDER_ITEM = "insert into order_item (order_id, item_name, quantity, total_price) values(?, ?, ?, ?)";
		
		
		
		try {
			PreparedStatement stmt = connection.prepareStatement(INSERT_ORDER_ITEM);
			
			stmt.setInt(1, orderItem.getOrder_id());
			stmt.setString(2, orderItem.getItem_name());
			stmt.setInt(3, orderItem.getQuantity());
			stmt.setDouble(4, orderItem.getTotal_price());
			
			
			int affectedRows = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

//order_item_id, order_id, item_name, quantity, total_price
