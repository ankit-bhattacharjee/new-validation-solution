package com.wipro.holmes.uhg.enb.esp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wipro.holmes.uhg.enb.esp.models.Record;

@RepositoryRestResource(collectionResourceRel = "records", path = "records")
public interface RecordRepository extends PagingAndSortingRepository<Record, String> {

	Integer countByFileId(String fileId);

	Page<Record> findByFileId(String fileId, Pageable p);

}
