package com.example.reactive.service;

import com.example.reactive.dao.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class UserService {

  private final UserRepository repository;
}
