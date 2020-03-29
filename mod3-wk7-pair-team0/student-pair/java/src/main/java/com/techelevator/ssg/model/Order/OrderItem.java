/**
 * 
 */
package com.techelevator.ssg.model.Order;


public class OrderItem {

	private long orderId;
	private long productId;
	private int quantity;

	
	
	
	public OrderItem(long orderId, long product_Id, int quantity) {
		this.orderId = orderId;
		this.productId = product_Id;
		this.quantity = quantity;
	
	}
	
	public OrderItem() {
		
	}
	
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long product_Id) {
		this.productId = product_Id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



}

