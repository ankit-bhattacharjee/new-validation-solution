package com.wipro.holmes.uhg.enb.esp.controllers;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_3;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.SERVICE;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@RestController
@RequestMapping(value = "/files")
public class ParserController {

	private final ParserService service;

	public ParserController(@Qualifier(GSF_1_3 + SERVICE) ParserService service) {
		this.service = service;
	}

	@PutMapping
	public int parseAndPublish(@RequestParam String fileId) throws Exception {
		return service.parseAndPublish(fileId);
	}

}
