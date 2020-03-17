package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_3;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.PARSER;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import com.monitorjbl.xlsx.StreamingReader;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.Parser;

@SpringBootTest
public class GsfParserTestsIT {

	@Autowired
	@Qualifier(GSF_1_3 + PARSER)
	private Parser<String, Record> parser;
	private Path path;
	private String fileId;

	@BeforeEach
	public void setUp() throws IOException {
		path = Path.of(new FileSystemResource("src/test/resources/documents/Enrollment_Template.xlsm").getPath())
				.toAbsolutePath();
		fileId = "5e61dba3fbf69a67afb914cb";
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
				Record record = parser.parse(fileId, rowIterator.next());
				record.getFields().forEach(field -> System.out
						.format("ID : [%s], Value : [%s]" + System.lineSeparator(), String.valueOf(fileId), field));
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
				Record record = parser.parse(fileId, rowIterator.next());
				assertNotNull(record);
			}
		}
	}

}
