package org.camundabpmn.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
public class LoanRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8898740307375193230L;
	
	private String firstName;
	private String lastName;
	private long mobile;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dob;
	private int age;
	private String address;
	private String employer;
	private double salary;
	private double requestedAmount;
	
}
