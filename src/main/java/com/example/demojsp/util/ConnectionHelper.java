package com.example.demojsp.util;

import java.sql.*;

public class ConnectionHelper {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/%s?useUnicode=true&characterEncoding=utf-8";
    private static final String DATABASE_NAME = "cinema";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PWD = "";
    private static Connection cnn;

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String dbClass = "com.mysql.cj.jdbc.Driver";
        if (cnn == null || cnn.isClosed()) {
            Class.forName(dbClass);
            cnn = DriverManager.getConnection(
                    String.format(DATABASE_URL, DATABASE_NAME),
                    DATABASE_USER,
                    DATABASE_PWD);
        }
        return cnn;
    }
}
