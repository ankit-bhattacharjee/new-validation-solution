package com.wipro.holmes.uhg.enb.esp.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import com.wipro.holmes.uhg.enb.esp.models.Record;

@Repository
public interface PersistorRepository extends PagingAndSortingRepository<Record, String> {

	@Query("{ 'fileId' :  ?0}")
	@RestResource(path = "fileId", rel = "fileId")
	List<Record> findByfileId(@Param("fileId") long fileId);

}
