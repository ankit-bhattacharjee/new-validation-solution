package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.gsf.v1_5.GsfParser;
import com.wipro.holmes.uhg.enb.esp.specs.gsf.v1_5.Fields.Header;

@ExtendWith(MockitoExtension.class)
public class GsfParserTests {

	private GsfParser parser;
	private Path path;
	private int headerFieldsCount;

	@BeforeEach
	public void setUp() throws IOException {
		parser = new GsfParser();
		path = Path.of(new FileSystemResource("src/test/resources/documents/V1.50_Sample.txt").getPath())
				.toAbsolutePath();
		headerFieldsCount = 3;
	}

	@Test
	public void parseHeaderFieldsFlowTest() throws ParseException, IOException {
		String fileId = String.valueOf(System.currentTimeMillis());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			if (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				assertNotNull(record);
				assertEquals(headerFieldsCount, record.getFields().size());
			}
		}
	}

	@Test
	public void parseHeaderFieldsLengthTest() throws ParseException, IOException {
		String fileId = String.valueOf(System.currentTimeMillis());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			if (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				for (Header header : Header.values()) {
					assertEquals(header.getSize(), record.getFields().get(0).getValue().length());
				}
			}
		}
	}

	@Test
	public void parseHeaderFieldsValueTest() throws ParseException, IOException {
		String fileId = String.valueOf(System.currentTimeMillis());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			if (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				record.getFields().forEach(field -> System.out
						.format("ID : [%s], Value : [%s]" + System.lineSeparator(), String.valueOf(fileId), field));
			}
		}
	}

//	@Test
//	public void parseFileFieldsLengthTest_1() throws ParseException, IOException {
//		long id = System.currentTimeMillis();
//		try (BufferedReader reader = Files.newBufferedReader(path)) {
//			while (reader.ready()) {
//				Record record = parser.parse(id, reader.readLine());
//				for (File file : File.values()) {
//					if (record.getFields().get(file.toString()) != null)
//						assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
//				}
//			}
//		}
//	}

	@Test
	public void parseFileFieldsValueTest_1() throws ParseException, IOException {
		String fileId = String.valueOf(System.currentTimeMillis());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			while (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				record.getFields().forEach(field -> System.out
						.format("ID : [%s], Value : [%s]" + System.lineSeparator(), String.valueOf(fileId), field));
				System.out.println(System.lineSeparator());
			}
		}
	}

}
