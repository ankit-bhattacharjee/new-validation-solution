package com.wipro.holmes.uhg.enb.esp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.holmes.uhg.enb.esp.services.UploadService;

@RestController
@CrossOrigin(value = "*")
public class UploadController {

	private UploadService service;

	public UploadController(UploadService service) {
		this.service = service;
	}

	@PostMapping("/upload-file")
	public void uploadFile(@RequestParam MultipartFile file) throws Exception {
		service.uploadAndPublish(file);
	}

}
