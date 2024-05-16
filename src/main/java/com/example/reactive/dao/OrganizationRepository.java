package com.example.reactive.dao;

import com.example.reactive.domain.Organization;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface OrganizationRepository extends ReactiveMongoRepository<Organization, String> {

  Mono<Organization> findByOrgName(String name);
}
