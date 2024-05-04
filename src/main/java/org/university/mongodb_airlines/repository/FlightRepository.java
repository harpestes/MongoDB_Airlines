package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Flight;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
