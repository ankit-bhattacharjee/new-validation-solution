package com.wipro.holmes.uhg.enb.esp.controllers;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.holmes.uhg.enb.esp.services.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ESP Records Controller")
@RestController
@RequestMapping(value = "/records", consumes = { ALL_VALUE }, produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class RecordController {

	private final RecordService<String> service;

	public RecordController(RecordService<String> service) {
		this.service = service;
	}

	@ApiOperation(value = "Gets one specific record by recordId")
	@GetMapping("/{recordId}")
	public String findRecord(@PathVariable String recordId) {
		return service.findRecord(recordId);
	}

	@ApiOperation(value = "Updates one specific record by recordId")
	@PutMapping("/{recordId}")
	public String updateRecord(@PathVariable String recordId, @RequestBody String record) {
		return service.updateRecord(recordId, record);
	}

	@ApiOperation(value = "Gets all records by fileId, default size = 20")
	@GetMapping(params = { "fileId" })
	public String findAll(@RequestParam String fileId) {
		return service.findAllRecords(fileId);
	}

	@ApiOperation(value = "Gets all records by fileId, customizable by page and size")
	@GetMapping(params = { "fileId", "page", "size" })
	public String findAll(@RequestParam String fileId, @RequestParam String page, @RequestParam String size) {
		return service.findAllRecords(fileId, page, size);
	}

}
