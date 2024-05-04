package org.university.mongodb_airlines.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "Airports")
public class Airport {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String city;
    private String timeZone;
}
