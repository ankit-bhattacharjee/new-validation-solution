package com.wipro.holmes.uhg.enb.nvs.services.parsers;

import java.text.ParseException;

public interface Parser<T> {

	/*
	 * Parses a line of text into a meaningful Record implementation. Up to the
	 * implementation to check if text is valid and parse-able.
	 * 
	 * @param String line to be parsed
	 * 
	 * @return Record object parsed from this line
	 * 
	 * @throws ParseException should the parser identify an unsupported format
	 * 
	 */
	T parse(String line) throws ParseException;

}
