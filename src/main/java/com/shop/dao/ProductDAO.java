package com.shop.dao;

import java.sql.*;
import java.util.*;

import com.shop.model.Cart;
import com.shop.model.Product;
import com.shop.util.DBConnection;

public class ProductDAO {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM products";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setDescription(rs.getString("description"));
                row.setPrice(rs.getDouble("price"));
                row.setImageUrl(rs.getString("image_url"));
                products.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    
    public List<Cart> getCartProducts(List<Cart> cartList) {
        List<Cart> products = new ArrayList<>();
        try {
            if (!cartList.isEmpty()) {
                for (Cart item : cartList) {
                    Connection con = DBConnection.getConnection();
                    String query = "SELECT * FROM products WHERE id=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setName(rs.getString("name"));
                        row.setCategory(rs.getString("category")); // Add this line
                        row.setPrice(rs.getDouble("price"));
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public double getTotalCartPrice(List<Cart> cartList) {
        double sum = 0;
        try {
            if (!cartList.isEmpty()) {
                for (Cart item : cartList) {
                    Connection con = DBConnection.getConnection();
                    String query = "SELECT price FROM products WHERE id=?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()) {
                        sum += rs.getDouble("price") * item.getQuantity();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
    
    public List<Product> getSearchProducts(String keyword) {
        List<Product> products = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            // Use % symbols for a partial match (e.g., 'lap' will find 'laptop')
            String query = "SELECT * FROM products WHERE name LIKE ? OR category LIKE ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "%" + keyword + "%");
            pst.setString(2, "%" + keyword + "%");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Product row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImageUrl(rs.getString("image_url"));
                products.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}