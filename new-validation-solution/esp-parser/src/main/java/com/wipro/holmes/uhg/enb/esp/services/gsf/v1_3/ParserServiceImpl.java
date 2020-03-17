package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_3;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.PARSER;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.SERVICE;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.monitorjbl.xlsx.StreamingReader;
import com.wipro.holmes.uhg.enb.esp.models.FileMeta;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.AbstractParserService;
import com.wipro.holmes.uhg.enb.esp.services.FileService;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@Service(GSF_1_3 + SERVICE)
@Qualifier(GSF_1_3 + SERVICE)
public class ParserServiceImpl extends AbstractParserService implements ParserService {

	private static final String PRODUCER_TOPIC_NAME = "producers-parser-gsf-1-3";
	private static final String TEMPLATE_SHEET_NAME = "Enrollment Template";
	private static final int ROW_CACHE = 100;
	private static final int BUFFER = 8192;

	public ParserServiceImpl(@Qualifier(GSF_1_3 + PARSER) Parser<String, Record> parser, FileService service,
			KafkaTemplate<String, Record> template) {
		super(parser, service, template);
	}

	@Override
	public int parseAndPublish(String fileId) throws Exception {
		try (Workbook workbook = StreamingReader.builder().rowCacheSize(ROW_CACHE).bufferSize(BUFFER)
				.open(service.readFile(fileId))) {
			FileMeta meta = new FileMeta(fileId, workbook.getSheet(TEMPLATE_SHEET_NAME).getLastRowNum());
			service.saveFileMeta(meta);
			Iterator<Row> rowIterator = workbook.getSheet(TEMPLATE_SHEET_NAME).iterator();
			// Skips the header row
			if (rowIterator.hasNext())
				rowIterator.next();
			while (rowIterator.hasNext()) {
				Record record = parser.parse(fileId, rowIterator.next());
				template.send(PRODUCER_TOPIC_NAME, record);
			}
//			int count = 0;
//			while (rowIterator.hasNext()) {
//				if (count++ == 2)
//					break;
//				Record record = parser.parse(fileId, rowIterator.next());
//				template.send(PRODUCER_TOPIC_NAME, record);
//				records += 1;
//			}
			System.out.println(meta.getRecords() + " Sent to validator");
			return meta.getRecords();
		}
	}
}