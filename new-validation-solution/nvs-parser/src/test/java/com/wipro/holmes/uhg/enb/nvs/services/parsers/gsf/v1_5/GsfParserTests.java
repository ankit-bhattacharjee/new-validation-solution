package com.wipro.holmes.uhg.enb.nvs.services.parsers.gsf.v1_5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.models.gsf.v1_5.Fields.File;
import com.wipro.holmes.uhg.enb.nvs.models.gsf.v1_5.Fields.Header;
import com.wipro.holmes.uhg.enb.nvs.services.parsers.gsf.v1_5.GsfParser;

@ExtendWith(MockitoExtension.class)
public class GsfParserTests {

	private GsfParser parser;
	private Path path;
	private List<String> lines;
	private int headerFieldsCount;

	@BeforeEach
	public void setUp() throws IOException {
		parser = new GsfParser();
		path = Path.of(new FileSystemResource("src/test/resources/documents/V1.50_Sample.txt").getPath())
				.toAbsolutePath();
		lines = Files.readAllLines(path);
		headerFieldsCount = 3;
	}

	@Test
	public void parseHeaderFieldsFlowTest() throws ParseException {
		Record record = parser.parse(lines.get(0));
		assertNotNull(record);
		assertEquals(headerFieldsCount, record.getFields().size());
	}

	@Test
	public void parseHeaderFieldsLengthTest() throws ParseException {
		Record record = parser.parse(lines.get(0));
		for (Header header : Header.values()) {
			assertEquals(header.getSize(), record.getFields().get(header.toString()).getValue().length());
		}
	}

	@Test
	public void parseHeaderFieldsValueTest() throws ParseException {
		Record record = parser.parse(lines.get(0));
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsFlowTest_1() throws ParseException {
		Record record = parser.parse(lines.get(1));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_2() throws ParseException {
		Record record = parser.parse(lines.get(2));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_3() throws ParseException {
		Record record = parser.parse(lines.get(3));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_4() throws ParseException {
		Record record = parser.parse(lines.get(4));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_5() throws ParseException {
		Record record = parser.parse(lines.get(5));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_6() throws ParseException {
		Record record = parser.parse(lines.get(6));
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsLengthTest_1() throws ParseException {
		Record record = parser.parse(lines.get(1));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsLengthTest_2() throws ParseException {
		Record record = parser.parse(lines.get(2));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsLengthTest_3() throws ParseException {
		Record record = parser.parse(lines.get(3));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsLengthTest_4() throws ParseException {
		Record record = parser.parse(lines.get(4));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsLengthTest_5() throws ParseException {
		Record record = parser.parse(lines.get(5));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsLengthTest_6() throws ParseException {
		Record record = parser.parse(lines.get(6));
		for (File file : File.values()) {
			if (record.getFields().get(file.toString()) != null)
				assertEquals(file.getSize(), record.getFields().get(file.toString()).getValue().length());
		}
	}

	@Test
	public void parseFileFieldsValueTest_1() throws ParseException {
		Record record = parser.parse(lines.get(1));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_1 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsValueTest_2() throws ParseException {
		Record record = parser.parse(lines.get(2));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_2 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsValueTest_3() throws ParseException {
		Record record = parser.parse(lines.get(3));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_3 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsValueTest_4() throws ParseException {
		Record record = parser.parse(lines.get(4));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_4 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsValueTest_5() throws ParseException {
		Record record = parser.parse(lines.get(5));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_5 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

	@Test
	public void parseFileFieldsValueTest_6() throws ParseException {
		Record record = parser.parse(lines.get(6));
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_6 : [%s], Value : [%s]", key, record.getFields().get(key)));
	}

}
