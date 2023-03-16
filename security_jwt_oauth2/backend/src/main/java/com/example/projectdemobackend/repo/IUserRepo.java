package com.example.projectdemobackend.repo;

import com.example.projectdemobackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepo extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    @Query(value = "select username from users", nativeQuery = true)
    List<String> findAllUsername();
    @Query(value = "select email from users", nativeQuery = true)
    List<String> findAllEmail();

    Optional<User> findByEmail(String account);
}
