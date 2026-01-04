package com.tap.model;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class Orders {
	private int order_id;
	private int user_id;
	private int restaurent_id;
	private String address;
	private String payment_mode;
	private String status;
	private Timestamp date;
	private double total_amount;

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(int order_id, int user_id, int restaurent_id, String address, String payment_mode, String status,
			Timestamp date, double total_amount) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.restaurent_id = restaurent_id;
		this.address = address;
		this.payment_mode = payment_mode;
		this.status = status;
		this.date = date;
		this.total_amount = total_amount;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRestaurent_id() {
		return restaurent_id;
	}

	public void setRestaurent_id(int restaurent_id) {
		this.restaurent_id = restaurent_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getDateTime() {
		return date;
	}

	public void setDateTime(Timestamp date) {
		this.date = date;
	}

	public double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}

	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", user_id=" + user_id + ", restaurent_id=" + restaurent_id
				+ ", address=" + address + ", payment_mode=" + payment_mode + ", status=" + status + ", dateTime="
				+ date + ", total_amount=" + total_amount + "]";
	}


}
