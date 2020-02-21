package com.wipro.holmes.uhg.enb.nvs.services;

public interface Parser<T> {

	/*
	 * Parses a supported file into meaningful Record implementation.
	 * 
	 * @param Object physical record
	 * 
	 * @return T implementation(domain record)
	 * 
	 */
	T parse(Object physicalRecord);

}
