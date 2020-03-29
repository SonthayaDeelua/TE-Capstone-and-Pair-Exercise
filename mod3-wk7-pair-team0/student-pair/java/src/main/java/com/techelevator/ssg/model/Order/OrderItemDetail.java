package com.techelevator.ssg.model.Order;

import com.techelevator.ssg.model.store.DollarAmount;

public class OrderItemDetail {
	
	private int quantity;
	private String name;
	private String description;
	private DollarAmount price;
	private String imageName;
	private DollarAmount total;
	
	
	public OrderItemDetail(int quantity, String name, String description, 
			DollarAmount price, String imageName, DollarAmount total) {
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageName = imageName;
		this.total = total;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public DollarAmount getPrice() {
		return this.price;
	}
	public void setPrice(DollarAmount price) {
		this.price = price;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public DollarAmount getTotal() {
		return total;
	}

	public void setTotal(DollarAmount total) {
		this.total = total;
	}


}
