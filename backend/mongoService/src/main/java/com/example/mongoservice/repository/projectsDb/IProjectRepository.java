package com.example.mongoservice.repository.projectsDb;

import com.example.mongoservice.model.projectsDb.Projects;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends MongoRepository<Projects,Long>{
}

