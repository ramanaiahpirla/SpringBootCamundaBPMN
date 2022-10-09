package org.camundabpmn.controller;

import java.util.Map;
import java.util.UUID;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camundabpmn.vo.LoanRequest;
import org.camundabpmn.vo.LoanResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/loan")
public class LoanController {

	@Autowired
	RuntimeService runTimeService;

	@PostMapping(path = "/apply")
	public ResponseEntity<LoanResponse> applyLoan(@RequestBody LoanRequest loanRequest) {
		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, Object> variables = mapper.convertValue(loanRequest, Map.class);
		ProcessInstance instance = runTimeService.startProcessInstanceByKey("Process_0sipzko", variables);
		instance.getProcessInstanceId();
		LoanResponse response = new LoanResponse();
		response.setFirstName(loanRequest.getFirstName());
		response.setLastName(loanRequest.getLastName());
		response.setRequestedAmount(loanRequest.getRequestedAmount());
		response.setApplicationId(UUID.randomUUID().toString());
		response.setProcessInstanceId(instance.getProcessInstanceId());
		return new ResponseEntity<LoanResponse>(response, HttpStatus.OK);

	}

}
