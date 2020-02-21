package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.FileSystemResource;
import com.monitorjbl.xlsx.StreamingReader;
import com.wipro.holmes.uhg.enb.nvs.models.Record;

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
	public void parseOneFileField()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		try (Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(path.toFile())) {
			Iterator<Row> rowIterator = workbook.getSheet("Enrollment Template").iterator();
			int count = 0;
			while (rowIterator.hasNext()) {
				if (count++ == 0)
					continue;
				Record record = parser.parse(rowIterator.next());
				assertNotNull(record);
				record.getFields().keySet().stream()
						.forEach(key -> System.out.format("Key : [%s], Value : [%s]" + System.lineSeparator(), key,
								record.getFields().get(key).getValue()));
				break;
			}
		}
	}

	@Test
	public void parseAllFileFields()
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		try (Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096).open(path.toFile())) {
			Iterator<Row> rowIterator = workbook.getSheet("Enrollment Template").iterator();
			while (rowIterator.hasNext()) {
				Record record = parser.parse(rowIterator.next());
				assertNotNull(record);
			}
		}
	}

}
