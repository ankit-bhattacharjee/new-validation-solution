package com.wipro.holmes.uhg.enb.esp.services;

public interface ParserService {

	/*
	 * Responsible for the construction and publishing of the domain model. Reads
	 * the resource by path and forwards to an appropriate parser, to get the domain
	 * representation. This representation is then published to some resource for
	 * consumption.
	 * 
	 * @param String path to file to be parsed
	 * 
	 * @throws Exception depending on the implementation
	 * 
	 */

	void parseAndPublish(String path) throws Exception;

}
