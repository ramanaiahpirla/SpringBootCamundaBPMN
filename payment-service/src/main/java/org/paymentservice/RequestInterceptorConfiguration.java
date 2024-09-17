package org.paymentservice;

import org.camunda.bpm.client.interceptor.ClientRequestContext;
import org.camunda.bpm.client.interceptor.ClientRequestInterceptor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestInterceptorConfiguration implements ClientRequestInterceptor{

	@Override
	public void intercept(ClientRequestContext requestContext) {
		
	}

}
