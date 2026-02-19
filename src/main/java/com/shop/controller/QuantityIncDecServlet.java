package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.shop.model.Cart;

@WebServlet("/QuantityIncDecServlet")
public class QuantityIncDecServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");

        if (action != null && id >= 1) {
            if (action.equals("inc")) {
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        int quantity = c.getQuantity();
                        quantity++;
                        c.setQuantity(quantity);
                        response.sendRedirect("cart.jsp");
                    }
                }
            }

            if (action.equals("dec")) {
                for (Cart c : cart_list) {
                    if (c.getId() == id && c.getQuantity() > 1) {
                        int quantity = c.getQuantity();
                        quantity--;
                        c.setQuantity(quantity);
                        break;
                    }
                }
                response.sendRedirect("cart.jsp");
            }
        } else {
            response.sendRedirect("cart.jsp");
        }
    }
}