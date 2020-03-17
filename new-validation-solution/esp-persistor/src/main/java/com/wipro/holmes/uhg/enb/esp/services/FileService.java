package com.wipro.holmes.uhg.enb.esp.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService<T> {

	/*
	 * Returns the template file
	 * 
	 * @throws Exception
	 * 
	 * @returns T
	 */

	T readFile() throws Exception;

	/*
	 * An event driven, domain independent approach to read a file by fileId
	 * 
	 * @param String
	 * 
	 * @throws Exception
	 * 
	 * @returns T
	 */

	T readFile(String fileId) throws Exception;

	/*
	 * An event driven, domain independent approach to persistence of a file
	 * 
	 * @param Multipart
	 * 
	 * @throws Exception
	 * 
	 * @returns String
	 */

	String saveFile(MultipartFile file) throws Exception;

}
