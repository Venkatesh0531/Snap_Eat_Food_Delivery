package com.tap.model;

public class Restaurents {
	private int id;
	private String name;
	private String address;
	private String description;
	private String image;
	private float rating;
	private String distance_time;
	private String offers;
	private String starttime;
	private String endtime;
	private String contact;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	
	public Restaurents() {
	}

	
	public Restaurents(int id, String name, String address, String description, String image, float rating,
			String distance_time, String offers, String starttime, String endtime, String contact, String img1, String img2, String img3, String img4) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.image = image;
		this.rating = rating;
		this.distance_time = distance_time;
		this.offers = offers;
		this.starttime = starttime;
		this.endtime = endtime;
		this.contact = contact;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
	}


	public String getImg1() {
		return img1;
	}


	public void setImg1(String img1) {
		this.img1 = img1;
	}


	public String getImg2() {
		return img2;
	}


	public void setImg2(String img2) {
		this.img2 = img2;
	}


	public String getImg3() {
		return img3;
	}


	public void setImg3(String img3) {
		this.img3 = img3;
	}


	public String getImg4() {
		return img4;
	}


	public void setImg4(String img4) {
		this.img4 = img4;
	}


	public String getStarttime() {
		return starttime;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getDistance_time() {
		return distance_time;
	}

	public void setDistance_time(String distance_time) {
		this.distance_time = distance_time;
	}

	public String getOffers() {
		return offers;
	}

	public void setOffers(String offers) {
		this.offers = offers;
	}


	@Override
	public String toString() {
		return "Restaurents [id=" + id + ", name=" + name + ", address=" + address + ", description=" + description
				+ ", image=" + image + ", rating=" + rating + ", distance_time=" + distance_time + ", offers=" + offers
				+ ", starttime=" + starttime + ", endtime=" + endtime + ", contact=" + contact + ", img1=" + img1
				+ ", img2=" + img2 + ", img3=" + img3 + ", img4=" + img4 + "]";
	}




	
}
