package com.tap.model;

public class CartItem {
	
	private int rest_id;
	private int item_id;
	private String name;
	private String contents;
	private double price;
	private String img_url;
	private String type;
	private int quantity;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getItemId() {
		return item_id;
	}
	public void setItemId(int id) {
		this.item_id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRes_id() {
		return rest_id;
	}
	public void setRes_id(int res_id) {
		this.rest_id = res_id;
	}
	public CartItem(int rest_id, String name, String contents, double price, String img_url, String type, int item_id,
			int quantity) {
		this.rest_id = rest_id;
		this.name = name;
		this.contents = contents;
		this.price = price;
		this.img_url = img_url;
		this.type = type;
		this.item_id = item_id;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItem [id=" + item_id + ", name=" + name + ", contents=" + contents + ", price=" + price + ", img_url="
				+ img_url + ", type=" + type + ", res_id=" + rest_id + "]";
	}
	
	
	
}
