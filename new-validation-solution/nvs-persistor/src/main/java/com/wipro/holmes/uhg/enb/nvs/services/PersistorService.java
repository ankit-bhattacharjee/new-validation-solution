package com.wipro.holmes.uhg.enb.nvs.services;

public interface PersistorService<T> {

	/*
	 * An event driven, domain independent approach to persistence, of a type T
	 * Record.
	 * 
	 * @param T record
	 */

	void persist(T record);

}
