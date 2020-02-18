package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_5.Fields.File;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_5.Fields.Header;

@Service("GSF_1.5")
public class GsfParser implements Parser<Record> {

	@Override
	public Collection<Record> parse(Path file) throws ParseException, IOException {
		List<Record> records = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(read(file)))) {
			while (reader.ready()) {
				String line = reader.readLine();
				Record record = new Record();
				if (line.length() == 28)
					parseHeaderFields(record, line);
				else
					parseFileFields(record, line);
				records.add(record);
			}
		}
		return records;
	}

	private void parseHeaderFields(Record record, String line) throws ParseException {
		for (Header header : Header.values()) {
			record.getFields().put(header.toString(), Field.builder().name(header.toString())
					.value(line.substring(header.getBegin() - 1, header.getEnd())).build());
		}
	}

	private void parseFileFields(Record record, String line) throws ParseException {
		for (File file : File.values()) {
			if (line.length() < file.getEnd())
				break;
			record.getFields().put(file.toString(), Field.builder().name(file.toString())
					.value(line.substring(file.getBegin() - 1, file.getEnd())).build());
		}
	}

}