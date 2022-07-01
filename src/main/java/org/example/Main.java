package org.example;

import java.sql.*;

static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASS = "root";
    static final String QUERY = "SELECT pid, pname FROM Department";
    static final String QUERY = "SELECT pid, pname FROM Emp";
    public class Main {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                System.out.print("ID: " + rs.getInt("empid"));
                System.out.print(", Name: " + rs.getString("empname));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}