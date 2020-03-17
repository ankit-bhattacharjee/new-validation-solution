package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_5;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.GSF_1_5;
import static com.wipro.holmes.uhg.enb.esp.models.Constants.PARSER;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.esp.models.Field;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.specs.gsf.v1_5.Fields.File;
import com.wipro.holmes.uhg.enb.esp.specs.gsf.v1_5.Fields.Header;

@Service(GSF_1_5 + PARSER)
@Qualifier(GSF_1_5 + PARSER)
public class GsfParser implements Parser<String, Record> {

	@Override
	public Record parse(String fileId, Object physicalRecord) {
		String line = (String) physicalRecord;
		Record domainRecord = new Record(fileId);
		if (line.length() == 28)
			parseHeaderFields(domainRecord, line);
		else
			parseFileFields(domainRecord, line);
		return domainRecord;
	}

	private void parseHeaderFields(Record domainRecord, String line) {
		for (Header header : Header.values()) {
			domainRecord.getFields().add(Field.builder().name(header.toString())
					.value(line.substring(header.getBegin() - 1, header.getEnd())).build());
		}
	}

	private void parseFileFields(Record domainRecord, String line) {
		for (File file : File.values()) {
			if (line.length() < file.getEnd())
				break;
			domainRecord.getFields().add(Field.builder().name(file.toString())
					.value(line.substring(file.getBegin() - 1, file.getEnd())).build());
		}
	}

}