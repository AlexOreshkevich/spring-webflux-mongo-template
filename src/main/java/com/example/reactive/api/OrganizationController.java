package com.example.reactive.api;

import com.example.reactive.dto.OrganizationDto;
import com.example.reactive.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Representational layer. Responsible for validating requests (DTO's) and translating exceptions.
 */
@RestController
@RequestMapping(value = "/api/v1/org")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Slf4j
// TODO check response codes
// TODO Add Open API documentation
// TODO add exception handling
public class OrganizationController {

  private final OrganizationService service;

  @PostMapping("/")
  public ResponseEntity<Mono<OrganizationDto>> create(
      @RequestBody @Valid OrganizationDto organizationDto) {
    return new ResponseEntity<>(service.create(organizationDto), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Mono<OrganizationDto>> read(@PathVariable("id") String id) {
    return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
  }

  // TODO add pagination
  @GetMapping("/")
  public ResponseEntity<Flux<OrganizationDto>> readAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @PutMapping("/{id}")
  public ResponseEntity<Mono<OrganizationDto>> update(
      @PathVariable("id") String id, @RequestBody @Valid OrganizationDto organizationDto) {
    return ResponseEntity.ok(service.update(id, organizationDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Mono<Void>> delete(@PathVariable("id") String id) {
    return ResponseEntity.accepted().body(service.delete(id));
  }

  // TODO Add PATCH support (partial update)
}
