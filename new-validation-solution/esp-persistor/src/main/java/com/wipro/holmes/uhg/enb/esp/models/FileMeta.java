package com.wipro.holmes.uhg.enb.esp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Document(collection = "meta")
@Data
@JsonPropertyOrder({ "_id", "records" })
@RequiredArgsConstructor
public class FileMeta {

	@Id
	@JsonProperty("fileId")
	private final String _id;
	private final int records;
}