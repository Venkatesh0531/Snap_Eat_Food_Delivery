package com.tap.dao;

import com.tap.model.User;

public interface User_DAO {
	
	int addUser(User user);
	
	User getUser(String email);
}
