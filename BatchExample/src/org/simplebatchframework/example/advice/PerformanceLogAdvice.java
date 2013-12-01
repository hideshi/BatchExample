package org.simplebatchframework.example.advice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.simplebatchframework.core.advice.AbstractAdvice;

public class PerformanceLogAdvice extends AbstractAdvice {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSSSSSSSS");

	@Override
	public void execute() {
		logger.info("現在時刻:" + sdf.format(new Date(System.currentTimeMillis())));
	}
}
