package com.wipro.holmes.uhg.enb.esp.services;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	/*
	 * Accepts a MultipartFile resource and publishes the path on to another
	 * resource for consumption.
	 * 
	 * @param MultipartFile file
	 */

	void uploadAndPublish(MultipartFile file) throws Exception;

}
