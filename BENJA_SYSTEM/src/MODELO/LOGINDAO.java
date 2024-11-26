
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LOGINDAO {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final CONEXION connectionManager;

    public LOGINDAO(CONEXION connectionManager) {
        this.connectionManager = connectionManager;
    }

    public LOGIN log(int dni, String pass) {
        LOGIN login = null;  // Inicializar como null para manejar el caso en que no se encuentre el usuario
        String sql = "SELECT * FROM usuarios WHERE dni = ? AND contrasena = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, dni);
            preparedStatement.setString(2, pass);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                login = new LOGIN();  // Crear instancia de LOGIN solo si se encuentra un usuario
                login.setId(resultSet.getString("id_usuario"));
                login.setDni(resultSet.getInt("dni"));
                login.setNombre(resultSet.getString("nombre"));
                login.setApellido(resultSet.getString("apellido"));
                login.setEmail(resultSet.getString("email"));
                login.setPass(resultSet.getString("contrasena"));
                login.setFechaNacimiento(resultSet.getObject("fecha_nacimiento", LocalDate.class));
                login.setGenero(resultSet.getString("genero"));
                login.setDireccion(resultSet.getString("direccion"));
                login.setDistrito(resultSet.getString("id_distrito"));
                login.setTelefono(resultSet.getInt("telefono"));
                login.setTipo(resultSet.getString("tipo_usuario"));
                login.setEstado(resultSet.getString("estado"));
                login.setFecha_creacion(resultSet.getObject("fecha_creacion", LocalDate.class));
            }
        } catch (SQLException e) {
            // Manejar el error de una manera más informativa
            throw new RuntimeException("Error al obtener el usuario", e);
        } finally {
            // Cerrar los recursos
            closeResources();
        }

        return login;
    }

    private void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            // Manejar el error de cierre de recursos
            throw new RuntimeException("Error al cerrar los recursos", e);
        }
    }
}