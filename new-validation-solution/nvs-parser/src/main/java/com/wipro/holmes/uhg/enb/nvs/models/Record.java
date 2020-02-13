package com.wipro.holmes.uhg.enb.nvs.models;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Record {

	private final Map<String, Field> fields;

	public Record() {
		this.fields = new LinkedHashMap<>();
	}

}
