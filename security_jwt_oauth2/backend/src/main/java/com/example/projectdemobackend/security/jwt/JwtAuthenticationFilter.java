package com.example.projectdemobackend.security.jwt;

import com.example.projectdemobackend.model.Role;
import com.example.projectdemobackend.model.User;
import com.example.projectdemobackend.service.IRoleService;
import com.example.projectdemobackend.service.IUserService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    private final String BEARER_PREFIX = "Bearer ";
    private final String GOOGLE_PREFIX = "Google ";
    private final String CLIENT_ID = "620692137780-v6p6mghd2ea2t5hh8i5sqr1roe226361.apps.googleusercontent.com";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwtFromRequest = getJwtFromRequest(request);
            if (jwtFromRequest != null) {
                if (jwtFromRequest.startsWith(BEARER_PREFIX)) {
                    String jwt = jwtFromRequest.replace("Bearer ", "");
                    String username = jwtService.getUserNameFromJwtToken(jwt);
                    UserDetails userDetails = userService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
                if (jwtFromRequest.startsWith(GOOGLE_PREFIX)) {
                    String jwt = jwtFromRequest.replace("Google ", "");
                    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance())
                            .setAudience(Collections.singletonList(CLIENT_ID))
                            .build();
                    GoogleIdToken idToken = verifier.verify(jwt);
                    if (idToken != null) {
                        GoogleIdToken.Payload payload = idToken.getPayload();
                        String email = payload.getEmail();
                        if (!userService.existsByEmail(email)) {
                            User newUser = new User();
                            String username = "user" + LocalDateTime.now();
                            String password = "123456";
                            Role role = roleService.findByName("ROLE_USER");
                            newUser.setRoles(new HashSet<>());
                            newUser.getRoles().add(role);
                            newUser.setEmail(email);
                            newUser.setUsername(username);
                            newUser.setPassword(password);
                            userService.save(newUser);
                        }
                        UserDetails userDetails = userService.loadUserByUsername(email);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }

            }
        } catch (Exception e) {
            logger.error("Can NOT set user authentication -> Message: {}", e);
        }
        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        return request.getHeader("Authorization");
    }
}
