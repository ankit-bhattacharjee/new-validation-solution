package com.wipro.holmes.uhg.enb.nvs.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;

public interface Parser<T> {

	/*
	 * Parses a supported file into meaningful Record implementations. Up to the
	 * implementation to check if text is valid and parse-able.
	 * 
	 * @param Path to file
	 * 
	 * @return Collection of T Records parsed from the path
	 * 
	 * @throws Exception depending on implementation
	 * 
	 */
	Collection<T> parse(Path file) throws Exception;
	/*
	 * Default implementation of returning an InputStream.
	 * 
	 * @param Path to file
	 * 
	 * @return InputStream to consume content from
	 * 
	 * @throws IOException
	 */

	default FileInputStream read(Path path) throws IOException {
		File file = path.toFile();
		if (!file.exists())
			throw new IOException("Does not exist!");
		if (!file.isFile())
			throw new IOException("Not a file!");
		if (file.isHidden())
			throw new IOException("Is hidden!");
		if (!file.canRead())
			throw new IOException("No read permission!");
		return new FileInputStream(file);
	}

}
