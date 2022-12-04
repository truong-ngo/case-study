package com.example.shop_md3.dao;

import com.example.shop_md3.model.Cart;
import com.example.shop_md3.model.CartDetails;

import java.sql.SQLException;
import java.util.List;

public interface ICartDetailsDAO extends InterfaceDAO<CartDetails, Cart> {
    List<CartDetails> findByItemId(Cart cart) throws SQLException;
    boolean deleteByProduct(CartDetails cartDetails) throws SQLException;
}
