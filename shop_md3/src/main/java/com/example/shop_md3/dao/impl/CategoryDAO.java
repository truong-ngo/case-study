package com.example.shop_md3.dao.impl;

import com.example.shop_md3.dao.DBConnection;
import com.example.shop_md3.dao.ICategoryDAO;
import com.example.shop_md3.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    private final String SELECT_CATEGORY_BY_ID = "select * from category where id = ?;";
    private final String SELECT_CATEGORY_BY_NAME = "select * from category where name = ?;";
    private final String SELECT_ALL_CATEGORY = "select * from category;";
    private final String INSERT_CATEGORY = "insert into category (name) values (?);";
    private final String UPDATE_CATEGORY = "update category set name = ? where id = ?);";
    private final String DELETE_CATEGORY = "delete from category where id = ?;";
    DBConnection dbConn = DBConnection.getInstance();
    private static CategoryDAO instance;

    private CategoryDAO() {
    }

    public static CategoryDAO getInstance() {
        if (instance == null) {
            instance = new CategoryDAO();
        }
        return instance;
    }

    @Override
    public Category findById(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_ID)) {
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public List<Category> findAll() throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet result = statement.executeQuery();
            return getList(result);
        }
    }

    @Override
    public void insert(Category category) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_CATEGORY)) {
            setStatement(category, statement);
            statement.executeUpdate();
        }
    }

    @Override
    public boolean update(Long id, Category category) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY)) {
            setStatement(category, statement);
            statement.setLong(2, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Long id) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public List<Category> getList(ResultSet result) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (result.next()) {
            Long id = result.getLong("id");
            String name = result.getString("name");
            categories.add(new Category(id, name));
        }
        return categories;
    }

    @Override
    public Category findByName(String name) throws SQLException {
        try (Connection connection = dbConn.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_CATEGORY_BY_NAME)) {
            statement.setString(1, name);
            ResultSet result = statement.executeQuery();
            return getList(result).get(0);
        }
    }

    @Override
    public void setStatement(Category category, PreparedStatement statement) throws SQLException {
        statement.setString(1, category.getName());
    }
}
