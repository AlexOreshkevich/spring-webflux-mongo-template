package com.example.reactive.mapper;

import com.example.reactive.domain.Organization;
import com.example.reactive.dto.OrganizationDto;

public final class OrganizationMapper {

  private OrganizationMapper() {}

  public static Organization toEntity(OrganizationDto organizationDto) {
    return new Organization(organizationDto);
  }

  public static OrganizationDto toDto(Organization entity) {
    return new OrganizationDto(entity);
  }
}
