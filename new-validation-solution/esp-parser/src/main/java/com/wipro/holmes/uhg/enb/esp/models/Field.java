package com.wipro.holmes.uhg.enb.esp.models;

import lombok.Builder;
import lombok.Data;

//@Data
@Builder
public class Field {
	private String name;
	private String value;

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

}
