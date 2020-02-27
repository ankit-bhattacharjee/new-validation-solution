package com.wipro.holmes.uhg.enb.esp.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import com.wipro.holmes.uhg.enb.esp.models.Record;

import reactor.core.publisher.Mono;

@Service
public class PersistorServiceImpl implements PersistorService<Record> {

	private static final String PERSISTOR_BASE_URI = "http://localhost:8083/records/";

	@Override
	public Record find(String id) {
		WebClient client = WebClient.create(PERSISTOR_BASE_URI);
		return (Record) client.get().uri(id).exchange().block().bodyToMono(Record.class).block();
	}

	@Override
	public List<Record> findAll(String fileId) {
		System.out.println(fileId);
		//WebClient client = WebClient.create(PERSISTOR_BASE_URI);
		List<Record> record = WebClient.create().get().uri(uri -> uri.path(PERSISTOR_BASE_URI).queryParam("fileId", fileId).build()).exchange().block().
				toEntityList(Record.class).block().getBody();
		System.out.println(record);
		return record;
	}

	@Override
	public List<Record> findAll(String fileId, int page, int size) {
		System.out.println(fileId);
		WebClient client = WebClient.create(PERSISTOR_BASE_URI);
		List<Record> record = client.get()
				.uri(uri -> uri.queryParam("fileId", fileId).queryParam("page", page).queryParam("size", size).build())
				.retrieve().toEntityList(Record.class).block().getBody();
		System.out.println(record);
		return record;
	}

	@Override
	public Record update(String id, Record record) {
		WebClient client = WebClient.create(PERSISTOR_BASE_URI);
		record = client.put().uri(id).body(BodyInserters.fromValue(record)).retrieve().toEntity(Record.class).block()
				.getBody();
		System.out.println(record);
		return record;
	}

	@Override
	public void delete(String id, Record record) {
		WebClient client = WebClient.create(PERSISTOR_BASE_URI);
		record = client.delete().uri(id).retrieve().toEntity(Record.class).block().getBody();
		System.out.println(record);

	}

}
