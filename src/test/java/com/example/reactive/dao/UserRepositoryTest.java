package com.example.reactive.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.reactive.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
class UserRepositoryTest extends IntegrationTest {

  @Autowired UserRepository repository;

  @Test
  void shouldFindUserByEmail() {
    StepVerifier.create(repository.findByEmail("harry.potter@gmail.com"))
        .assertNext(
            user -> {
              assertEquals("harry.potter@gmail.com", user.email());
              assertEquals("The Slayer", user.nickname());
            })
        .expectComplete()
        .verify();
  }
}
