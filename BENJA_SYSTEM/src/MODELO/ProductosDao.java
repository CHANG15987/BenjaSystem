
package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.math.BigDecimal;

public class ProductosDao {
    private Connection connection;
    private PreparedStatement preparedStatement;
   private   CONEXION connectionManager;
   private ResultSet rs;

    public List<Productos> listarProductos() {
        List<Productos> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Productos producto = new Productos();
                producto.setIdProducto(resultSet.getString("id_producto"));
                producto.setNombre(resultSet.getString("nombre"));
                producto.setPrecioUnitario(resultSet.getDouble("precio_unitario"));
                producto.setIdCategoria(resultSet.getString("id_categoria"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los productos", e);
        } finally {
            closeResources(connection, preparedStatement);
        }

        return productos;
    }
    public void eliminarProducto(String idProducto) {
       String sql = "DELETE FROM productos WHERE id_producto = ?";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, idProducto);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar producto", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }
     public void registrarProducto(Productos producto) {
        String sql = "INSERT INTO productos (id_producto, nombre, precio_unitario, id_categoria) VALUES (?, ?, ?, ?)";

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getIdProducto());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setDouble(3, producto.getPrecioUnitario());
            preparedStatement.setString(4, producto.getIdCategoria());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar el producto", e);
        } finally {
            closeResources(connection, preparedStatement);
        }
    }
     

    private static void closeResources(Connection connection, PreparedStatement preparedStatement) {
        try {
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
     public void consultarCategoria(JComboBox<String> categoria) {
        String sql = "SELECT nombre FROM categorias_productos";
        ResultSet rs = null;

        try {
            connection = connectionManager.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                categoria.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar las categorías", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
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
    }
    public void ModificarProducto(Productos producto) {
    String sql = "UPDATE productos SET nombre = ?, precio_unitario = ?, id_categoria = ? " +
                 "WHERE id_producto = ?";
    
    try {
        connection = connectionManager.getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, producto.getNombre());
        preparedStatement.setDouble(2, producto.getPrecioUnitario());
        preparedStatement.setString(3, producto.getIdCategoria());
        preparedStatement.setString(4, producto.getIdProducto());

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        throw new RuntimeException("Error al actualizar producto", e);
    } finally {
        // Aquí se llama al método closeResources con los argumentos correctos
        closeResources(connection, preparedStatement);
    }
}
public Productos BuscarPro(String cod) {
    Productos producto = new Productos();
    String sql = "SELECT id_producto, nombre, precio_unitario FROM productos WHERE id_producto = ?";
    try {
        Connection connection = connectionManager.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cod);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            producto.setIdProducto(resultSet.getString("id_producto"));
            producto.setNombre(resultSet.getString("nombre"));
            producto.setPrecioUnitario(resultSet.getDouble("precio_unitario"));
        }
        connection.close(); // Cierra la conexión
    } catch (SQLException e) {
        System.out.println("Error al buscar el producto: " + e.toString());
    }
    return producto;
}
}