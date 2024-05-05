package org.university.mongodb_airlines.io.payload.plane;

import org.university.mongodb_airlines.entity.Airline;

public record CreateUpdateRequest(
        Airline airline,
        int numOfEconomySeats,
        int numOfBusinessSeats
) {
}
