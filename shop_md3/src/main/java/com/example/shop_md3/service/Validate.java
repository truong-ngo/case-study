package com.example.shop_md3.service;

import com.example.shop_md3.model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static Validate instance;
    private Pattern pattern;
    private Matcher matcher;
    private Validate() {

    }

    public static Validate getInstance() {
        if (instance == null) {
            instance = new Validate();
        }
        return instance;
    }

    public boolean validate(String data, String regex) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(data);
        return matcher.matches();
    }

    public boolean validateEmail(String email) {
        return validate(email, Regex.EMAIL);
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        return validate(phoneNumber, Regex.PHONE_NUMBER);
    }

    public boolean validatePassword(String password) {
        return validate(password, Regex.PASSWORD);
    }
}
