package com.wipro.holmes.uhg.enb.nvs.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.wipro.holmes.uhg.enb.nvs.models.Record;

public interface EnrollmentRepository extends MongoRepository<Record, Long> {

}
