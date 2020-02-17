package com.wipro.holmes.uhg.enb.nvs.services;

import java.nio.file.Path;
import java.util.Collection;
import com.wipro.holmes.uhg.enb.nvs.models.ParseStrategy;

public interface ParserService<T> {

	/*
	 * Reads document by Path, and return Collection of Record(s) based on Strategy.
	 * In pipe, to add OutputStream for large files.
	 * 
	 * @param Path to file to be parsed, ParseStrategy to be used
	 * 
	 * @return Collection<T> objects parsed from the file, by lines
	 * 
	 * @throws Exception depending on the implementation
	 * 
	 */

	Collection<T> parse(Path path, ParseStrategy strategy) throws Exception;

}
