package com.example.shop_md3.dao;

import com.example.shop_md3.model.Feedback;
import com.example.shop_md3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IFeedbackDAO extends InterfaceDAO<Feedback, Product> {
    List<Feedback> findByProduct(Product product) throws SQLException;
}
