package com.shop.dao;   //

import java.sql.*;
import com.shop.model.User;
import com.shop.util.DBConnection;

public class UserDAO {
    public User loginUser(String email, String password) {
        User user = null;
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    
    public boolean registerUser(User user) {
        boolean result = false;
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO users (name, email, password, role) VALUES (?, ?, ?, 'CUSTOMER')";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, user.getName());
            pst.setString(2, user.getEmail());
            pst.setString(3, user.getPassword());

            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

//This class uses the DBConnection we made earlier to check if a user exists during login.