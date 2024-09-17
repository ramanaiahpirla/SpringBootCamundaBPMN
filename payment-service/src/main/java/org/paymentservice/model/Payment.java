package org.paymentservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.joda.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payment")
public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5125447799175643334L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String paymentId;
	
	private String description;
	
	private Instant paymentDate;

}
