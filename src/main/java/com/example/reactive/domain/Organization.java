package com.example.reactive.domain;

import com.example.reactive.dto.OrganizationDto;
import jakarta.validation.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record Organization(
    @Id String orgId,
    String orgName,
    @Indexed(unique = true, background = true) @Email String orgEmail,
    Long contact,
    boolean isActive) {

  @PersistenceCreator
  public Organization {}

  public Organization(String orgName, String orgEmail, Long contact, boolean isActive) {
    this(null, orgName, orgEmail, contact, isActive);
  }

  public Organization(OrganizationDto source) {
    this(source.orgId(), source.orgName(), source.orgEmail(), source.contact(), source.isActive());
  }
}
