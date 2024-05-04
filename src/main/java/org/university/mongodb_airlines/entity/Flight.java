package org.university.mongodb_airlines.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Flights")
public class Flight {

    @Id
    @GeneratedValue
    private String id;
    @DocumentReference(collection = "Planes")
    private Plane plane;
    private int numOfBorrowedEconomySeats;
    private int numOfBorrowedBusinessSeats;
    @DocumentReference(collection = "Airports")
    private Airport departurePoint;
    @DocumentReference(collection = "Airports")
    private Airport destination;
    private Date departureDate;
    private Time departureTime;
    private Date arrivalDate;
    private Time arrivalTime;
}
