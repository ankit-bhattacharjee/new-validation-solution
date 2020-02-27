package com.wipro.holmes.uhg.enb.esp.services;

import com.wipro.holmes.uhg.enb.esp.exceptions.ValidatorException;

public interface ValidatorService<T> {

	/*
	 * Validates Streaming Records of type T, using Business Rules. Listens to a
	 * Producer channel and performs validation after which, the domain model is
	 * pushed to another stream for consumption.
	 * 
	 * @param T record
	 * 
	 * @throws ValidatorException
	 * 
	 */

	void validateAndPublish(T record) throws ValidatorException;

}
