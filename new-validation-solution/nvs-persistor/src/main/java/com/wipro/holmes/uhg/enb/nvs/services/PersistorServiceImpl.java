package com.wipro.holmes.uhg.enb.nvs.services;

import org.springframework.kafka.annotation.KafkaListener;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.repositories.EnrollmentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersistorServiceImpl implements PersistorService<Record> {

	private final EnrollmentRepository repository;
	private static final String CONSUMER_TOPIC_NAME = "producers-parser-gsf-1-3";

	@Override
	@KafkaListener(topics = CONSUMER_TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void persist(Record record) {
		repository.save(record);
	}

}
