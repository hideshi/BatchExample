package org.simplebatchframework.example.advice;

import org.simplebatchframework.core.advice.AbstractAdvice;
import org.simplebatchframework.example.core.MessageID;

public class EndLogAdvice extends AbstractAdvice {

	@Override
	public void execute() {
		logger.info(context.getConfiguration().getProperty(MessageID.M0002.toString()));
	}
}
