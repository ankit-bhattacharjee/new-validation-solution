package com.wipro.holmes.uhg.enb.nvs.services.validators;

public interface Validator<T> {

	/*
	 * Validates a Type<T> record using Business Rules. Validation happens on the
	 * live object itself.
	 * 
	 * @param T record
	 * 
	 */
	void validate(T record);

}
