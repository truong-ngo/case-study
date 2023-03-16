package com.example.projectdemobackend.repo;


import com.example.projectdemobackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
