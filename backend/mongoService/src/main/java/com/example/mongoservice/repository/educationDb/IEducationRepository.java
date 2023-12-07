package com.example.mongoservice.repository.educationDb;

import com.example.mongoservice.model.educationDb.Education;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends MongoRepository<Education, Long> {
}
