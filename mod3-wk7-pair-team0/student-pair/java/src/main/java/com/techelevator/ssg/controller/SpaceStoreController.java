package com.techelevator.ssg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ssg.model.Order.Order;
import com.techelevator.ssg.model.Order.OrderDao;
import com.techelevator.ssg.model.Order.OrderItem;
import com.techelevator.ssg.model.Order.OrderItemDao;
import com.techelevator.ssg.model.Order.OrderItemDetail;
import com.techelevator.ssg.model.store.DollarAmount;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

	

@Controller
public class SpaceStoreController {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private OrderDao orderDao;

	
	@RequestMapping("/spaceStore")
	public String showSpaceStore(ModelMap map) {
		List <Product> productList = productDao.getAllProducts();
		
		map.put("products", productList);
		return "spaceStore";
	}
	
	@RequestMapping("/productDetail")
	public String showProductDetail(@RequestParam long productId, ModelMap map,
										HttpSession session){
		Product product = productDao.getProductById(productId);
		map.put("product", product);
		session.setAttribute("productId", productId);
		
		return "productDetail";
	}
	
	@RequestMapping(path="/productDetail", method=RequestMethod.POST)
	public String addToCart(@RequestParam int quantity,
							HttpSession session) {
		Long orderId;
		Long productId = (Long)session.getAttribute("productId");
		
		if (session.getAttribute("orderId") == null) {
			System.out.println("Order Id is null");
			orderId =  orderItemDao.getNextId();
			session.setAttribute("orderId", orderId);
			
			Order order = new Order(orderId, "Casey", "1234", "4", "Ann Arbor", "MI", 48103);
			orderDao.saveOrder(order);
			
		} else {
			orderId = (Long)session.getAttribute("orderId");
		}
		
		List <OrderItem> items = orderItemDao.getOrderItemsByOrderId(orderId);
		boolean foundProduct = false;
		for(OrderItem item: items) {
			if(item.getProductId()== productId) {
				foundProduct = true;
				int newQuantity = item.getQuantity() + quantity;
				orderItemDao.updateOrderItem(newQuantity, productId, orderId);
			}
		}
			
		if(foundProduct == false) {
		   OrderItem item = new OrderItem(orderId, productId, quantity);		
				orderItemDao.save(item);
		}
				
		return "redirect:/shoppingCart";
	}
	
	@RequestMapping(path="/shoppingCart", method=RequestMethod.GET)
	public String displayShoppingCart(ModelMap map, HttpSession session) {
		
		Long orderId = (Long)session.getAttribute("orderId");

		List <OrderItem> orderItems = orderItemDao.getOrderItemsByOrderId(orderId);
		List <OrderItemDetail> itemDetails = new ArrayList<>();
		
		
		DollarAmount grandTotal = new DollarAmount(0);
		for(OrderItem item: orderItems) {
			Product product = productDao.getProductById(item.getProductId());
			DollarAmount price = product.getPrice();
			int quantity = item.getQuantity();
			DollarAmount total = price.multiply(quantity);
			grandTotal = grandTotal.plus(total);
			OrderItemDetail detail = new OrderItemDetail(quantity,
					product.getName(), product.getDescription(), price, product.getImageName(), total);
			System.out.println(detail.getTotal());
			itemDetails.add(detail);
		}
		
		map.put("grandTotal", grandTotal);
		map.put("items", itemDetails);
		return "shoppingCart";
	}
	
	@RequestMapping("/emptyCart")
	public String emptyCart(HttpSession session) {
		Long orderId = (Long)session.getAttribute("orderId");
		orderItemDao.deleteOrderItemsByOrderId(orderId);
		orderDao.deleteOrderByOrderId(orderId);
		session.invalidate();
		return "redirect:/spaceStore";
	}
	
	@RequestMapping(path="/checkout", method=RequestMethod.GET)
	public String checkoutForum() {
		return "checkout";
	} 
	
	@RequestMapping(path="/checkout", method=RequestMethod.POST)
	public String proccessCheckout(@RequestParam String name, @RequestParam String streetAddress,
			@RequestParam String apartmentNumber, @RequestParam String city,
			@RequestParam String state, @RequestParam int zipCode, HttpSession session) {
		
		Long orderId = (Long)session.getAttribute("orderId");
		Order order = new Order(orderId, name, streetAddress, apartmentNumber, city, state, zipCode);
		orderDao.updateOrderItem(order, orderId);
		session.invalidate();
		return "confirmation";
	}
	
	

}
