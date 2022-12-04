package com.example.shop_md3.dao;

import com.example.shop_md3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO extends InterfaceDAO<Product, Long> {
    Product findByName(String name) throws SQLException;
    List<Product> sort(String condition) throws SQLException;
}
