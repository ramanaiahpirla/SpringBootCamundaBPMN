package org.ordermanagement.model;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8162091192223981792L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;
	
	@Column(name = "orderName")
	private String orderName;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "orderedDate")
	@CreatedDate
	private Instant orderedDate;
	
	@Column(name = "orderDescription")
	private String orderDescription;

	public Order(String orderName, Double price, String orderDescription) {
		super();
		this.orderName = orderName;
		this.price = price;
		this.orderDescription = orderDescription;
	}
	
	

}
