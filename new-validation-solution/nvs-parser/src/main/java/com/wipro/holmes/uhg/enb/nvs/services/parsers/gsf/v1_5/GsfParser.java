package com.wipro.holmes.uhg.enb.nvs.services.parsers.gsf.v1_5;

import java.text.ParseException;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.models.gsf.v1_5.Fields.File;
import com.wipro.holmes.uhg.enb.nvs.models.gsf.v1_5.Fields.Header;
import com.wipro.holmes.uhg.enb.nvs.services.parsers.Parser;

@Service("GSF_1.5")
public class GsfParser implements Parser<Record> {

	@Override
	public Record parse(String line) throws ParseException {
		Record record = new Record();
		if (line.length() == 28)
			parseHeaderFields(record, line);
		else
			parseFileFields(record, line);
		return record;
	}

	private void parseHeaderFields(Record record, String line) throws ParseException {
		for (Header header : Header.values()) {
			record.getFields().put(header.toString(), Field.builder().size(header.getSize()).name(header.toString())
					.value(line.substring(header.getBegin() - 1, header.getEnd())).build());
		}
	}

	private void parseFileFields(Record record, String line) throws ParseException {
		for (File file : File.values()) {
			if (line.length() < file.getEnd())
				break;
			record.getFields().put(file.toString(), Field.builder().size(file.getSize()).name(file.toString())
					.value(line.substring(file.getBegin() - 1, file.getEnd())).build());
		}
	}

}