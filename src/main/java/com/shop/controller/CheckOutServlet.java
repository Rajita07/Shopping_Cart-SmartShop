package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.shop.model.*;
import com.shop.dao.OrderDAO;

@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            
            // 1. Check if User is Logged In
            User auth = (User) request.getSession().getAttribute("auth");
            List<Cart> cart_list = (List<Cart>) request.getSession().getAttribute("cart-list");

            if (auth != null && cart_list != null) {
                for (Cart c : cart_list) {
                    Order order = new Order();
                    order.setId(c.getId());
                    order.setUid(auth.getId());
                    order.setQuantity(c.getQuantity());
                    order.setDate(formatter.format(date));

                    OrderDAO oDao = new OrderDAO();
                    oDao.insertOrder(order);
                }
                // 2. Clear the Cart after checkout
                cart_list.clear();
                response.sendRedirect("orders.jsp");
            } else if (auth == null) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("cart.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}