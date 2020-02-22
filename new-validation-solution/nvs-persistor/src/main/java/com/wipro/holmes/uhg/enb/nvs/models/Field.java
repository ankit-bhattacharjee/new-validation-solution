package com.wipro.holmes.uhg.enb.nvs.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
	private String name;
	private String value;
	private String error = "";

}