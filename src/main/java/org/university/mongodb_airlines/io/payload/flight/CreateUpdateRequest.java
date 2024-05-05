package org.university.mongodb_airlines.io.payload.flight;

import org.university.mongodb_airlines.entity.Airport;
import org.university.mongodb_airlines.entity.Plane;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateUpdateRequest(
        Plane plane,
        int numOfBorrowedEconomySeats,
        int numOfBorrowedBusinessSeats,
        Airport departurePoint,
        Airport destination,
        LocalDate departureDate,
        LocalTime departureTime,
        LocalDate arrivalDate,
        LocalTime arrivalTime
) {
}
