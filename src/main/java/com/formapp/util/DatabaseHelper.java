package com.formapp.util;

import com.formapp.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:users.db";

    static {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                         "first_name TEXT, " +
                         "last_name TEXT, " +
                         "email TEXT, " +
                         "phone_number TEXT)";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean insertUser(User user) {
        String sql = "INSERT INTO users (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<User> getAllUsers() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                User user = new User(
                        rs.getString("id"),
                        rs.getString("first_name"),
                                     rs.getString("last_name"),
                                     rs.getString("email"),
                                     rs.getString("phone_number"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
