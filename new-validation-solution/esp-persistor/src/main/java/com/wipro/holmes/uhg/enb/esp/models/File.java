package com.wipro.holmes.uhg.enb.esp.models;

import java.io.InputStream;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "files")
@Data
@JsonPropertyOrder({ "_id", "file" })
@RequiredArgsConstructor
public class File {

	@Id
	@JsonProperty("fileId")
	private String _id;
	private final InputStream stream;
}