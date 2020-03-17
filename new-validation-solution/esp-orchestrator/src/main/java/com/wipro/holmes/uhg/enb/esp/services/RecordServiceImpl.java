package com.wipro.holmes.uhg.enb.esp.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import com.wipro.holmes.uhg.enb.esp.config.OrchestratorConfiguration;

@Service
public class RecordServiceImpl extends AbstractService implements RecordService<String> {

	private final String URI;
	private static final String FILE = "fileId";
	private static final String PAGE = "page";
	private static final String SIZE = "size";

	public RecordServiceImpl(OrchestratorConfiguration configuration) {
		super(configuration);
		this.URI = configuration.getPersistorUri() + "/records";
	}

	@Override
	public String findRecord(String recordId) {
		ResponseSpec response = client(URI).get().uri(builder -> builder.pathSegment(recordId).build()).retrieve();
		return response.toEntity(String.class).block().getBody();
	}

	@Override
	public String updateRecord(String recordId, String record) {
		ResponseSpec response = client(URI).put().uri(builder -> builder.pathSegment(recordId).build())
				.bodyValue(record).header("Content-Type", MediaType.APPLICATION_JSON_VALUE).retrieve();
		return response.toEntity(String.class).block().getBody();
	}

	@Override
	public String findAllRecords(String fileId) {
		ResponseSpec response = client(URI).get().uri(builder -> builder.queryParam(FILE, fileId).build()).retrieve();
		return response.toEntity(String.class).block().getBody();
	}

	@Override
	public String findAllRecords(String fileId, String page, String size) {
		ResponseSpec response = client(URI).get()
				.uri(builder -> builder.queryParam(FILE, fileId).queryParam(PAGE, page).queryParam(SIZE, size).build())
				.retrieve();
		return response.toEntity(String.class).block().getBody();
	}

}
