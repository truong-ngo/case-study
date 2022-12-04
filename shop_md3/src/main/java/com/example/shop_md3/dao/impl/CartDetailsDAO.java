package com.example.shop_md3.dao.impl;

import com.example.shop_md3.dao.DBConnection;
import com.example.shop_md3.dao.ICartDetailsDAO;
import com.example.shop_md3.model.Cart;
import com.example.shop_md3.model.CartDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CartDetailsDAO implements ICartDetailsDAO {
    private final String SELECT_LIST_CART_DETAILS_BY_CART_ID = "select * from cart_detail where cart_id = ?;";
    private final String INSERT_CART_DETAILS = "insert into cart_detail (cart_id, product_id, quantity) values (?,?,?);";
    private final String UPDATE_CART_DETAILS = "update cart_detail set quantity = ? where cart_id = ? and product_id = ?);";
    private final String DELETE_CART_DETAILS = "delete from cart_detail where cart_id = ?;";
    private final String DELETE_CART_DETAILS_BY_CART_AND_PRODUCT = "delete from cart_detail where cart_id = ? and product_id = ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static CartDetailsDAO instance;

    private CartDetailsDAO() {

    }

    public static CartDetailsDAO getInstance() {
        if (instance == null) {
            instance = new CartDetailsDAO();
        }
        return instance;
    }

    @Override
    public CartDetails findById(Cart id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<CartDetails> findAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public List<CartDetails> findByItemId(Cart cart) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_LIST_CART_DETAILS_BY_CART_ID)) {
            statement.setLong(1, cart.getId());
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
    public void insert(CartDetails cartDetails) throws SQLException {
        try (Connection connection = dbConn.getConnection()) {
            List<CartDetails> cartDetailsList = findByItemId(cartDetails.getCart());
            for (CartDetails c : cartDetailsList) {
                if (c.getCart().getId() == cartDetails.getCart().getId() &&
                    c.getProduct().getId() == cartDetails.getProduct().getId()) {
                    int quantity = c.getQuantity() + cartDetails.getQuantity();
                    PreparedStatement statement = connection.prepareStatement(UPDATE_CART_DETAILS);
                    statement.setInt(1, quantity);
                    statement.setLong(2, c.getCart().getId());
                    statement.setLong(3, c.getProduct().getId());
                    statement.executeUpdate();
                    statement.close();
                    break;
                }
            }
            PreparedStatement statement = connection.prepareStatement(INSERT_CART_DETAILS);
            setStatement(cartDetails, statement);
            statement.executeUpdate();
            statement.close();
        }
    }

    @Override
    public boolean update(Cart id, CartDetails cartDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(Cart cart) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CART_DETAILS)) {
            statement.setLong(1, cart.getId());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean deleteByProduct(CartDetails cartDetails) throws SQLException {
        try (Connection connection = dbConn.getConnection()) {
            int quantity;
            int result = 0;
            List<CartDetails> cartDetailsList = findByItemId(cartDetails.getCart());
            for (CartDetails c : cartDetailsList) {
                if (c.getCart().getId() == cartDetails.getCart().getId() &&
                    c.getProduct().getId() == cartDetails.getProduct().getId()) {
                    if (c.getQuantity() > cartDetails.getQuantity()) {
                        quantity = c.getQuantity() - cartDetails.getQuantity();
                        PreparedStatement statement = connection.prepareStatement(UPDATE_CART_DETAILS);
                        statement.setInt(1, quantity);
                        statement.setLong(2, c.getCart().getId());
                        statement.setLong(3, c.getProduct().getId());
                        result = statement.executeUpdate();
                        statement.close();
                    } else {
                        PreparedStatement statement = connection.prepareStatement(DELETE_CART_DETAILS_BY_CART_AND_PRODUCT);
                        statement.setLong(1, c.getCart().getId());
                        statement.setLong(2, c.getProduct().getId());
                        result = statement.executeUpdate();
                        statement.close();
                    }
                }
            }
            return result > 0;
        }
    }

    @Override
    public List<CartDetails> getList(ResultSet result) throws SQLException {
        return null;
    }

    @Override
    public void setStatement(CartDetails cartDetails, PreparedStatement statement) throws SQLException {
        statement.setLong(1, cartDetails.getCart().getId());
        statement.setLong(2, cartDetails.getProduct().getId());
        statement.setInt(3, cartDetails.getQuantity());
    }
}
