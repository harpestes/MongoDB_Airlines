package org.university.mongodb_airlines.io.payload.ticket;

import org.university.mongodb_airlines.entity.Client;
import org.university.mongodb_airlines.entity.Flight;

public record CreateUpdateRequest(
        Client client,
        Flight flight
) {
}
