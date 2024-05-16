package com.example.reactive.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.reactive.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
class UserRepositoryIntegrationTest extends IntegrationTest {

  @Autowired UserRepository repository;

  @Test
  void shouldFindUserByEmail() {
    StepVerifier.create(repository.findByEmail("harry.potter@gmail.com"))
        .assertNext(
            user -> {
              assertEquals("Harry", user.getFirstName());
              assertEquals("Potter", user.getLastName());
              assertNotNull(user.getId());
            })
        .expectComplete()
        .verify();
  }
}
