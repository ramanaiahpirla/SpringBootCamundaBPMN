package org.paymentservice;

import java.util.List;

import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.spring.boot.starter.ClientProperties;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.engine.ExternalTaskService;
import org.camunda.bpm.engine.externaltask.ExternalTaskQueryBuilder;
import org.camunda.bpm.engine.externaltask.ExternalTaskQueryTopicBuilder;
import org.camunda.bpm.engine.externaltask.LockedExternalTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {
	
	@Autowired
	private ExternalTaskService service;
	
	private final String workerId;

	public HandlerConfig(ClientProperties properties) {
		workerId = properties.getWorkerId();
	}

	@ExternalTaskSubscription(topicName = "tasktopic", processDefinitionKey = "Process_19gud8m", includeExtensionProperties = true, variableNames = "collateralRef")
	@Bean
	public ExternalTaskHandler sendEMail() {
		return null;
		
	}
}