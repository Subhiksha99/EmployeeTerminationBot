package com.example.mongoservice.repository.personalDetailsDb;

import com.example.mongoservice.model.personalDetailsDb.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAddressRepository extends MongoRepository<Address, Long> {
}
