package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL =
            "jdbc:mysql://localhost:3306/speedfast_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "QWEfgh456.!";

    public static Connection Conectarse() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}