package org.university.mongodb_airlines.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue
    private String id;
    @DocumentReference(collection = "Clients")
    private Client client;
    @DocumentReference(collection = "Flights")
    private Flight flight;
}
