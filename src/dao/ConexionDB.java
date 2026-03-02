package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    //Como en la clase sincrónica, hacemos la conexión con la base de datos con desactivando el SSL y lo del UTC en zona horaria.
    private static final String URL =
            "jdbc:mysql://localhost:3306/speedfast_db?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "QWEfgh456.!";

    //Creamos un metodo que entrega la URL, usuario y contraseña mediante el driver.
    public static Connection Conectarse() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}