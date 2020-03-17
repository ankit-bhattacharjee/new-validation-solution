package com.wipro.holmes.uhg.enb.esp.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Document(collection = "records")
@Data
@JsonPropertyOrder({ "fileId", "_id", "fields" })
public class Record {

	@Id
	@JsonProperty("recordId")
	private String _id;
	private String fileId;
	private List<Field> fields;

	public Record() {
		fields = new ArrayList<>();
	}

}
