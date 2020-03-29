package com.techelevator.ssg.model.Order;

public interface OrderDao {
	
	public void saveOrder(Order order);
	
	public void deleteOrderByOrderId(Long orderId);
	
	public void updateOrderItem(Order order, Long orderId);



}
