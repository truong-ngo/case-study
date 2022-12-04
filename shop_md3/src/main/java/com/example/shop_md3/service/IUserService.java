package com.example.shop_md3.service;

import com.example.shop_md3.model.User;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public interface IUserService extends IService<User> {
    User loginCheck(HttpServletRequest request) throws SQLException;
}
