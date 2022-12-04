package com.example.shop_md3.dao;

import com.example.shop_md3.model.CartDetails;
import com.example.shop_md3.model.Order;
import com.example.shop_md3.model.OrderDetails;

import java.sql.SQLException;
import java.util.List;

public interface IOrderDetailsDAO extends InterfaceDAO<OrderDetails, Order> {
    void insertFromCartDetails(List<CartDetails> cartDetailsList, Order order) throws SQLException;
    void cancelOrder(Order order) throws SQLException;
}
