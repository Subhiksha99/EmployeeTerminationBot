package com.example.mongoservice.repository.personalDetailsDb;

import com.example.mongoservice.model.personalDetailsDb.PersonalDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonalDetailsRepository extends MongoRepository<PersonalDetails, Long> {
}
