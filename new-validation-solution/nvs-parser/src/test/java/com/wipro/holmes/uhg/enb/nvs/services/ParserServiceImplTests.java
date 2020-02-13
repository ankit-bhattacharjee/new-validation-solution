package com.wipro.holmes.uhg.enb.nvs.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.FileSystemResource;
import com.wipro.holmes.uhg.enb.nvs.models.ParseStrategy;
import com.wipro.holmes.uhg.enb.nvs.models.Record;
import com.wipro.holmes.uhg.enb.nvs.services.ParserServiceImpl;
import com.wipro.holmes.uhg.enb.nvs.services.parsers.Parser;
import com.wipro.holmes.uhg.enb.nvs.services.parsers.gsf.v1_5.GsfParser;

public class ParserServiceImplTests {

	private Map<String, Parser<Record>> parsers;
	private ParserServiceImpl service;
	private Path path;
	private int lines;

	@BeforeEach
	public void setUp() throws IOException {
		parsers = new HashMap<>();
		parsers.put(ParseStrategy.GSF_1_5.toString(), new GsfParser());
		service = new ParserServiceImpl(parsers);
		path = Path.of(new FileSystemResource("src/test/resources/documents/V1.50_Sample.txt").getPath())
				.toAbsolutePath();
		lines = Files.readAllLines(path).size();
	}

	@Test
	public void parserStrategyImplementedTest() throws ParseException, IOException {
		Collection<Record> records = service.parse(path, ParseStrategy.GSF_1_5);
		assertEquals(lines, records.size());
	}

	@Test
	public void parserStrategyNotImplementedTest() throws ParseException, IOException {
		assertThrows(ParseException.class, () -> service.parse(path, ParseStrategy.GSF_1_3));
		assertThrows(ParseException.class, () -> service.parse(path, ParseStrategy.GSF_1_3), "Parser Not Implemented");
	}

}
