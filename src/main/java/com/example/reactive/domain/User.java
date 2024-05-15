package com.example.reactive.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(collection = "users")
@AllArgsConstructor
@Data
@Builder
public class User implements Serializable {

    @Id
    private final ObjectId id;
    
    private final String firstName;

    private final String lastName;

    private final String nickname;

    @Indexed(unique = true, background = true)
    private final String email;

    private final int age;
}