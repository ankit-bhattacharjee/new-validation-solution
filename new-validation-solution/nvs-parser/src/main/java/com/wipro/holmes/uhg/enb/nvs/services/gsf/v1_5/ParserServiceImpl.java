package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_5;

import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.services.ParserService;

@Service(GSF_1_5 + SERVICE)
public class ParserServiceImpl implements ParserService<Record> {

	private final Parser<Record> parser;
	private final KafkaTemplate<String, Record> template;
	private static final String TOPIC_NAME = "parser-producers-gsf-1.5";

	public ParserServiceImpl(@Qualifier(GSF_1_5 + PARSER) Parser<Record> parser,
			KafkaTemplate<String, Record> template) {
		this.parser = parser;
		this.template = template;
	}

	@Override
	public void parseAndPublish(Path path) throws Exception {
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			while (reader.ready()) {
				Record record = parser.parse(reader.readLine());
				template.send(TOPIC_NAME, record);
			}
		}
	}
}
