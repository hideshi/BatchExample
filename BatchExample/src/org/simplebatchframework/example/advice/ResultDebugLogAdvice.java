package org.simplebatchframework.example.advice;

import org.simplebatchframework.core.advice.AbstractAdvice;

public class ResultDebugLogAdvice extends AbstractAdvice {
	
	@Override
	public void execute() {
		logger.debug(result);
	}
}
