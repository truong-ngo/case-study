package com.example.projectdemobackend.service;

import com.example.projectdemobackend.model.User;
import com.example.projectdemobackend.repo.IUserRepo;
import com.example.projectdemobackend.security.jwt.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private IUserRepo userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(IUserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(account);
        Optional<User> userOptional1 = userRepository.findByEmail(account);
        if (!userOptional.isPresent() && !userOptional1.isPresent()) {
            throw new UsernameNotFoundException(account);
        }
        return userOptional.map(UserPrinciple::build).orElseGet(() -> UserPrinciple.build(userOptional1.get()));
    }

    @Override
    public Optional<User> findByUsername(String account) {
        return userRepository.findByUsername(account);
    }

    @Override
    public Optional<User> findByEmail(String account) {
        return userRepository.findByEmail(account);
    }

    @Override
    public List<String> findAllUsername() {
        return userRepository.findAllUsername();
    }

    @Override
    public List<String> findAllEmail() {
        return userRepository.findAllEmail();
    }

    @Override
    public boolean existsByEmail(String email) {
        Optional<User> user = findByEmail(email);
        return user.isPresent();
    }
}
