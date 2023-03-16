package com.example.projectdemobackend.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SocialUser {
    private String email;
    private String idToken;
    private String tokenType;
    private Collection<? extends GrantedAuthority> roles;

    public SocialUser() {
    }

    public SocialUser(String email, String idToken) {
        this.email = email;
        this.idToken = idToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
