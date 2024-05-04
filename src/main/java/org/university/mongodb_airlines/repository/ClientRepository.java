package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
}
