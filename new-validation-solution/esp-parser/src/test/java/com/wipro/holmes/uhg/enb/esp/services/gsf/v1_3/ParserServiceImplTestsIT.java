package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@SpringBootTest
public class ParserServiceImplTestsIT {

	@Autowired
	@Qualifier(GSF_1_3 + SERVICE)
	private ParserService service;
	private String fileId;

	@BeforeEach
	public void setUp() throws IOException {
		fileId = "5e61dba3fbf69a67afb914cb";
	}

	@Test
	public void parseAndPublishEntireFileFields() throws Exception {
		assertDoesNotThrow(() -> service.parseAndPublish(fileId));
	}

}
