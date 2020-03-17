package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_5;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_5;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.PARSER;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.SERVICE;
import java.io.BufferedReader;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.esp.models.FileMeta;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.AbstractParserService;
import com.wipro.holmes.uhg.enb.esp.services.FileService;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@Service(GSF_1_5 + SERVICE)
@Qualifier(GSF_1_5 + SERVICE)
public class ParserServiceImpl extends AbstractParserService implements ParserService {

	private static final String TOPIC_NAME = "parser-producers-gsf-1.5";

	public ParserServiceImpl(@Qualifier(GSF_1_5 + PARSER) Parser<String, Record> parser, FileService service,
			KafkaTemplate<String, Record> template) {
		super(parser, service, template);
	}

	@Override
	public int parseAndPublish(String fileId) throws Exception {
		try (BufferedReader reader = Files.newBufferedReader(service.readFile(fileId).toPath())) {
			int records = 0;
			while (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				template.send(TOPIC_NAME, record);
				records += 1;
			}
			FileMeta meta = new FileMeta(fileId, records);
			service.saveFileMeta(meta);
			return meta.getRecords();
		}
	}
}
