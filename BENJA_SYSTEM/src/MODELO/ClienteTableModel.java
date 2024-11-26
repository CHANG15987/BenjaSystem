
import MODELO.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
    private List<Cliente> clientes;
    private String[] columnNames = {"CODIGO", "DNI", "NOMBRE", "APELLIDO", "TELEFONO", "EMAIL", "DIRECCION", "DISTRITO", "FECHA DE CREACION"};

    public ClienteTableModel() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cliente.getIdCliente();
            case 1:
                return cliente.getDni();
            case 2:
                return cliente.getNombre();
            case 3:
                return cliente.getApellido();
            case 4:
                return cliente.getTelefono();
            case 5:
                return cliente.getEmail();
            case 6:
                return cliente.getDireccion();
            case 7:
                return cliente.getIdDistrito();
            case 8:
                return cliente.getFechaCreacion();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    // Método para actualizar la lista de clientes en el modelo
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
        fireTableDataChanged(); // Notifica a la tabla que los datos han cambiado
    }
}
