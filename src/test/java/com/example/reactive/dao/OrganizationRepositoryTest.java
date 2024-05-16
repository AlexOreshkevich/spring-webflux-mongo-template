package com.example.reactive.dao;

import com.example.reactive.IntegrationTest;
import com.example.reactive.domain.Organization;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
class OrganizationRepositoryTest extends IntegrationTest {

  @Autowired OrganizationRepository repository;

  @Test
  void shouldImplementCrudOperations() {

    Organization org1 = new Organization("orgName", "orgEmail@gmail.com", 1L, false);

    var setup =
        repository
            .deleteAll()
            // create
            .then(repository.insert(org1))
            // read
            .then(
                repository
                    .findByOrgName(org1.orgName())
                    .map(
                        o ->
                            new Organization(
                                o.orgId(), "orgName2", o.orgEmail(), o.contact(), o.isActive()))
                    // update
                    .doOnNext(repository::save))
            // delete
            .then(repository.findByOrgName("orgName2").map(o -> repository.deleteById(o.orgId())));

    StepVerifier.create(setup).expectComplete().verify();
  }
}
