package com.example.mongoservice.repository.leavesDb;

import com.example.mongoservice.model.leavesDb.Leaves;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILeavesRepository extends MongoRepository<Leaves, Integer> {

}
