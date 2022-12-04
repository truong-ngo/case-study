package com.example.shop_md3.dao;

import com.example.shop_md3.model.Cart;
import com.example.shop_md3.model.User;

import java.sql.SQLException;

public interface ICartDAO extends InterfaceDAO<Cart, Long> {
    Cart findByUser(User user) throws SQLException;
}
