package org.camundabpmn.vo;

import java.io.Serializable;

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
public class LoanResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5612226607000693813L;
	
	private String firstName;
	private String lastName;
	private String applicationId;
	private double requestedAmount;
	private String processInstanceId;
	
}
