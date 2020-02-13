package com.wipro.holmes.uhg.enb.nvs.services;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Path;
import java.text.ParseException;
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
	 * @throws IOException, ParseException
	 * 
	 */

	Collection<T> parse(Path path, ParseStrategy strategy) throws IOException, ParseException;

	/*
	 * Default implementation of reading from file.
	 * 
	 * @param Path to file
	 * 
	 * @return Reader to consume content from
	 * 
	 * @throws IOException
	 */

	default Reader read(Path path) throws IOException {
		File file = path.toFile();
		if (!file.exists())
			throw new IOException("Does not exist!");
		if (!file.isFile())
			throw new IOException("Not a file!");
		if (file.isHidden())
			throw new IOException("Is hidden!");
		if (!file.canRead())
			throw new IOException("No read permission!");
		return new FileReader(file);
	}

}
