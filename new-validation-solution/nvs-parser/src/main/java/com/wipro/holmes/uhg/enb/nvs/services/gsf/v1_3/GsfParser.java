package com.wipro.holmes.uhg.enb.nvs.services.gsf.v1_3;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.Field;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.Parser;
import com.wipro.holmes.uhg.enb.nvs.specs.gsf.v1_3.Fields;

@Service("GSF_1.3")
public class GsfParser implements Parser<Record> {

	private static final String templateSheetName = "Enrollment Template";

	@Override
	public Collection<Record> parse(Path file)
			throws ParseException, IOException, EncryptedDocumentException, InvalidFormatException {
		List<Record> records = new ArrayList<>();
		try (Workbook workbook = WorkbookFactory.create(new BufferedInputStream(read(file)))) {
			Iterator<Row> rowIterator = workbook.getSheet(templateSheetName).iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Record record = new Record();
				parseFileFields(record, row);
				records.add(record);
			}
		}
		return records;
	}

	private void parseFileFields(Record record, Row row) throws ParseException {
		for (Fields file : Fields.values()) {
			record.getFields().put(file.toString(),
					Field.builder().name(file.toString())
							.value(row.getCell(CellReference.convertColStringToIndex(file.getColumn()),
									MissingCellPolicy.CREATE_NULL_AS_BLANK).toString())
							.build());
		}
	}

}