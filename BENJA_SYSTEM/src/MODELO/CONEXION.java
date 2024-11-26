
package MODELO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class CONEXION {
    private static final String URL = "jdbc:mysql://localhost:3306/ventas_benja?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public CONEXION() {
        // Constructor privado para evitar la instanciación
    }

    public static Connection getConnection() {
        Connection conectar = null;
        try {
            conectar = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return conectar;
    }

    public static void closeConnection(Connection conectar) {
        if (conectar != null) {
            try {
                conectar.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}