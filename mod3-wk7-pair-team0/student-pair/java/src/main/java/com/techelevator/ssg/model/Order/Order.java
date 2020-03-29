package com.techelevator.ssg.model.Order;

public class Order {
	
	private long orderId;
	private String name;
	private String streetAddress;
	private String apartmentNumber;
	private String city;
	private String state;
	private int zipCode;
	
	public Order(long orderId, String name, String streetAddress, String apartmentNumber, String city, String state, int zipCode) {
		this.orderId = orderId;
		this.name = name;
		this.streetAddress = streetAddress;
		this.apartmentNumber = apartmentNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public Order() {
	}


	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


}
