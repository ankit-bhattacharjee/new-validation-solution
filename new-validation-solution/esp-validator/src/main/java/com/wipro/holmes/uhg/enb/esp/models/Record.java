package com.wipro.holmes.uhg.enb.esp.models;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Record {
	private String fileId;
	private List<Field> fields;

}
