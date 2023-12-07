package com.example.mongoservice.repository.learningsDb;


import com.example.mongoservice.model.learningsDb.Learnings;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILearningRepository extends MongoRepository<Learnings,Long> {

}
