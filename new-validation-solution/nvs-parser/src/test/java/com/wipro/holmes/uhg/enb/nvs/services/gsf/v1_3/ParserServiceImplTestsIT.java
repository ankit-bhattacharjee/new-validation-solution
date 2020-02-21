package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import java.io.IOException;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.ParserService;

@SpringBootTest
public class ParserServiceImplTestsIT {

	@Autowired
	@Qualifier(GSF_1_3 + SERVICE)
	private ParserService<Record> service;
	private Path path;

	@BeforeEach
	public void setUp() throws IOException {
		path = Path.of(new FileSystemResource("src/test/resources/documents/Enrollment_Template.xlsm").getPath())
				.toAbsolutePath();
	}

	@Test
	public void parseAndPublishEntireFileFields() throws Exception {
		assertDoesNotThrow(() -> service.parseAndPublish(path));
	}

}
