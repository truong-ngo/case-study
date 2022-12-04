package com.example.shop_md3.model;

public class Cart {
    private Long id;
    private User user;

    public Cart(Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Cart(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
