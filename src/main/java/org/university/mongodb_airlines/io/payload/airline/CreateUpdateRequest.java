package org.university.mongodb_airlines.io.payload.airline;

public record CreateUpdateRequest(
        String name,
        String description,
        String email,
        String hotlinePhoneNumber
) {
}
