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
@Document(collection = "Clients")
public class Client {

    @Id
    @GeneratedValue
    private String id;
    private String email;
    private String password;
    private String fullName;
}
