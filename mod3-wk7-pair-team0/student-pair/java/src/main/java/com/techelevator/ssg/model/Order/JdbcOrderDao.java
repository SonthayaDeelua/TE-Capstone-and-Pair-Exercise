package com.techelevator.ssg.model.Order;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcOrderDao implements OrderDao {
	
	
	private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcOrderDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public void saveOrder(Order order) {
		String sqlInsertPost = "INSERT INTO orders(order_id, customer_name, street_address1, street_address2," +
	" city, state, zip_code) VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, order.getOrderId(),	order.getName(),
		order.getStreetAddress(), order.getApartmentNumber(), order.getCity(), 
		order.getState(), order.getZipCode());
	}
	
	@Override
	public void deleteOrderByOrderId(Long orderId) {
		String sqlSelectAllPosts = "DELETE FROM orders WHERE order_id = ?";
		jdbcTemplate.update(sqlSelectAllPosts, orderId);
	}
	
	@Override
	public void updateOrderItem(Order order, Long orderId) {
		String sqlUpdateOrderItem = "UPDATE orders SET customer_name = ?, street_address1 = ?,"
				+ " street_address2 = ?, city = ?, state=?, zip_code = ? WHERE order_id = ?";
		jdbcTemplate.update(sqlUpdateOrderItem, order.getName(), order.getStreetAddress(),
				order.getApartmentNumber(), order.getCity(), order.getState(), order.getZipCode(), orderId);
	}

}
