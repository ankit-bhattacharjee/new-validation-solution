package com.wipro.holmes.uhg.enb.esp.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Field {
	private final String name;
	private final String value;
}
