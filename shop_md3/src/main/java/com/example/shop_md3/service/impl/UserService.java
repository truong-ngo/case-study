package com.example.shop_md3.service.impl;

import com.example.shop_md3.dao.impl.UserDAO;
import com.example.shop_md3.model.User;
import com.example.shop_md3.service.IUserService;
import com.example.shop_md3.service.Validate;
import com.example.shop_md3.service.Verify;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    private static UserService instance;
    private final Validate validate = Validate.getInstance();

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    @Override
    public boolean create(HttpServletRequest request) throws ServletException, IOException, SQLException {
        User user = getObject(request);
        if (Verify.getInstance().verifySignup(user)) {
            UserDAO.getInstance().insert(user);
            return true;
        }
        return false;
    }

    @Override
    public void render(HttpServletRequest request, List<User> lists)  {

    }

    @Override
    public void update(HttpServletRequest request) throws SQLException {
        User user = getObject(request);
        Long id = Long.parseLong(request.getParameter("id"));
        UserDAO.getInstance().update(id, user);
    }

    @Override
    public void delete(HttpServletRequest request) {

    }

    @Override
    public User getObject(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phone-number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        return new User(username, password, phoneNumber, email, address);
    }

    @Override
    public User loginCheck(HttpServletRequest request) throws SQLException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        List<User> users = UserDAO.getInstance().findAll();
        for (User user : users) {
            if ((user.getUsername().equals(account) || user.getEmail().equals(account))
                && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
