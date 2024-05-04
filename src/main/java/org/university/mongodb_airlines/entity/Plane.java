package org.university.mongodb_airlines.entity;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Planes")
public class Plane {

    @Id
    @GeneratedValue
    private String id;
    @DocumentReference(collection = "Airlines")
    private Airline airline;
    private int numOfEconomySeats;
    private int numOfBusinessSeats;
}
