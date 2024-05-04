package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Airport;

public interface AirportRepository extends MongoRepository<Airport, String> {
}
