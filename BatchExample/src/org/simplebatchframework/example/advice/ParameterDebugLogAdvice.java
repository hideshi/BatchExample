package org.simplebatchframework.example.advice;

import org.simplebatchframework.core.advice.AbstractAdvice;

public class ParameterDebugLogAdvice extends AbstractAdvice {
	
	@Override
	public void execute() {
		logger.debug(conditionBean);
	}
}
