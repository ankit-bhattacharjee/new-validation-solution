package com.wipro.holmes.uhg.enb.nvs.models;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
	private String name;
	private String value;
	private Optional<String> error = Optional.empty();

}