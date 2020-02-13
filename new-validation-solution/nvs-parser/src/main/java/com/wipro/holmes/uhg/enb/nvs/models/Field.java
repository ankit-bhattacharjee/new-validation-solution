package com.wipro.holmes.uhg.enb.nvs.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {
	private final int size;
	private final String name;
	private final String value;
}