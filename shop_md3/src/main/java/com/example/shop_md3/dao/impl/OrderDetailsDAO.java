package com.example.shop_md3.dao.impl;

import com.example.shop_md3.dao.DBConnection;
import com.example.shop_md3.dao.IOrderDetailsDAO;
import com.example.shop_md3.model.Cart;
import com.example.shop_md3.model.CartDetails;
import com.example.shop_md3.model.Order;
import com.example.shop_md3.model.OrderDetails;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsDAO implements IOrderDetailsDAO {
    private final String INSERT_ORDER_DETAILS = "insert into order_detail (order_id, product_id, quantity) values (?,?,?);";
    private final String CANCEL_ORDER = "delete from order_detail where order_id = ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static OrderDetailsDAO instance;

    private OrderDetailsDAO() {

    }

    public static OrderDetailsDAO getInstance() {
        if (instance == null) {
            instance = new OrderDetailsDAO();
        }
        return instance;
    }

    @Override
    public void insertFromCartDetails(List<CartDetails> cartDetailsList, Order order) throws SQLException {
        Cart cart = null;
        for (CartDetails c : cartDetailsList) {
            PreparedStatement statement = dbConn.getConnection().prepareStatement(INSERT_ORDER_DETAILS);
            statement.setLong(1, order.getId());
            statement.setLong(2, c.getProduct().getId());
            statement.setInt(3, c.getQuantity());
            statement.executeUpdate();
            statement.close();
            cart = c.getCart();
        }
        CartDetailsDAO cartDetailsDAO = CartDetailsDAO.getInstance();
        assert cart != null;
        cartDetailsDAO.delete(cart);
    }

    @Override
    public void cancelOrder(Order order) throws SQLException {
        try (PreparedStatement statement = dbConn.getConnection().prepareStatement(CANCEL_ORDER)) {
            statement.setLong(1, order.getId());
            statement.executeUpdate();
        }
    }

    @Override
    public OrderDetails findById(Order id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderDetails> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void insert(OrderDetails orderDetails) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean update(Order id, OrderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Order id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<OrderDetails> getList(ResultSet result) throws SQLException {
        return null;
    }

    @Override
    public void setStatement(OrderDetails orderDetails, PreparedStatement statement) throws SQLException {

    }
}
