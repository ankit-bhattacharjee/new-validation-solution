package com.wipro.holmes.uhg.enb.nvs.services;

import java.util.Collection;
import com.wipro.holmes.uhg.enb.nvs.exceptions.ValidatorException;
import com.wipro.holmes.uhg.enb.nvs.models.ValidateStrategy;

public interface ValidatorService<T> {

	/*
	 * Validates Collection, using Business Rules, based on Strategy.
	 * 
	 * @param Collection<T>, ValidateStrategy to be used
	 * 
	 * @return Collection<T> objects parsed from the file, by lines
	 * 
	 * @throws IOException, ParseException
	 * 
	 */

	Collection<T> validate(Collection<T> records, ValidateStrategy strategy) throws ValidatorException;

}
