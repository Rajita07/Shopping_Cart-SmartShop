package com.shop.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.shop.util.DBConnection;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect data from the form
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        String priceStr = request.getParameter("price");
        String image = request.getParameter("image"); // This stores the Internet URL
        String desc = request.getParameter("description");

        try {
            // Basic validation to prevent NumberFormatException
            double price = 0.0;
            if (priceStr != null && !priceStr.isEmpty()) {
                price = Double.parseDouble(priceStr);
            }

            Connection con = DBConnection.getConnection();
            // Ensure the column name is image_url to match your updated schema
            String query = "INSERT INTO products (name, category, price, image_url, description) VALUES (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, category);
            pst.setDouble(3, price);
            pst.setString(4, image);
            pst.setString(5, desc);

            int result = pst.executeUpdate();
            if (result > 0) {
                // Redirecting with a message so index.jsp can show a success alert
                response.sendRedirect("index.jsp?msg=added");
            } else {
                response.sendRedirect("add-product.jsp?msg=failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            // If there's a SQL error, redirect back to the form
            response.sendRedirect("add-product.jsp?msg=error");
        }
    }
}