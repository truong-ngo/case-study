package com.example.shop_md3.dao;

import com.example.shop_md3.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<E, K> {
    E findById(K id) throws SQLException, ClassNotFoundException;
    List<E> findAll() throws SQLException, ClassNotFoundException;
    void insert(E e) throws SQLException, ClassNotFoundException;
    boolean update(K id, E e) throws SQLException, ClassNotFoundException;
    boolean delete(K id) throws SQLException, ClassNotFoundException;
    List<E> getList(ResultSet result) throws SQLException;
    void setStatement(E e, PreparedStatement statement) throws SQLException;
}
