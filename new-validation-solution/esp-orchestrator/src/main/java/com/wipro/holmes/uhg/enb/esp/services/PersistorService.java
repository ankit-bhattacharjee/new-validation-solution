package com.wipro.holmes.uhg.enb.esp.services;

import java.util.List;

public interface PersistorService<T> {

	T find(String id);

	List<T> findAll(String fileId);

	List<T> findAll(String fileId, int page, int size);

	T update(String id, T record);

	void delete(String id, T record);
}
