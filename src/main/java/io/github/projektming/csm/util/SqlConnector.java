package io.github.projektming.csm.util;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlConnecter {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123098";
    private static final Logger logger = Logger.getLogger(SqlConnecter.class.getName());

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "PostgreSQL JDBC Driver not found", e);
            throw new RuntimeException("PostgreSQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to create database connection", e);
        }
        return conn;
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error closing ResultSet", e);
        }
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error closing Statement", e);
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.log(Level.WARNING, "Error closing Connection", e);
        }

    }
}
