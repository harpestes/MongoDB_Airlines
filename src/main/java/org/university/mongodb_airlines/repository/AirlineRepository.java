package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Airline;

public interface AirlineRepository extends MongoRepository<Airline, String> {

    boolean existsByName(String name);
}
