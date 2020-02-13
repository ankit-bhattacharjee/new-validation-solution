package com.wipro.holmes.uhg.enb.nvs.services;

import java.util.Collection;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.exceptions.ValidatorException;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.models.ValidateStrategy;
import com.wipro.holmes.uhg.enb.nvs.services.validators.Validator;

@Service
public class ValidatorServiceImpl implements ValidatorService<Record> {

	private final Map<String, Validator<Record>> validators;

	public ValidatorServiceImpl(@Autowired Map<String, Validator<Record>> validators) {
		this.validators = validators;
	}

	@Override
	public Collection<Record> validate(Collection<Record> records, ValidateStrategy strategy)
			throws ValidatorException {
		Validator<Record> validator = validators.get(strategy.toString());
		if (validator == null)
			throw new ValidatorException("Validator Not Implemented");
		records.stream().forEach(record -> validator.validate(record));
		return records;
	}

}
