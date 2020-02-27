package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.*;
import java.nio.file.Paths;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.monitorjbl.xlsx.StreamingReader;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@Service(GSF_1_3 + SERVICE)
public class ParserServiceImpl implements ParserService {

	private final Parser<Long, Record> parser;
	private KafkaTemplate<String, Record> template;
	private static final String PRODUCER_TOPIC_NAME = "producers-parser-gsf-1-3";
	private static final String CONSUMER_TOPIC_NAME = "producers-orchestrator-upload-file";
	private static final String TEMPLATE_SHEET_NAME = "Enrollment Template";
	private static final int ROW_CACHE = 10;
	private static final int BUFFER = 4096;

	public ParserServiceImpl(@Qualifier(GSF_1_3 + PARSER) Parser<Long, Record> parser,
			KafkaTemplate<String, Record> template) {
		this.parser = parser;
		this.template = template;
	}

	@Override
	@KafkaListener(topics = CONSUMER_TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void parseAndPublish(String path) throws Exception {
		try (Workbook workbook = StreamingReader.builder().rowCacheSize(ROW_CACHE).bufferSize(BUFFER)
				.open(Paths.get(path).toFile())) {
			Iterator<Row> rowIterator = workbook.getSheet(TEMPLATE_SHEET_NAME).iterator();
			int count = 0;
			long fileId = System.currentTimeMillis();
			// Skips the header row
			if (rowIterator.hasNext())
				rowIterator.next();
//			while (rowIterator.hasNext()) {
//				Record record = parser.parse(fileId, rowIterator.next());
//				template.send(PRODUCER_TOPIC_NAME, record);
//			}

			while (rowIterator.hasNext()) {
				if (count++ == 2)
					break;
				Record record = parser.parse(fileId, rowIterator.next());
				template.send(PRODUCER_TOPIC_NAME, record);
			}
			System.out.println("Sent to Validator");
		}
	}
}
