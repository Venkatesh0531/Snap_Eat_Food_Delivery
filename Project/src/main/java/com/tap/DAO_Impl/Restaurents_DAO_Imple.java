package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.tap.model.Restaurents;
import com.tap.utility.DB_Connection;

public class Restaurents_DAO_Imple {
	
	private static Connection connection = DB_Connection.getConnection();
	
	public static Restaurents getRestaurentsDetailsById(int id) {
		
		Restaurents r = null;
		
		String GET_RESTAURENT_DETAILS_BY_ID = "select * from restaurents where id = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(GET_RESTAURENT_DETAILS_BY_ID);
			
			pstmt.setInt(1, id);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				
				int res_id = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String description = res.getString(4);
				String image = res.getString(5);
				float rating = res.getFloat(6);
				String distance_time = res.getString(7);
				String offers = res.getString(8);
				String starttime = res.getString(9);
				String endtime = res.getString(10);
				String contact = res.getString(11);
				String img1 = res.getString(12);
				String img2= res.getString(13);
				String img3 = res.getString(14);
				String img4 = res.getString(15);
				
				r = new Restaurents(res_id, name, address, description, image, rating, distance_time, offers, starttime, endtime, contact, img1, img2, img3, img4);
			}
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}
	
	
	
	
	
	public static ArrayList<Restaurents> getAllRestaurantDetails() {
	
		ArrayList<Restaurents> restaurents = new ArrayList<Restaurents>();
	
		String GET_ALL_RESTAURANTS_DETAILS = "select * from restaurents";
		
		try {
			Statement statement = connection.createStatement();
			
			ResultSet res = statement.executeQuery(GET_ALL_RESTAURANTS_DETAILS);
			
			while(res.next()) {
				int res_id = res.getInt(1);
				String name = res.getString(2);
				String address = res.getString(3);
				String description = res.getString(4);
				String image = res.getString(5);
				float rating = res.getFloat(6);
				String distance_time = res.getString(7);
				String offers = res.getString(8);
				String starttime = res.getString(9);
				String endtime = res.getString(10);
				String contact = res.getString(11);
				String img1 = res.getString(12);
				String img2= res.getString(13);
				String img3 = res.getString(14);
				String img4 = res.getString(15);
				
				Restaurents r = new Restaurents(res_id, name, address, description, image, rating, distance_time, offers, starttime, endtime, contact, img1, img2, img3, img4);
				
				restaurents.add(r);
			}	
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return restaurents;	
	}
}

