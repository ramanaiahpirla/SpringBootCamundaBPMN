package org.paymentservice.controller;

import java.util.List;

import org.paymentservice.model.Payment;
import org.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping(path = "/verifyPayment")
	public ResponseEntity<List<Payment>> verifyPayment(){
		return new ResponseEntity<List<Payment>>(paymentService.checkPayment(), HttpStatus.OK);
	}
	

}
