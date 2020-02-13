package com.wipro.holmes.uhg.enb.nvs.services.validators.gsf.v1_5;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.models.gsf.v1_5.Fields.File;

public class GsfValidatorTest {

	private GsfValidator validator;
	private Record record;

	@BeforeEach
	public void setUp() throws IOException {
		validator = new GsfValidator();
		record = new Record();
		Path path = Path.of(new FileSystemResource("src/test/resources/documents/V1.50_Sample.txt").getPath())
				.toAbsolutePath();
		String line = Files.readAllLines(path).get(1);
		for (File file : File.values()) {
			if (line.length() < file.getEnd())
				break;
			record.getFields().put(file.toString(), Field.builder().size(file.getSize()).name(file.toString())
					.value(line.substring(file.getBegin() - 1, file.getEnd())).build());
		}
		// System.out.println(record.getFields().values());
	}

	@Test
	public void testValidate() {
		validator.validate(record);
		System.out.println();
		System.out.println(record.getFields().values());
	}

}
