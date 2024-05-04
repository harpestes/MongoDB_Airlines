package org.university.mongodb_airlines.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.university.mongodb_airlines.entity.Ticket;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
