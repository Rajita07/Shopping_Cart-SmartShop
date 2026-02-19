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

@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            try {
                Connection con = DBConnection.getConnection();
                String query = "DELETE FROM products WHERE id=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setInt(1, Integer.parseInt(id));
                pst.executeUpdate();
                response.sendRedirect("index.jsp?msg=deleted");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}