package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;

import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@SpringBootTest
public class ParserServiceImplTestsIT {

	@Autowired
	@Qualifier(GSF_1_3 + SERVICE)
	private ParserService service;
	private static final String path = "src/test/resources/documents/Enrollment_Template.xlsm";

	@BeforeEach
	public void setUp() throws IOException {
	}

	@Test
	public void parseAndPublishEntireFileFields() throws Exception {
		assertDoesNotThrow(() -> service
				.parseAndPublish(Path.of(new FileSystemResource(path).getPath()).toAbsolutePath().toString()));
	}

}
