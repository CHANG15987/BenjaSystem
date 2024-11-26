
package MODELO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VentaDao {
    Connection con;
    CONEXION cn = new CONEXION();
    PreparedStatement ps;
    int r;

    public int registrarVenta(Venta venta) {
         int resultado = 0;
        String sql = "INSERT INTO ventas(id_venta, id_cliente, fecha_hora_venta, total_venta) VALUES (?, ?, ?, ?)";
        try {
            con = CONEXION.getConnection(); // Obtener conexión a la base de datos
            ps = con.prepareStatement(sql);
            ps.setString(1, venta.getId_venta());
            ps.setString(2, venta.getId_cliente());
            ps.setTimestamp(3, Timestamp.valueOf(venta.getFecha_hora_venta()));
            ps.setDouble(4, venta.getTotal_venta());
            
            resultado = ps.executeUpdate(); // Ejecutar la consulta de inserción

            // Lógica adicional si es necesario

        } catch (SQLException e) {
            System.out.println("Error al intentar registrar la venta: " + e.toString());
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.toString());
            }
        }
        return resultado; // Devolver el resultado de la operación (número de filas afectadas)
    
    }
    public int RegistrarDetalle(DetalleVenta dv) {
       String sql = "INSERT INTO detalle_ventas(id_venta, id_producto, id_usuario, nombre, cantidad_vendida, total_venta, fecha_hora_venta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        try {
            con = CONEXION.getConnection(); // Usar el método estático getConnection de la clase CONEXION
            ps = con.prepareStatement(sql);
            ps.setString(1, dv.getId_venta());
            ps.setString(2, dv.getId_producto());
            ps.setString(3, dv.getId_usuario());
            ps.setString(4, dv.getNombre());
            ps.setInt(5, dv.getCantidad_vendida());
            ps.setDouble(6, dv.getTotal_venta());
            ps.setTimestamp(7, Timestamp.valueOf(dv.getFecha_hora_venta()));

            return ps.executeUpdate(); // Devuelve el número de filas afectadas
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // En caso de error, devuelve 0
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                CONEXION.closeConnection(con); // Usar el método estático closeConnection de la clase CONEXION
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e.toString());
            }
        }
    }
}