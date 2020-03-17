package com.wipro.holmes.uhg.enb.esp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@JsonPropertyOrder({ "_id", "records" })
@RequiredArgsConstructor
public class FileMeta {

	@JsonProperty("fileId")
	private final String _id;
	private final int records;
}