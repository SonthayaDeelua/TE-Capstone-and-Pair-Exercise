package com.techelevator.ssg.model.Order;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcOrderItemDao implements OrderItemDao {
	
	

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcOrderItemDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

	
	@Override
	public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
		List<OrderItem> allItems = new ArrayList<>();
		String sqlSelectAllPosts = "SELECT * FROM order_items WHERE order_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPosts, orderId);
		while (results.next()) {
			OrderItem item = new OrderItem();
			item.setOrderId(results.getLong("order_id"));
			item.setProductId(results.getInt("product_id"));
			item.setQuantity(results.getInt("quantity"));
			
			allItems.add(item);
		}
		return allItems;
	}
	
	@Override
	public void updateOrderItem(int quantity, Long productId, Long orderId) {
		String sqlUpdateOrderItem = "UPDATE order_items SET quantity = ? WHERE product_id = ? AND order_id = ?";
		jdbcTemplate.update(sqlUpdateOrderItem, quantity, productId, orderId);
	}
	
	@Override
	public void deleteOrderItemsByOrderId(Long orderId) {
		String sqlSelectAllPosts = "DELETE FROM order_items WHERE order_id = ?";
		jdbcTemplate.update(sqlSelectAllPosts, orderId);
	}

	@Override
	public void save(OrderItem item) {
		String sqlInsertPost = "INSERT INTO order_items(order_id, product_id, quantity) VALUES (?,?,?)";
		jdbcTemplate.update(sqlInsertPost, item.getOrderId(),	item.getProductId(),
				item.getQuantity());
	}
	

	@Override
	public Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_order_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if (results.next()) {
			id = results.getLong(1);
			System.out.println("in dao " + id);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}

}