package org.paymentservice.controller;

import javax.inject.Inject;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/receive")
public class OrderReceiveController {
	
	@Inject
	private RuntimeService runtimeService;
	
	@GetMapping(path = "/getOrder/{id}")
	public String receiveorder(@PathVariable("id") String orderId) {
		ProcessInstance instance = runtimeService.startProcessInstanceByKey("process", orderId);
		return instance.getProcessInstanceId();
	}
	
	
	

}
