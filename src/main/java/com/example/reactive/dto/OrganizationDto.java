package com.example.reactive.dto;

import com.example.reactive.domain.Organization;
import java.io.Serializable;

public record OrganizationDto(
    String orgId, String orgName, String orgEmail, boolean isActive, Long contact)
    implements Serializable {

  public OrganizationDto(Organization entity) {
    this(entity.orgId(), entity.orgName(), entity.orgEmail(), entity.isActive(), entity.contact());
  }
}
