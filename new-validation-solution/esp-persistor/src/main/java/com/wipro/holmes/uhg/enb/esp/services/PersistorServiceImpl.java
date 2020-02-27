package com.wipro.holmes.uhg.enb.esp.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.repositories.PersistorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersistorServiceImpl implements PersistorService<Record> {

	private final PersistorRepository repository;
	private static final String CONSUMER_TOPIC_NAME = "producers-validator-gsf-1-3";

	@Override
	@KafkaListener(topics = CONSUMER_TOPIC_NAME, containerFactory = "kafkaListenerContainerFactory")
	public void persist(Record record) {
		repository.save(record);
		System.out.println("Persist complete");
	}

}
