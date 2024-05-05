package org.university.mongodb_airlines.io.payload.client;

public record CreateUpdateRequest(
        String email,
        String password,
        String fullName
) {
}
