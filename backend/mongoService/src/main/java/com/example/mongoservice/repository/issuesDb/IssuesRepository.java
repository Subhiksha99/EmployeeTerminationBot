package com.example.mongoservice.repository.issuesDb;

import com.example.mongoservice.model.issuesDb.Issues;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuesRepository extends MongoRepository<Issues, Long> {
}
