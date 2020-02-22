package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import java.nio.file.Path;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.monitorjbl.xlsx.StreamingReader;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.services.ParserService;
import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;

@Service(GSF_1_3 + SERVICE)
public class ParserServiceImpl implements ParserService<Record> {

	private final Parser<Record> parser;
	private KafkaTemplate<String, Record> template;
	private static final String TOPIC_NAME = "producers-parser-gsf-1-3";
	private static final String TEMPLATE_SHEET_NAME = "Enrollment Template";
	private static final int ROW_CACHE = 10;
	private static final int BUFFER = 4096;

	public ParserServiceImpl(@Qualifier(GSF_1_3 + PARSER) Parser<Record> parser,
			KafkaTemplate<String, Record> template) {
		this.parser = parser;
		this.template = template;
	}

	@Override
	public void parseAndPublish(Path path) throws Exception {
		try (Workbook workbook = StreamingReader.builder().rowCacheSize(ROW_CACHE).bufferSize(BUFFER)
				.open(read(path))) {
			Iterator<Row> rowIterator = workbook.getSheet(TEMPLATE_SHEET_NAME).iterator();
			int count = 0;
//			while (rowIterator.hasNext()) {
//				Record record = parser.parse(rowIterator.next());
//				template.send(TOPIC_NAME, record);
//			}

			while (rowIterator.hasNext()) {
				if (count++ == 2)
					break;
				Record record = parser.parse(rowIterator.next());
				template.send(TOPIC_NAME, "MY_KEY", record);
			}
		}
	}
}
