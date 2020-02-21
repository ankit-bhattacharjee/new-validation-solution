package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_5;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_5.Fields.File;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_5.Fields.Header;
import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;

@Service(GSF_1_5 + PARSER)
@Qualifier(GSF_1_5 + PARSER)
public class GsfParser implements Parser<Record> {

	@Override
	public Record parse(Object physicalRecord) {
		String line = (String) physicalRecord;
		Record domainRecord = new Record();
		if (line.length() == 28)
			parseHeaderFields(domainRecord, line);
		else
			parseFileFields(domainRecord, line);
		return domainRecord;
	}

	private void parseHeaderFields(Record domainRecord, String line) {
		for (Header header : Header.values()) {
			domainRecord.getFields().put(header.toString(), Field.builder().name(header.toString())
					.value(line.substring(header.getBegin() - 1, header.getEnd())).build());
		}
	}

	private void parseFileFields(Record domainRecord, String line) {
		for (File file : File.values()) {
			if (line.length() < file.getEnd())
				break;
			domainRecord.getFields().put(file.toString(), Field.builder().name(file.toString())
					.value(line.substring(file.getBegin() - 1, file.getEnd())).build());
		}
	}

}