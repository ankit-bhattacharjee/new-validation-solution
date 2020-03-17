package com.wipro.holmes.uhg.enb.esp.services;

import org.springframework.kafka.core.KafkaTemplate;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractParserService {
	protected final Parser<String, Record> parser;
	protected final FileService service;
	protected final KafkaTemplate<String, Record> template;
}
