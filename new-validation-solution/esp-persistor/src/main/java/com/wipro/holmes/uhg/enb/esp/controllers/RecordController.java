package com.wipro.holmes.uhg.enb.esp.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.RecordService;
import static java.lang.Integer.parseInt;

@RestController()
@RequestMapping("/records")
@CrossOrigin
public class RecordController {

	private final RecordService<Record> service;

	public RecordController(RecordService<Record> service) {
		this.service = service;
	}

//	@GetMapping(params = { "fileId" })
//	public Page<Record> findAll(@RequestParam String fileId) {
//		return service.findAll(fileId);
//	}

	@GetMapping(params = { "fileId", "page", "size" })
	public Page<Record> findAll(@RequestParam String fileId, @RequestParam String page, @RequestParam String size)
			throws InterruptedException {
		PageRequest pageRequest = PageRequest.of(parseInt(page), parseInt(size));
		return service.waitAndFindAll(fileId, pageRequest);
	}

}
