package com.wipro.holmes.uhg.enb.esp.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Record {
	private final long fileId;
	private final List<Field> fields;

	public Record(long fileId) {
		this.fileId = fileId;
		fields = new ArrayList<>();
	}

}
