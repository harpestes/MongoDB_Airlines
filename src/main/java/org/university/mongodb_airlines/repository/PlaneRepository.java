package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Plane;

public interface PlaneRepository extends MongoRepository<Plane, String> {
}
