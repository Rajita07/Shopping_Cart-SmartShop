package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.shop.model.Cart;

@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        List<Cart> cartList = new ArrayList<>();
        
        HttpSession session = request.getSession();
        List<Cart> cart_list = (List<Cart>) session.getAttribute("cart-list");

        // If cart doesn't exist, create a new one
        if (cart_list == null) {
            Cart cm = new Cart();
            cm.setId(id);
            cm.setQuantity(1);
            cartList.add(cm);
            session.setAttribute("cart-list", cartList);
            response.sendRedirect("index.jsp");
        } else {
            cartList = cart_list;
            boolean exist = false;
            for (Cart c : cart_list) {
                if (c.getId() == id) {
                    exist = true;
                    // Product already in cart? Just go back or show alert
                    response.sendRedirect("index.jsp?msg=already_in_cart");
                }
            }

            if (!exist) {
                Cart cm = new Cart();
                cm.setId(id);
                cm.setQuantity(1);
                cartList.add(cm);
                response.sendRedirect("index.jsp");
            }
        }
    }
}