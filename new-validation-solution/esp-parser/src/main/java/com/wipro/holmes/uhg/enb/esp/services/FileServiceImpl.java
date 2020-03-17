package com.wipro.holmes.uhg.enb.esp.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import com.wipro.holmes.uhg.enb.esp.config.ParserConfiguration;
import com.wipro.holmes.uhg.enb.esp.models.FileMeta;

@Service
public class FileServiceImpl extends AbstractFileService implements FileService {

	private static final String TEMP = System.getProperty("java.io.tmpdir") + "/";

	public FileServiceImpl(ParserConfiguration configuration) {
		super(configuration);
	}

	@Override
	public File readFile(String fileId) throws IllegalStateException, IOException {
		ResponseSpec response = client(configuration.getPersistorUri()).get()
				.uri(builder -> builder.pathSegment(fileId).build()).retrieve();
		InputStream initialStream = response.bodyToMono(InputStreamResource.class).block().getInputStream();
		File file = Paths.get(TEMP + fileId).toFile();
		if (!file.exists())
			Files.copy(initialStream, Files.createFile(Paths.get(TEMP + fileId)), StandardCopyOption.REPLACE_EXISTING);
		return file;
	}

	@Override
	public void saveFileMeta(FileMeta meta) {
		ResponseSpec response = client(configuration.getPersistorUri() + "-meta").post().bodyValue(meta).retrieve();
		response.toBodilessEntity().block();
	}

}
