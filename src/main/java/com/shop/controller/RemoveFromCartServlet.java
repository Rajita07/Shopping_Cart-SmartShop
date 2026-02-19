package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import com.shop.model.Cart;

@WebServlet("/RemoveFromCartServlet")
public class RemoveFromCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
            if (cart_list != null) {
                for (Cart c : cart_list) {
                    if (c.getId() == Integer.parseInt(id)) {
                        cart_list.remove(cart_list.indexOf(c));
                        break;
                    }
                }
            }
            response.sendRedirect("cart.jsp");
        } else {
            response.sendRedirect("cart.jsp");
        }
    }
}