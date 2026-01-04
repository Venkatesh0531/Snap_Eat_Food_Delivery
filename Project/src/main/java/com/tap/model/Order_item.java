package com.tap.model;

public class Order_item {
	private int order_item_id;
	private int order_id;
	private String item_name;
	private int quantity;
	private double total_price;

	public Order_item() {
		// TODO Auto-generated constructor stub
	}

	public Order_item(int order_item_id, int order_id, String item_name, int quantity, double total_price) {
		super();
		this.order_item_id = order_item_id;
		this.order_id = order_id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public int getOrder_item_id() {
		return order_item_id;
	}

	public void setOrder_item_id(int order_item_id) {
		this.order_item_id = order_item_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Order_item [order_item_id=" + order_item_id + ", order_id=" + order_id + ", item_name=" + item_name
				+ ", quantity=" + quantity + ", total_price=" + total_price + "]";
	}
	
	

}