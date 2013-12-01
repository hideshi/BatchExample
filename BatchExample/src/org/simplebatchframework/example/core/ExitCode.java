package org.simplebatchframework.example.core;

public enum ExitCode {
	 SUCCESS(0)
	,FAILURE(1)
	,FRAMEWORK_FAILURE(2)
	,DATABASE_FAILURE(3)
	,FILE_IO_FAILURE(4)
	,UNEXPECTED_FAILURE(5)
	;
	private final int code;
	private ExitCode(final int code) {
		this.code = code;
	}
	public int getCode() {
		return this.code;
	}
}
