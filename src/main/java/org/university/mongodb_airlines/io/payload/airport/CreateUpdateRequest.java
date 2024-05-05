package org.university.mongodb_airlines.io.payload.airport;

public record CreateUpdateRequest(
        String name,
        String city,
        String timeZone
) {
}
