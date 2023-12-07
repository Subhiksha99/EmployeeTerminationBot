package com.example.mongoservice.repository.flagsDb;

import com.example.mongoservice.model.flagsDb.Flags;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlagsRepository extends MongoRepository<Flags,Long> {
}
