
package MODELO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import MODELO.Cliente;

public class ClienteDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final CONEXION connectionManager;

    public ClienteDao(CONEXION connectionManager) {
      

    // Método para insertar un nuevo cliente en la base de datos
      this.connectionManager = connectionManager;
    }

    public ClienteDao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes (id_cliente, dni, nombre, apellido, telefono, email, direccion, id_distrito, fecha_creacion) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getIdCliente());
            preparedStatement.setInt(2, cliente.getDni());
            preparedStatement.setString(3, cliente.getNombre());
            preparedStatement.setString(4, cliente.getApellido());
            preparedStatement.setInt(5, cliente.getTelefono());
            preparedStatement.setString(6, cliente.getEmail());
            preparedStatement.setString(7, cliente.getDireccion());
            preparedStatement.setString(8, cliente.getIdDistrito());
            preparedStatement.setObject(9, cliente.getFechaCreacion());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar cliente", e);
        } finally {
            closeResources();
        }
    }

    // Método para actualizar los datos de un cliente
    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET dni = ?, nombre = ?, apellido = ?, telefono = ?, email = ?, direccion = ?, id_distrito = ?,fecha_creacion=? " +
                     "WHERE id_cliente = ?";
        
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, cliente.getDni());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getApellido());
            preparedStatement.setInt(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getEmail());
            preparedStatement.setString(6, cliente.getDireccion());
            preparedStatement.setString(7, cliente.getIdDistrito());
            preparedStatement.setObject(8, cliente.getFechaCreacion());
            preparedStatement.setString(9, cliente.getIdCliente());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar cliente", e);
        } finally {
            closeResources();
        }
    }

    // Método para eliminar un cliente por su ID
    public void eliminarCliente(String idCliente) {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idCliente);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar cliente", e);
        } finally {
            closeResources();
        }
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(String idCliente) {
        Cliente cliente = null;
        String sql = "SELECT * FROM clientes WHERE id_cliente = ?";
        
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idCliente);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getString("id_cliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setIdDistrito(resultSet.getString("id_distrito"));
                cliente.setFechaCreacion(resultSet.getObject("fecha_creacion", LocalDate.class));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener cliente por ID", e);
        } finally {
            closeResources();
        }

        return cliente;
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";
        
        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getString("id_cliente"));
                cliente.setDni(resultSet.getInt("dni"));
                cliente.setNombre(resultSet.getString("nombre"));
                cliente.setApellido(resultSet.getString("apellido"));
                cliente.setTelefono(resultSet.getInt("telefono"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setIdDistrito(resultSet.getString("id_distrito"));
                cliente.setFechaCreacion(resultSet.getObject("fecha_creacion", LocalDate.class));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todos los clientes", e);
        } finally {
            closeResources();
        }

        return clientes;
    }

    // Método para cerrar recursos
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
            throw new RuntimeException("Error al cerrar los recursos", e);
        }
    }
    public Cliente Buscarcliente(int dni){
        Cliente cliente = new Cliente(); 
    String sql = "SELECT * FROM clientes WHERE dni=?";
    try {
        connection = connectionManager.getConnection();
        
        // Preparar la sentencia SQL
        preparedStatement = connection.prepareStatement(sql);
        
        // Establecer el valor del parámetro en la consulta
        preparedStatement.setInt(1, dni);   
        
        // Ejecutar la consulta
        ResultSet resultSet = preparedStatement.executeQuery();
        
        // Procesar los resultados de la consulta
        if (resultSet.next()) {
            cliente.setNombre(resultSet.getString("nombre"));
            cliente.setApellido(resultSet.getString("apellido"));
            
            // Obtener el teléfono y convertirlo a int, validando el rango
            long telefonoLong = resultSet.getLong("telefono");
            if (telefonoLong <= Integer.MAX_VALUE && telefonoLong >= Integer.MIN_VALUE) {
                int telefono = (int) telefonoLong;
                cliente.setTelefono(telefono);
            } else {
                throw new IllegalArgumentException("El número de teléfono es demasiado grande para un int");
            }
            
            cliente.setDireccion(resultSet.getString("direccion"));
        }
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    
    // Devolver el objeto Cliente
    return cliente;
}
}
