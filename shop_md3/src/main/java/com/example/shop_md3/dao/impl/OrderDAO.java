package com.example.shop_md3.dao.impl;

import com.example.shop_md3.dao.DBConnection;
import com.example.shop_md3.dao.IOrderDAO;
import com.example.shop_md3.model.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private final String SELECT_ORDER_BY_ID = "select * from orders where id = ?;";
    private final String SELECT_ALL_ORDER = "select * from orders;";
    private final String INSERT_ORDER = "insert into orders (user_id, date) values (?,?);";
//    private final String UPDATE_ORDER = "update orders set user_id = ? where id = ?);";
    private final String DELETE_ORDER = "delete from orders where id = ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static OrderDAO instance;

    private OrderDAO() {

    }

    public static OrderDAO getInstance() {
        if (instance == null) {
            instance = new OrderDAO();
        }
        return instance;
    }

    @Override
    public Order findById(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ORDER_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<Order> findAll() throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_ORDER)) {
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
    public void insert(Order order) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_ORDER)) {
            setStatement(order, statement);
            LocalDateTime localDateTime = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
            statement.setTimestamp(2, timestamp);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Long id, Order order) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_ORDER)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Order> getList(ResultSet result) throws SQLException {
        List<Order> orders = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            Long user_id = result.getLong("user_id");
            Timestamp timestamp = result.getTimestamp("date");
            LocalDateTime localDateTime = timestamp.toLocalDateTime();
            orders.add(new Order(id, UserDAO.getInstance().findById(user_id), localDateTime));
        }
        return orders;
    }

    @Override
    public void setStatement(Order order, PreparedStatement statement) throws SQLException {
        statement.setLong(1, order.getUser().getId());
    }
}
