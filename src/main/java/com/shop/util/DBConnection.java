package com.shop.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load MySQL Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Replace 'password' with your MySQL password
                connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shopping_cart", "rajita", "Rajita@123");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}


//This is the "heart" of your data layer.