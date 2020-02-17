package com.wipro.holmes.uhg.enb.nvs.services;

import java.nio.file.Path;
import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.wipro.holmes.uhg.enb.nvs.models.ParseStrategy;
import com.wipro.holmes.uhg.enb.nvs.models.Record;

@Service
public class ParserServiceImpl implements ParserService<Record> {

	protected final Map<String, Parser<Record>> parsers;

	public ParserServiceImpl(Map<String, Parser<Record>> parsers) {
		this.parsers = parsers;
	}

	@Override
	public Collection<Record> parse(Path file, ParseStrategy strategy) throws Exception {
		Parser<Record> parser = parsers.get(strategy.toString());
		if (parser == null)
			throw new ParseException("Parser Not Implemented", -1);
		return parser.parse(file);
	}
}
