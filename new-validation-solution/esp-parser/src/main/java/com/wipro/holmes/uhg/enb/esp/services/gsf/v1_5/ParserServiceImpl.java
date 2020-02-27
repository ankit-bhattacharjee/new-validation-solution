package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_5;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.services.ParserService;

@Service(GSF_1_5 + SERVICE)
public class ParserServiceImpl implements ParserService {

	private final Parser<Long, Record> parser;
	private final KafkaTemplate<String, Record> template;
	private static final String TOPIC_NAME = "parser-producers-gsf-1.5";

	public ParserServiceImpl(@Qualifier(GSF_1_5 + PARSER) Parser<Long, Record> parser,
			KafkaTemplate<String, Record> template) {
		this.parser = parser;
		this.template = template;
	}

	@Override
	public void parseAndPublish(String path) throws Exception {
		long fileId = System.currentTimeMillis();
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			while (reader.ready()) {
				Record record = parser.parse(fileId, reader.readLine());
				template.send(TOPIC_NAME, record);
			}
		}
	}
}
