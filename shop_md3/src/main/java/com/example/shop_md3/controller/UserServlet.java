package com.example.shop_md3.controller;

import com.example.shop_md3.model.User;
import com.example.shop_md3.service.impl.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toLoginPage(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "signup":
                    signup(request, response);
                    break;
                case "login":
                    login(request, response);
                    break;
                case "update":
                    // update
                    break;
                default:
                    toLoginPage(response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void toLoginPage(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://localhost:8080/shop/login-register.jsp");
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        if (UserService.getInstance().create(request)) {
            toLoginPage(response);
            return;
        }
        response.sendRedirect("/user?signup=error");
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        User user = UserService.getInstance().loginCheck(request);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            response.sendRedirect("/product");
        } else {
            response.sendRedirect("/user?login=error");
        }
    }
}
