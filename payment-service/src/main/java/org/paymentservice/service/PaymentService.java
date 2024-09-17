package org.paymentservice.service;

import java.util.List;

import org.paymentservice.model.Payment;
import org.springframework.stereotype.Service;

public interface PaymentService {

	public List<Payment> checkPayment();

}
