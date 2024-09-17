package org.paymentservice.service;

import java.util.List;

import org.paymentservice.model.Payment;
import org.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repository;

	@Override
	public List<Payment> checkPayment() {
		return repository.findAll();
	}

}
