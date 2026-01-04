package com.tap.model;

public class User {
	private int user_id;

	private String name;
	private String email;
	private String password;
	private String address;
	private String phonenumber;
	private int age;
	
	public User() {
	}

	public User(int user_id, String name, String email, String password, String address, String phonenumber, int age) {
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.age = age;
	}
	
	
	
	public User(String name, String email, String password, String address, String phonenumber, int age) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phonenumber = phonenumber;
		this.age = age;
	}

	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", address=" + address
				+ ", phonenumber=" + phonenumber + ", age=" + age + "]";
	}	
}
