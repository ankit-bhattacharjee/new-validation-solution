package com.wipro.holmes.uhg.enb.nvs.exceptions;

public class ValidatorException extends RuntimeException {

	private static final long serialVersionUID = -890749848905994233L;
	private static final String message = "Validator Exception";

	public ValidatorException() {
		super(message);
	}

	public ValidatorException(String message) {
		super(message);
	}

}
