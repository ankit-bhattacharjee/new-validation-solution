package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3.GsfParser;

@ExtendWith(MockitoExtension.class)
public class GsfParserTests {

	private GsfParser parser;
	private Path path;

	@BeforeEach
	public void setUp() throws IOException {
		parser = new GsfParser();
		path = Path.of(new FileSystemResource("src/test/resources/documents/Enrollment_Template.xlsm").getPath())
				.toAbsolutePath();
	}

	@Test
	public void parseFileFieldsFlowTest_1()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(1);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_2()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(2);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_3()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(3);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_4()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(4);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_5()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(5);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsFlowTest_6()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(6);
		assertNotNull(record);
	}

	@Test
	public void parseFileFieldsValueTest_1()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(1);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_1 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

	@Test
	public void parseFileFieldsValueTest_2()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(2);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_2 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

	@Test
	public void parseFileFieldsValueTest_3()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(3);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_3 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

	@Test
	public void parseFileFieldsValueTest_4()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(4);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_4 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

	@Test
	public void parseFileFieldsValueTest_5()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(5);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_5 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

	@Test
	public void parseFileFieldsValueTest_6()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		Record record = Lists.newArrayList(parser.parse(path)).get(6);
		System.out.println(System.lineSeparator());
		record.getFields().keySet().stream()
				.forEach(key -> System.out.format("Key_6 : [%s], Value : [%s]" + System.lineSeparator(), key,
						record.getFields().get(key).getValue()));
	}

}
