package com.example.shop_md3.service;

import com.example.shop_md3.dao.impl.UserDAO;
import com.example.shop_md3.model.User;

import java.sql.SQLException;
import java.util.List;

public class Verify {
    private static Verify instance;

    private Verify() {

    }

    public static Verify getInstance() {
        if (instance == null) {
            instance = new Verify();
        }
        return instance;
    }

    public boolean verifySignup(User user) throws SQLException {
        List<User> users = UserDAO.getInstance().findAll();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) || u.getEmail().equals(user.getEmail())) {
                return false;
            }
        }
        return true;
    }
}
