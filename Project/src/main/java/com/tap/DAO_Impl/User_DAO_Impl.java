package com.tap.DAO_Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tap.dao.User_DAO;
import com.tap.model.User;
import com.tap.utility.DB_Connection;

public class User_DAO_Impl implements User_DAO {
	
	Connection connection = DB_Connection.getConnection();
	
	private static String INSERT_QUERY = "insert into users (user_name, email,Create_Password, address, phone_number, age) values (?,?,?,?,?,?)";
	
	@Override
	public int addUser(User user) {
		int res = 0;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement(INSERT_QUERY);
			
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getPhonenumber());
			pstmt.setInt(6, user.getAge());
			
			res = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public User getUser(String email) {
		
		String SELECT_USER = 
			    "SELECT user_id, user_name, email, Create_Password, address, phone_number, age " +
			    	    "FROM users WHERE email = ?";
		
		User user = null;
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(SELECT_USER);
			pstmt.setString(1, email);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				user = new User(res.getInt(1),  res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getInt(7));
			}
			
			else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}
}
