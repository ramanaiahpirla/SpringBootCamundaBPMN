package org.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import org.ordermanagement.model.Order;

public interface OrderService {
	
	public Order createOrder(Order order);

	public List<Order> fetchAllOrders();
	
	public List<Order> fetchOrdersBasedOnCriteria(String term);
	
	public Optional<Order> getOrderName(Long orderId);
	

}
