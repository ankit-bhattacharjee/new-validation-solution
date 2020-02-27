package com.wipro.holmes.uhg.enb.esp.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.esp.models.Constants.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.CellReference;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.esp.models.Field;
import com.wipro.holmes.uhg.enb.esp.models.Record;
import com.wipro.holmes.uhg.enb.esp.services.Parser;
import com.wipro.holmes.uhg.enb.esp.specs.gsf.v1_3.Fields;

@Service(GSF_1_3 + PARSER)
@Qualifier(GSF_1_3 + PARSER)
public class GsfParser implements Parser<Long, Record> {

	@Override
	public Record parse(Long fileId, Object physicalRecord) {
		Row row = (Row) physicalRecord;
		Record domainRecord = new Record(fileId);
		for (Fields file : Fields.values()) {
			domainRecord.getFields()
					.add(Field.builder().name(file.toString())
							.value(row.getCell(CellReference.convertColStringToIndex(file.getColumn()),
									MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue())
							.build());
		}
		return domainRecord;
	}

}