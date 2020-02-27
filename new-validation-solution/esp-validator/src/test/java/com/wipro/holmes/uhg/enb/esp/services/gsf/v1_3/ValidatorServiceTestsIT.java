package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_3;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.SERVICE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.ValidatorService;

@SpringBootTest
public class ValidatorServiceTestsIT {

	@Autowired
	@Qualifier(GSF_1_3 + SERVICE)
	private ValidatorService<Record> service;

	@Test
	public void parseAndPublishEntireFileFields() throws Exception {
	}

}
