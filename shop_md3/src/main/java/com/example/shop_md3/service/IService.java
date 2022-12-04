package com.example.shop_md3.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface IService<E> {
    boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException;
    void render(HttpServletRequest request, List<E> lists) throws SQLException;
    void update(HttpServletRequest request) throws SQLException;
    void delete(HttpServletRequest request);
    E getObject(HttpServletRequest request);
}
