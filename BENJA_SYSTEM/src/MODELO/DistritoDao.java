package MODELO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class DistritoDao {
    
    Connection con;
    CONEXION cn = new CONEXION();
    PreparedStatement ps;
    ResultSet rs;

   // public boolean RegistrarDistritos(Distrito dis) {
        // Implementar lógica para registrar un distrito
     //   return false;
    //}

    public void ConsultarDistrito(JComboBox distrito) {
        String sql = "SELECT nombre FROM distritos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                distrito.addItem(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}