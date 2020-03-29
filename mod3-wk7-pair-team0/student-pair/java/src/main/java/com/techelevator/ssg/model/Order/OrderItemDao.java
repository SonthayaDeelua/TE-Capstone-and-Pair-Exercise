package com.techelevator.ssg.model.Order;

import java.util.List;

public interface OrderItemDao {
	
	public List <OrderItem> getOrderItemsByOrderId(Long OrderId);
	
	public void save(OrderItem item);
	
	public void deleteOrderItemsByOrderId(Long orderId);
	
	public Long getNextId();
	
	public void updateOrderItem(int quantity, Long productId, Long orderId);
	
	



	
	


}
