package com.wipro.holmes.uhg.enb.nvs.models;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "record")
@Data
public class Record {

	@Id
	private long id;
	private final Map<String, Field> fields;

	public Record() {
		this.fields = new LinkedHashMap<>();
	}

}
