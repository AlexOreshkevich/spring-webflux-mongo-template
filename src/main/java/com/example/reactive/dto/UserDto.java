package com.example.reactive.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// See
// https://docs.spring.io/spring-data/mongodb/reference/repositories/projections.html#projections.dtos
public record UserDto(@NotEmpty String nickname, @Email String email) {}
