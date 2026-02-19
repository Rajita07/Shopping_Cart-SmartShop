package com.shop.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.shop.model.Order;
import com.shop.util.DBConnection;

public class OrderDAO {
    public boolean insertOrder(Order model) {
        boolean result = false;
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO orders (product_id, user_id, quantity, order_date) VALUES (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQuantity());
            pst.setString(4, model.getDate());
            
            pst.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            // We join with products to get details like name and price for the history
            String query = "SELECT * FROM orders INNER JOIN products ON orders.product_id = products.id " +
                           "WHERE orders.user_id = ? ORDER BY orders.order_id DESC";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getInt("order_id"));
                order.setId(rs.getInt("product_id"));
                order.setName(rs.getString("name"));
                order.setCategory(rs.getString("category"));
                order.setPrice(rs.getDouble("price") * rs.getInt("quantity"));
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("order_date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}