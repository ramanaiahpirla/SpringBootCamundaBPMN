package org.ordermanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.ordermanagement.model.Order;
import org.ordermanagement.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate restTemplate;

	

	@PostMapping(path = "/placeOrder")
	public ResponseEntity<Order> placeOrder(@org.springframework.web.bind.annotation.RequestBody Order order) {
		Order _order = orderService.createOrder(order);
		return new ResponseEntity<Order>(_order, HttpStatus.OK);
	}
	
	@GetMapping(path = "/place/{id}")
	public String verifyOrder(@PathVariable("id") String orderId ) {
		ResponseEntity<String> response  = restTemplate.getForEntity("http://localhost:9092/paymentapi/receive/getOrder/"+ orderId, String.class);
		// http://localhost:9092/paymentapi/receive/getOrder/1
		return response.getBody();
	}
	
	@GetMapping(path = "/getOrders")
	public ResponseEntity<List<Order>> getAllOrders() {
		return new ResponseEntity<List<Order>>(orderService.fetchAllOrders(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/getOrderName/{id}")
	public ResponseEntity<Order> getOrderName(@PathVariable("id") Long orderId) {
		Optional<Order> optionalOrder = orderService.getOrderName(orderId);
		Order order = optionalOrder.get();
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	
	@GetMapping(path = "/CheckOrderOnCriteria")
	public ResponseEntity<List<Order>> fetchPhonesOnCriteria(@Param("term") String term) {
		List<Order> orderResposnes = orderService.fetchOrdersBasedOnCriteria(term);
		//List<Order> response = orderResposnes.stream().filter(x->x.getOrderDescription().equals("Apple")).collect(Collectors.toList());
		return new ResponseEntity<List<Order>>(orderResposnes, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getAppleProducts")
	public ResponseEntity<List<Order>> getAppleProducts() {
		List<Order> orderResposnes = orderService.fetchAllOrders();
		List<Order> response = orderResposnes.stream().filter(x->x.getOrderDescription().equals("Apple")).collect(Collectors.toList());
		return new ResponseEntity<List<Order>>(response, HttpStatus.OK);
	}
	
	

}
