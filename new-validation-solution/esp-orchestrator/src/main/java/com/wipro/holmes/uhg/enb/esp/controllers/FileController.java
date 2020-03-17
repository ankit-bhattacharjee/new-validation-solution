package com.wipro.holmes.uhg.enb.esp.controllers;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.holmes.uhg.enb.esp.services.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "ESP Files Controller")
@RestController
@RequestMapping(value = "/files", consumes = { ALL_VALUE }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class FileController {

	private FileService service;

	public FileController(FileService service) {
		this.service = service;
	}

	@ApiOperation(value = "Gets the template file representation from the ESP back-end system")
	@GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void readFile(HttpServletResponse response) throws Exception {
		response.addHeader("Content-disposition", "attachment;filename=template.xls");
		FileCopyUtils.copy(service.readFile(), response.getOutputStream());
	}

	@ApiOperation(value = "Creates a physical file in the ESP back-end system")
	@PostMapping
	public String saveFile(@ApiParam(value = "MultipartFile", required = true) @RequestParam MultipartFile file)
			throws Exception {
		String saveFile = service.saveFile(file);
		System.out.println(saveFile);
		return saveFile;
	}

	@ApiOperation(value = "Publishes the file for downstream processing (blocking call)")
	@PutMapping
	public int publishFile(@ApiParam(value = "String", required = true) @RequestParam String fileId) throws Exception {
		return service.publishFile(fileId);
	}

}
