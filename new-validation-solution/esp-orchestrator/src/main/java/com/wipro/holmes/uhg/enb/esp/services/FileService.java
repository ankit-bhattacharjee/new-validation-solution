package com.wipro.holmes.uhg.enb.esp.services;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	/*
	 * Returns the template file
	 * 
	 * @throws Exception
	 * 
	 * @returns InputStream
	 */

	InputStream readFile() throws Exception;

	/*
	 * Creates a physical representation of the file (FileSystem/DB etc) depending
	 * on the implementation
	 * 
	 * @param MultipartFile
	 * 
	 * @return String
	 * 
	 * @throws Exception
	 */

	String saveFile(MultipartFile file) throws Exception;

	/*
	 * Publishes the physical address of the file
	 * 
	 * @param String
	 * 
	 * @return int
	 * 
	 * @throws Exception
	 */
	int publishFile(String fileId) throws IOException;

}
