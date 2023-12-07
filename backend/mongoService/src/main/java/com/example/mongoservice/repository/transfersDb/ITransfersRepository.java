package com.example.mongoservice.repository.transfersDb;

import com.example.mongoservice.model.transfersDb.Transfers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransfersRepository extends MongoRepository<Transfers,Long> {
}
