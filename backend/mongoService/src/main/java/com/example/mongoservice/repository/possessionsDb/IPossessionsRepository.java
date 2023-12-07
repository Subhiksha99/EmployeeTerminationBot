package com.example.mongoservice.repository.possessionsDb;

import com.example.mongoservice.model.possessionsDb.Possessions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPossessionsRepository extends MongoRepository<Possessions,Long> {
}
