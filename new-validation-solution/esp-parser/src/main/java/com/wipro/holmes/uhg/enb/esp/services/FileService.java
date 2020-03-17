package com.wipro.holmes.uhg.enb.esp.services;

import java.io.File;

import com.wipro.holmes.uhg.enb.esp.models.FileMeta;

public interface FileService {

	/*
	 * Gets the persistent representation of the file from the back-end
	 * 
	 * @param String
	 * 
	 * @throws Exception
	 */
	File readFile(String fileId) throws Exception;

	/*
	 * Saves the file meta data for reference, in this case, no. of records in the
	 * current file
	 * 
	 * @param FileMeta
	 */
	void saveFileMeta(FileMeta meta);
}
