package org.ordermanagement.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.ordermanagement.model.Order;
import org.ordermanagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository repository;

	@Override
	public Order createOrder(Order order) {
		Order _order = new Order(order.getOrderName(), order.getPrice(), order.getOrderDescription());
		_order.setOrderedDate(Instant.now());
		return repository.save(_order);
	}

	@Override
	public List<Order> fetchAllOrders() {
		return repository.findAll();
	}

	@Override
	public Optional<Order> getOrderName(Long orderId) {
		return Optional.ofNullable(repository.getReferenceById(orderId));
	}

	@Override
	public List<Order> fetchOrdersBasedOnCriteria(String term) {
		return repository.fetchOrdersBasedOnCriteria(term);
	}
	
	

}
