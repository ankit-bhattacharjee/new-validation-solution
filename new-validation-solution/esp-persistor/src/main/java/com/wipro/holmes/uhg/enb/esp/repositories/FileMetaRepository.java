package com.wipro.holmes.uhg.enb.esp.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.wipro.holmes.uhg.enb.esp.models.FileMeta;

@RepositoryRestResource(collectionResourceRel = "files-meta", path = "files-meta")
public interface FileMetaRepository extends PagingAndSortingRepository<FileMeta, String> {

	FileMeta findBy_id(String id);

}
