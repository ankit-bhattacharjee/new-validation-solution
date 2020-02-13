package com.wipro.holmes.uhg.enb.nvs.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.holmes.uhg.enb.nvs.models.ParseStrategy;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.parsers.Parser;

@Service
public class ParserServiceImpl implements ParserService<Record> {

	private final Map<String, Parser<Record>> parsers;

	public ParserServiceImpl(@Autowired Map<String, Parser<Record>> parsers) {
		this.parsers = parsers;
	}

	@Override
	public Collection<Record> parse(Path file, ParseStrategy strategy) throws IOException, ParseException {
		Parser<Record> parser = parsers.get(strategy.toString());
		if (parser == null)
			throw new ParseException("Parser Not Implemented", -1);
		List<Record> records = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(read(file))) {
			while (reader.ready()) {
				records.add(parser.parse(reader.readLine()));
			}
		}
		return records;
	}

}
