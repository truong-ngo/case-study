package com.example.shop_md3.dao;

import com.example.shop_md3.model.Category;

import java.sql.SQLException;

public interface ICategoryDAO extends InterfaceDAO<Category, Long> {
    Category findByName(String name) throws SQLException;
}
