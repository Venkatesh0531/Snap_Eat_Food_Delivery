package com.tap.model;

public class RestaurentMenu {
	private int itemId;
	private String name;
	private String contents;
	private double price;
	private String img_url;
	private String type;
	private int res_id;
	
	public int getRes_id() {
		return res_id;
	}

	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}

	public RestaurentMenu() {
	}

	public RestaurentMenu(int id, String name, String contents, double price, String img_url, String type, int res_id) {
		super();
		this.itemId = id;
		this.name = name;
		this.contents = contents;
		this.price = price;
		this.img_url = img_url;
		this.type = type;
		this.res_id = res_id;
	}	


	public RestaurentMenu(int id, String name, String contents, double price, String img_url, String type) {
		this.itemId = id;
		this.name = name;
		this.contents = contents;
		this.price = price;
		this.img_url = img_url;
		this.type = type;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int id) {
		this.itemId = id;
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

	@Override
	public String toString() {
		return "RestaurentMenu [id=" + itemId + ", name=" + name + ", contents=" + contents + ", price=" + price
				+ ", img_url=" + img_url + ", type=" + type + "]";
	}
	
	
	
	
}
