package com.wipro.holmes.uhg.enb.nvs.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface ParserService<T> {

	/*
	 * Responsible for the construction and publishing of the domain model T. Reads
	 * the resource by path and forwards to an appropriate parser, to get the domain
	 * representation. This T is then, published to some resource for consumption.
	 * 
	 * @param Path to file to be parsed
	 * 
	 * @return Collection<T> objects parsed from the file, by lines
	 * 
	 * @throws Exception depending on the implementation
	 * 
	 */

	void parseAndPublish(Path path) throws Exception;

	/*
	 * Default implementation of returning a safe file from this path.
	 * 
	 * @param Path to file
	 * 
	 * @return file to consume content from
	 * 
	 * @throws IOException
	 */

	default File read(Path path) throws IOException {
		File file = path.toFile();
		if (!file.exists())
			throw new IOException("Does not exist!");
		if (!file.isFile())
			throw new IOException("Not a file!");
		if (file.isHidden())
			throw new IOException("Is hidden!");
		if (!file.canRead())
			throw new IOException("No read permission!");
		return file;
	}

}
