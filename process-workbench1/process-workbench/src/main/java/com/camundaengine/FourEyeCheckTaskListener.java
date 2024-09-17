
package com.camundaengine;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FourEyeCheckTaskListener implements TaskListener {

	@Autowired
	RuntimeService runtimeService;

	@Override
	public void notify(DelegateTask delegateTask) {
		String assignee = delegateTask.getAssignee();
		String caseNumber = delegateTask.getProcessInstanceId();
		if (assignee != null) {
			runtimeService.setVariable(caseNumber, "caseStatus", "CLAIMED");
			runtimeService.setVariable(caseNumber, "claimedDate",
					FastDateFormat.getInstance("dd/MM/yyyy").format(new Date()));
			runtimeService.setVariable(caseNumber, "claimedBy", assignee);
		}
	}
}
