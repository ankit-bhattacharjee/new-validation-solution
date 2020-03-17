package com.wipro.holmes.uhg.enb.esp.services;

public interface ParserService {

	/*
	 * Responsible for the construction and publishing of the domain model. Reads
	 * the resource by path and forwards to an appropriate parser, to get the domain
	 * representation. This representation is then published to some resource for
	 * consumption.
	 * 
	 * @param String fileId to be parsed
	 * 
	 * @return int no. of records processed
	 * 
	 * @throws Exception depending on the implementation
	 * 
	 */

	int parseAndPublish(String fileId) throws Exception;

}
