package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.model.RestaurentMenu;
import com.tap.model.Restaurents;
import com.tap.utility.DB_Connection;

public class RestaurentMenu_DAO_Imple {
	
	private static Connection connection = null;
	
	public static ArrayList<RestaurentMenu> getRestaurantMenuDetails(int id) {
			
		connection = DB_Connection.getConnection();
		
		ArrayList<RestaurentMenu> restaurent_menu = new ArrayList<RestaurentMenu>();
	
		String GET_MENU_BY_ID = "select * from restaurentMenu where res_id = ?";
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(GET_MENU_BY_ID);
			
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int item_id = res.getInt(1);
				String name = res.getString(2);
				String contents = res.getString(3);
				double price = res.getDouble(4);
				String image_url = res.getString(5);
				String type = res.getString(6);	
				
				RestaurentMenu r = new RestaurentMenu(item_id, name, contents, price, image_url, type);
				
				restaurent_menu.add(r);
			}
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}	
		return restaurent_menu;		
	}
	
	
	public static RestaurentMenu getMenuByItemID_RestID(int itemId, int restId) {
		
		connection = DB_Connection.getConnection();
		
		String GET_MENU_BY_ITEM_ID_REST_ID = "select * from restaurentmenu where id = ? and res_id = ?";
		
		RestaurentMenu menu = null;
		
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(GET_MENU_BY_ITEM_ID_REST_ID);
			
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, restId);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int rest_Id= res.getInt(1);
				String name = res.getString(2);
				String contents = res.getString(3);
				double price = res.getDouble(4);
				String image_url = res.getString(5);
				String type = res.getString(6);
				int item_id = res.getInt(7);
				
				menu = new RestaurentMenu(rest_Id, name, contents, price, image_url, type, item_id);
				
				
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}
	
}
