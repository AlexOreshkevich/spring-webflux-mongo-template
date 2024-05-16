package com.example.reactive.service;

import com.example.reactive.dao.OrganizationRepository;
import com.example.reactive.dto.OrganizationDto;
import com.example.reactive.mapper.OrganizationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OrganizationService {

  private final OrganizationRepository repository;

  public Mono<OrganizationDto> create(OrganizationDto organizationDto) {
    return repository
        .insert(OrganizationMapper.toEntity(organizationDto))
        .map(OrganizationMapper::toDto);
  }

  public Mono<OrganizationDto> findById(String id) {
    return repository.findById(id).map(OrganizationMapper::toDto);
  }

  public Flux<OrganizationDto> findAll() {
    return repository.findAll().map(OrganizationMapper::toDto);
  }

  public Mono<OrganizationDto> update(String id, OrganizationDto organizationDto) {
    return repository
        .findById(id)
        .switchIfEmpty(Mono.error(NotFoundException::new))
        .then(repository.save(OrganizationMapper.toEntity(organizationDto)))
        .map(OrganizationMapper::toDto);
  }

  public Mono<Void> delete(String id) {
    return repository.deleteById(id);
  }
}
