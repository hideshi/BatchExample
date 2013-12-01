package org.simplebatchframework.example.core;

import org.simplebatchframework.core.CommonContext;
import org.simplebatchframework.core.annotation.Param;
import org.simplebatchframework.core.annotation.ValidateLength;
import org.simplebatchframework.core.annotation.ValidateRegexp;

public class B0001Context extends CommonContext {

	@Param(column=1)
	@ValidateRegexp(regexp="^[0-9]{8}$")
	private String date;
	
	@Param(column=2)
	@ValidateLength(minLength=1, maxLength=1)
	@ValidateRegexp(regexp="^[A-C]$")
	private String type;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
