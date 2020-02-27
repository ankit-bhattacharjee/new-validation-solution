package com.wipro.holmes.uhg.enb.esp.services;

import java.io.IOException;
import java.nio.file.Paths;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.wipro.holmes.uhg.enb.esp.config.EspConfiguration;

@Service
public class UploadServiceImpl implements UploadService {

	private final EspConfiguration configuration;
	private final KafkaTemplate<String, String> template;
	private static final String PRODUCER_TOPIC_NAME = "producers-orchestrator-upload-file";
	private static final String EXTENSION = "\\.";

	public UploadServiceImpl(EspConfiguration configuration, KafkaTemplate<String, String> template) {
		this.configuration = configuration;
		this.template = template;
	}

	@Override
	public void uploadAndPublish(MultipartFile file) throws IllegalStateException, IOException {
		String[] fileName = file.getOriginalFilename().split(EXTENSION);
		String path = configuration.getUploadDirectory() + fileName[0] + "_" + System.currentTimeMillis() + "."
				+ fileName[1];
		file.transferTo(Paths.get(path));
		template.send(PRODUCER_TOPIC_NAME, path);
		System.out.println("Sent to Parser");
	}
}
