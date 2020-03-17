package com.wipro.holmes.uhg.enb.esp.controllers;

import javax.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.holmes.uhg.enb.esp.models.File;
import com.wipro.holmes.uhg.enb.esp.services.FileService;

@RestController()
@RequestMapping("/files")
@CrossOrigin
public class FileController {

	private FileService<File> service;

	public FileController(FileService<File> service) {
		this.service = service;
	}

	@GetMapping
	public void readFile(HttpServletResponse response) throws Exception {
		FileCopyUtils.copy(service.readFile().getStream(), response.getOutputStream());
	}

	@GetMapping("/{fileId}")
	public void readFile(@PathVariable String fileId, HttpServletResponse response) throws Exception {
		FileCopyUtils.copy(service.readFile(fileId).getStream(), response.getOutputStream());
	}

	@PostMapping
	public String saveFile(@RequestParam(required = true) MultipartFile file) throws Exception {
		return service.saveFile(file);
	}

}
