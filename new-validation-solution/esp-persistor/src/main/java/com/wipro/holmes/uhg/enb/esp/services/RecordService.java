package com.wipro.holmes.uhg.enb.esp.services;

import java.util.concurrent.CompletableFuture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecordService<T> {
	/*
	 * An event driven, domain independent approach to persistence, of a type T
	 * Record. Ideal scenario uses a collection based approach to a finite set of
	 * records. Collection should be batch inserted into underlying store, upon
	 * reaching the finite size defined.
	 * 
	 * @param T record
	 */

	CompletableFuture<Void> saveAndNotify(T record) throws InterruptedException;

	/*
	 * Finds all records by fileId, up to implementation to introduce blocking.
	 * 
	 * @param String, Pageable
	 */

	Page<T> waitAndFindAll(String fileId, Pageable page) throws InterruptedException;

	/*
	 * Flushes the collection backed records to underlying persistent store.
	 */
	void flush();

}
