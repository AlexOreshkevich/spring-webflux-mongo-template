package com.example.reactive.dao;

import com.example.reactive.domain.User;
import com.example.reactive.dto.UserDto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/** Demonstrates Class-based Projections (DTOs). */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, ObjectId> {

  // o.s.d.m.r.query.MongoQueryCreator        : Created query Query:
  //    { "email" : "harry.potter@gmail.com"}, Fields: {}, Sort: {}
  //
  // o.s.d.m.core.ReactiveMongoTemplate       : find using query:
  //    { "email" : "harry.potter@gmail.com"} fields: Document{{nickname=1, email=1}}
  //    for class: class com.example.reactive.domain.User in collection: users
  //
  // For relational databases, see
  // https://dzone.com/articles/how-to-best-use-java-records-as-dtos-in-spring-boo
  Mono<UserDto> findByEmail(String email);
}
