package com.example.projectdemobackend.service;

import com.example.projectdemobackend.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends IService<User, Long>, UserDetailsService {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String username);
    List<String> findAllUsername();
    List<String> findAllEmail();
    boolean existsByEmail(String email);
}
