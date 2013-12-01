package org.simplebatchframework.example.advice;

import org.simplebatchframework.core.advice.AbstractAdvice;
import org.simplebatchframework.example.core.MessageID;

public class StartLogAdvice extends AbstractAdvice {

	@Override
	public void execute() {
		logger.info(context.getConfiguration().getProperty(MessageID.M0001.toString()));
	}
}
