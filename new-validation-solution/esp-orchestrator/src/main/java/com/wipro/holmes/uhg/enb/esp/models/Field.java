package com.wipro.holmes.uhg.enb.esp.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Field {
	private String name;
	private String value;
	private String error;
}
