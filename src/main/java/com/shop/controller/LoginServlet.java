package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

import com.shop.dao.UserDAO;
import com.shop.model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO udao = new UserDAO();
        User user = udao.loginUser(email, password);

        if (user != null) {
            // Success! Store user in Session
            HttpSession session = request.getSession();
            session.setAttribute("auth", user);

            // Role-Based Redirection
            if (user.getRole().equals("ADMIN")) {
                response.sendRedirect("admin_dashboard.jsp");
            } else {
                response.sendRedirect("index.jsp"); // Customer home
            }
        } else {
            // Failed login
            response.sendRedirect("login.jsp?error=invalid");
        }
    }
}