package com.wipro.holmes.uhg.enb.nvs.models;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Field {
	private final String name;
	private final int size;
	private final String value;
	private Optional<String> error;

	public Field(String name, int size, String value) {
		super();
		this.name = name;
		this.size = size;
		this.value = value;
		error = Optional.empty();
	}

	public int getSize() {
		return size;
	}

	public String getValue() {
		return value;
	}

	public Optional<String> getError() {
		return error;
	}

	public void setError(Optional<String> error) {
		this.error = error;
	}

}
