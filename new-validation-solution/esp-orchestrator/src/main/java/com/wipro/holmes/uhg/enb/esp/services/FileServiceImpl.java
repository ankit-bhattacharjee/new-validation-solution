package com.wipro.holmes.uhg.enb.esp.services;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import com.wipro.holmes.uhg.enb.esp.config.OrchestratorConfiguration;

@Service
public class FileServiceImpl extends AbstractService implements FileService {

	private final String PERSISTOR_URI;
	private final String PARSER_URI;

	public FileServiceImpl(OrchestratorConfiguration configuration) {
		super(configuration);
		this.PERSISTOR_URI = configuration.getPersistorUri() + "/files";
		this.PARSER_URI = configuration.getParserUri() + "/files";
	}

	@Override
	public InputStream readFile() throws Exception {
		ResponseSpec response = client(PERSISTOR_URI).get().retrieve();
		return response.bodyToMono(InputStreamResource.class).block().getInputStream();
	}

	@Override
	public String saveFile(MultipartFile file) throws Exception {
		MultipartBodyBuilder multipartBuilder = new MultipartBodyBuilder();
		multipartBuilder.part("file", new InputStreamResource(file.getInputStream())).filename("file");
		ResponseSpec response = client(PERSISTOR_URI).post().bodyValue(multipartBuilder.build()).retrieve();
		return response.bodyToMono(String.class).block();
	}

	@Override
	public int publishFile(String fileId) throws IOException {
		ResponseSpec response = client(PARSER_URI).put().uri(builder -> builder.queryParam("fileId", fileId).build())
				.retrieve();
		System.out.println("Sent to Parser");
		return response.bodyToMono(Integer.class).block();
	}

}
