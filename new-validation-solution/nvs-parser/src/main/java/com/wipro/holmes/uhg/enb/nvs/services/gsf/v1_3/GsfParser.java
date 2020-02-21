package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import static com.wipro.holmes.uhg.enb.nvs.models.Constants.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.CellReference;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_3.Fields;

@Service(GSF_1_3 + PARSER)
@Qualifier(GSF_1_3 + PARSER)
public class GsfParser implements Parser<Record> {

	@Override
	public Record parse(Object physicalRecord) {
		Row row = (Row) physicalRecord;
		Record domainRecord = new Record();
		for (Fields file : Fields.values()) {
			domainRecord.getFields().put(file.toString(),
					Field.builder().name(file.toString())
							.value(row.getCell(CellReference.convertColStringToIndex(file.getColumn()),
									MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue())
							.build());
		}
		return domainRecord;
	}

}