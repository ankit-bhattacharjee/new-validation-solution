package com.wipro.holmes.uhg.enb.esp.services;

public interface Parser<ID, R> {

	/*
	 * Parses a supported file into meaningful Record implementation.
	 * 
	 * @param fileId, all records within the same file should have similar id value
	 * 
	 * @param Object physical record
	 * 
	 * @return R implementation(domain record)
	 * 
	 */
	R parse(ID fileId, Object physicalRecord);

}
