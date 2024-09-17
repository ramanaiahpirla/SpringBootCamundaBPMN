package org.ordermanagement.repository;

import java.util.List;

import org.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT t FROM Order t WHERE LOWER(t.orderDescription) LIKE LOWER(CONCAT('%', ?1,'%'))")
	List<Order> fetchOrdersBasedOnCriteria(String term);

}
