package com.wipro.holmes.uhg.enb.esp.services;

public interface RecordService<T> {

	T findRecord(String recordId);

	T updateRecord(String recordId, T record);

	T findAllRecords(String fileId);

	T findAllRecords(String fileId, String page, String size);

}
