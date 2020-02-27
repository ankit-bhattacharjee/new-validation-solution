package com.wipro.holmes.uhg.enb.esp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.PersistorService;

@RestController
@RequestMapping("/records")
public class PersistorController {

	private final PersistorService<Record> service;

	public PersistorController(PersistorService<Record> service) {
		this.service = service;
	}

	@RequestMapping(method = GET, value = "/{recordId}")
	public Record find(@PathVariable String recordId) {
		return service.find(recordId);
	}

	@RequestMapping(method = GET, params = "fileId")
	public List<Record> findAll(@RequestParam String fileId) {
		return service.findAll(fileId);
	}

//	@RequestMapping(method = GET, params = { "fileId", "page", "size" })
//	public List<Record> findAll(@RequestParam String fileId, @RequestParam int page, @RequestParam int size) {
//		return service.findAll(fileId, page, size);
//	}

	@RequestMapping(method = PUT, value = "/{recordId}")
	public Record update(@PathVariable String recordId, @RequestBody Record record) {
		return service.update(recordId, record);
	}

	@RequestMapping(method = DELETE, value = "/{recordId}")
	public void delete(@PathVariable String recordId, @RequestBody Record record) {
		service.delete(recordId, record);
	}

}
