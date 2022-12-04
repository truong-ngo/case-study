package com.example.shop_md3.model;

import java.time.LocalDateTime;

public class Feedback {
    private User user;
    private Product product;
    private Integer rate;
    private String comment;
    private LocalDateTime dateTime;

    public Feedback() {
    }

    public Feedback(User user, Product product, Integer rate, String comment, LocalDateTime dateTime) {
        this.user = user;
        this.product = product;
        this.rate = rate;
        this.comment = comment;
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
