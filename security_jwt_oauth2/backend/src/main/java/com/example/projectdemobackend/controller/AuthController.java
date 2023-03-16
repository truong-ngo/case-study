package com.example.projectdemobackend.controller;

import com.example.projectdemobackend.dto.SocialUser;
import com.example.projectdemobackend.model.Role;
import com.example.projectdemobackend.model.User;
import com.example.projectdemobackend.security.jwt.JwtResponse;
import com.example.projectdemobackend.security.jwt.JwtService;
import com.example.projectdemobackend.service.IRoleService;
import com.example.projectdemobackend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/auth")
public class AuthController {
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private IUserService userService;
    private IRoleService roleService;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public void setJwtService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User currentUser = userService.findByUsername(user.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }

    @PostMapping("/google-login")
    public ResponseEntity<?> googleLogin(@RequestBody SocialUser socialUser) {
        User user = userService.findByEmail(socialUser.getEmail()).get();
        UserDetails userDetails = userService.loadUserByUsername(user.getEmail());
        socialUser.setRoles(userDetails.getAuthorities());
        return new ResponseEntity<>(socialUser, HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        Optional<User> checkUser = userService.findByUsername(user.getUsername());
        if (!checkUser.isPresent()) {
            Role role = roleService.findByName("ROLE_USER");
            user.setRoles(new HashSet<>());
            user.getRoles().add(role);
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @GetMapping("/username")
    public ResponseEntity<List<String>> getUsernames() {
        return new ResponseEntity<>(userService.findAllUsername(), HttpStatus.OK);
    }

    @GetMapping("/email")
    public ResponseEntity<List<String>> getEmails() {
        return new ResponseEntity<>(userService.findAllEmail(), HttpStatus.OK);
    }
}
