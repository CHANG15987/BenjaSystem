
package FOR_BENJA;
import MODELO.DetalleVenta;
 import java.time.LocalDate;
import java.time.LocalTime;
import MODELO.ProductosDao;
import MODELO.Productos;
import MODELO.CONEXION;
import MODELO.Cliente;
import MODELO.ClienteDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import MODELO.DistritoDao;
import MODELO.Distrito;
import MODELO.Venta;
import MODELO.VentaDao;
import REPORTE.Excel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 

public class menu_principal_benja extends javax.swing.JFrame {
 private Timer timer;
 CONEXION conexion;
 DefaultTableModel modelo;
 ClienteDao clienteDao;
 Productos pro=new Productos();
 ProductosDao proDao=new ProductosDao();
 DistritoDao disDao=new DistritoDao();
    private Cliente cliente;
    private ClienteDao client;// Declaración de Cliente
    private Productos productos;
    Venta v=new Venta();
    VentaDao Vdao=new VentaDao();
 int item;  
    public menu_principal_benja() {
        initComponents();
        actualizarFechaHora(); // Llamar una vez al inicio para establecer la fecha inicial

        // Configurar temporizador para actualizar la fecha y hora cada segundo (1000 milisegundos)
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarFechaHora();
            }
        });
        timer.start();
        //DefaultTableModel modeloTabla = (DefaultTableModel) table_ventas.getModel();
    }
    

    private void actualizarFechaHora() {
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = fechaHoraActual.format(formatter);
        txt_fecha_venta.setText(fechaHoraFormateada);
        this.setLocationRelativeTo(null);
        conexion = new CONEXION();
        clienteDao = new ClienteDao(conexion);
        AutoCompleteDecorator.decorate(cb_distrito_cliente);
        disDao.ConsultarDistrito(cb_distrito_cliente);
        AutoCompleteDecorator.decorate(cb_categoria_producto);
        proDao.consultarCategoria(cb_categoria_producto);
        this.client = new ClienteDao(conexion);
        
        
    }
    public void ListarCliente(){
        List<Cliente> clientes = clienteDao.obtenerTodosLosClientes(); // Correctamente obteniendo la lista de clientes
        modelo = (DefaultTableModel) table_clientes.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        Object[] ob = new Object[9]; // Ajustar el tamaño del array a 9
        for (int i = 0; i < clientes.size(); i++) {
            ob[0] = clientes.get(i).getIdCliente();
            ob[1] = clientes.get(i).getDni();
            ob[2] = clientes.get(i).getNombre();
            ob[3] = clientes.get(i).getApellido();
            ob[4] = clientes.get(i).getTelefono();
            ob[5] = clientes.get(i).getEmail();
            ob[6] = clientes.get(i).getDireccion();
            ob[7] = clientes.get(i).getIdDistrito();
            ob[8] = clientes.get(i).getFechaCreacion();
            modelo.addRow(ob);
        }
        table_clientes.setModel(modelo);
        
    }
     public void listarProductos() {
  // List<Productos> productos = ProductosDao     
    List<Productos> ListarPro = proDao.listarProductos();
        modelo = (DefaultTableModel) table_productos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos
        Object[] ob = new Object[4]; // Ajustar el tamaño del array a 9
        for (int i = 0; i < ListarPro.size(); i++) {
            ob[0] = ListarPro.get(i).getIdProducto();
            ob[1] = ListarPro.get(i).getNombre();
            ob[2] = ListarPro.get(i).getPrecioUnitario();
            ob[3] = ListarPro.get(i).getIdCategoria();
            modelo.addRow(ob);
        }
        table_productos.setModel(modelo);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fondo = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        btn_eliminar_cliente = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_guardar_cliente = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        txt_fecha_creacion_cliente = new javax.swing.JTextField();
        cb_distrito_cliente = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_direccion_cliente = new javax.swing.JTextField();
        txt_email_cliente = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_apellido_cliente = new javax.swing.JTextField();
        txt_telefono_cliente = new javax.swing.JTextField();
        txt_nombre_cliente = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txt_codigo_cliente = new javax.swing.JTextField();
        txt_dni_cliente = new javax.swing.JTextField();
        btn_limpiar_cliente = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_clientes = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_codigo_producto = new javax.swing.JTextField();
        txt_nombre_producto = new javax.swing.JTextField();
        txt_precio_unitario = new javax.swing.JTextField();
        cb_categoria_producto = new javax.swing.JComboBox<>();
        btn_guardar_producto = new javax.swing.JButton();
        btn_actualizar_producto = new javax.swing.JButton();
        btn_eliminar_producto = new javax.swing.JButton();
        btn_salir_producto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_productos = new javax.swing.JTable();
        btn_excel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ventas = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_descripcion_producto_venta = new javax.swing.JTextField();
        txt_codigo_producto_venta = new javax.swing.JTextField();
        txt_cantidad_producto_venta = new javax.swing.JTextField();
        txt_precio_producto_venta = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txt_total_pagar_venta = new javax.swing.JTextField();
        btn_eliminar_producto_venta = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_dni_cliente_venta = new javax.swing.JTextField();
        txt_nombre_cliente_venta = new javax.swing.JTextField();
        txt_fecha_venta = new javax.swing.JTextField();
        btn_generar_venta = new javax.swing.JButton();
        txt_numero_venta = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txt_fecha1 = new javax.swing.JTextField();
        cb_distrito1 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txt_direccion1 = new javax.swing.JTextField();
        txt_email1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txt_apellido1 = new javax.swing.JTextField();
        txt_telefono1 = new javax.swing.JTextField();
        txt_nombre1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txt_codigo1 = new javax.swing.JTextField();
        txt_dni1 = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        panel_superior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel_fondopos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btn_productos = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btn_clientes = new javax.swing.JButton();
        lbl_vendedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_fondo.setBackground(new java.awt.Color(255, 255, 255));
        panel_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setName(""); // NOI18N

        btn_eliminar_cliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btn_eliminar_cliente.setText("ELIMINAR");
        btn_eliminar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_clienteActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_guardar_cliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btn_guardar_cliente.setText("GUARDAR");
        btn_guardar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_clienteActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel25.setText("Fecha de Creación:");

        txt_fecha_creacion_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        cb_distrito_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        cb_distrito_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_distrito_clienteActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel26.setText("Distrito:");

        jLabel27.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel27.setText("Dirección:");

        txt_direccion_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        txt_email_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        jLabel28.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel28.setText("Email:");

        jLabel29.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel29.setText("Teléfono");

        jLabel30.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel30.setText("Apellido:");

        txt_apellido_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        txt_telefono_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        txt_nombre_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel31.setText("Nombre:");

        jLabel32.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel32.setText("DNI:");

        jLabel33.setFont(new java.awt.Font("Roboto Medium", 1, 12)); // NOI18N
        jLabel33.setText("Código:");

        txt_codigo_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        txt_dni_cliente.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N

        btn_limpiar_cliente.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        btn_limpiar_cliente.setText("LIMPIAR");
        btn_limpiar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_clienteActionPerformed(evt);
            }
        });

        table_clientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DNI", "NOMBRE", "APELLIDO", "TELEFONO", "EMAIL", "DIRECCION", "DISTRITO", "FECHA DE CREACION"
            }
        ));
        table_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_clientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_clientes);
        if (table_clientes.getColumnModel().getColumnCount() > 0) {
            table_clientes.getColumnModel().getColumn(0).setPreferredWidth(20);
        }

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(txt_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(txt_dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_apellido_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_telefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txt_email_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_direccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cb_distrito_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_fecha_creacion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(btn_limpiar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_guardar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_eliminar_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 884, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel32)
                                    .addComponent(txt_dni_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33)
                                .addComponent(txt_codigo_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(txt_nombre_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(txt_apellido_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(txt_telefono_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txt_email_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txt_direccion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_distrito_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txt_fecha_creacion_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_guardar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btn_eliminar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_limpiar_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel2.setText("Código:");

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel9.setText("Nombre:");

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel10.setText("Precio_unitario:");

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jLabel13.setText("ID_CATEGORIA");

        txt_codigo_producto.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        txt_codigo_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo_productoActionPerformed(evt);
            }
        });

        txt_nombre_producto.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        txt_precio_unitario.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        cb_categoria_producto.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N

        btn_guardar_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_guardar_producto.setText("GUARDAR");
        btn_guardar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardar_productoActionPerformed(evt);
            }
        });

        btn_actualizar_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_actualizar_producto.setText("ACTUALIZAR");
        btn_actualizar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizar_productoActionPerformed(evt);
            }
        });

        btn_eliminar_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_eliminar_producto.setText("ELIMINAR");
        btn_eliminar_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_productoActionPerformed(evt);
            }
        });

        btn_salir_producto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_salir_producto.setText("SALIR");
        btn_salir_producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salir_productoActionPerformed(evt);
            }
        });

        table_productos.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        table_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO UNITARIO", "ID_CATEGORIA"
            }
        ));
        table_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_productosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_productos);
        if (table_productos.getColumnModel().getColumnCount() > 0) {
            table_productos.getColumnModel().getColumn(0).setPreferredWidth(15);
            table_productos.getColumnModel().getColumn(1).setPreferredWidth(250);
            table_productos.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        btn_excel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_excel.setText("EXCEL");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_eliminar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(cb_categoria_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_salir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_actualizar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_guardar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_codigo_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_nombre_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_precio_unitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cb_categoria_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_guardar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_actualizar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_eliminar_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_salir_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_excel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        table_ventas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table_ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "DESCRIPCION", "CANTIDAD", "PRECIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(table_ventas);
        if (table_ventas.getColumnModel().getColumnCount() > 0) {
            table_ventas.getColumnModel().getColumn(0).setPreferredWidth(30);
            table_ventas.getColumnModel().getColumn(1).setPreferredWidth(100);
            table_ventas.getColumnModel().getColumn(2).setPreferredWidth(30);
            table_ventas.getColumnModel().getColumn(3).setPreferredWidth(30);
            table_ventas.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jLabel4.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel4.setText("Código");

        jLabel5.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel5.setText("Descripción");

        jLabel6.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad");

        jLabel7.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel7.setText("Precio");

        txt_descripcion_producto_venta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_descripcion_producto_venta.setEnabled(false);

        txt_codigo_producto_venta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_codigo_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo_producto_ventaActionPerformed(evt);
            }
        });
        txt_codigo_producto_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_codigo_producto_ventaKeyPressed(evt);
            }
        });

        txt_cantidad_producto_venta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_cantidad_producto_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cantidad_producto_ventaKeyPressed(evt);
            }
        });

        txt_precio_producto_venta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_precio_producto_venta.setEnabled(false);

        jLabel34.setText("Total a pagar:");

        txt_total_pagar_venta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_total_pagar_venta.setForeground(new java.awt.Color(51, 255, 0));
        txt_total_pagar_venta.setEnabled(false);

        btn_eliminar_producto_venta.setText("Eliminar");
        btn_eliminar_producto_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminar_producto_ventaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel8.setText("Dni");

        jLabel11.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel11.setText("Nombre");

        txt_dni_cliente_venta.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        txt_dni_cliente_venta.setForeground(new java.awt.Color(0, 0, 204));
        txt_dni_cliente_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dni_cliente_ventaActionPerformed(evt);
            }
        });
        txt_dni_cliente_venta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dni_cliente_ventaKeyPressed(evt);
            }
        });

        txt_nombre_cliente_venta.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        txt_nombre_cliente_venta.setForeground(new java.awt.Color(0, 0, 204));
        txt_nombre_cliente_venta.setEnabled(false);

        txt_fecha_venta.setEditable(false);
        txt_fecha_venta.setFont(new java.awt.Font("Yu Gothic", 1, 36)); // NOI18N
        txt_fecha_venta.setForeground(new java.awt.Color(255, 0, 0));
        txt_fecha_venta.setText("fecha de venta");
        txt_fecha_venta.setAutoscrolls(false);

        btn_generar_venta.setText("VENDER");
        btn_generar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generar_ventaActionPerformed(evt);
            }
        });

        txt_numero_venta.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        txt_numero_venta.setForeground(new java.awt.Color(0, 255, 204));

        jLabel12.setFont(new java.awt.Font("Roboto Black", 1, 12)); // NOI18N
        jLabel12.setText("numero de venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_codigo_producto_venta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_descripcion_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txt_cantidad_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_precio_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73)
                        .addComponent(txt_fecha_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(txt_dni_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nombre_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_eliminar_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(298, 298, 298)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_numero_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_total_pagar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel34))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_generar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_descripcion_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_cantidad_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_precio_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_codigo_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txt_fecha_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_dni_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre_cliente_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_eliminar_producto_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_numero_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btn_generar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_total_pagar_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jButton9.setText("Guardar");

        jButton10.setText("Guardar");

        jButton11.setText("Guardar");

        jLabel17.setText("Fecha de Creación:");

        cb_distrito1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_distrito1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_distrito1ActionPerformed(evt);
            }
        });

        jLabel15.setText("Distrito:");

        jLabel18.setText("Dirección:");

        jLabel19.setText("Email:");

        jLabel20.setText("Teléfono");

        jLabel21.setText("Apellido:");

        jLabel22.setText("Nombre:");

        jLabel23.setText("DNI:");

        jLabel24.setText("Código:");

        jButton12.setText("Guardar");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txt_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_dni1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cb_distrito1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(txt_direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(57, 57, 57)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_fecha1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(24, 24, 24))))))
                .addContainerGap(922, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txt_codigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txt_dni1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22))
                    .addComponent(txt_nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(txt_apellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txt_telefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txt_email1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txt_direccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cb_distrito1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txt_fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        panel_fondo.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 1220, 540));

        panel_superior.setBackground(new java.awt.Color(0, 153, 51));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Jokerman", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Punto de venta");

        javax.swing.GroupLayout panel_superiorLayout = new javax.swing.GroupLayout(panel_superior);
        panel_superior.setLayout(panel_superiorLayout);
        panel_superiorLayout.setHorizontalGroup(
            panel_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_superiorLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1103, Short.MAX_VALUE))
        );
        panel_superiorLayout.setVerticalGroup(
            panel_superiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_superiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_fondo.add(panel_superior, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 1290, 50));

        panel_fondopos.setBackground(new java.awt.Color(255, 255, 255));
        panel_fondopos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/pos.png"))); // NOI18N
        panel_fondopos.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 80, 40));

        panel_fondo.add(panel_fondopos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/nueva venta.png"))); // NOI18N
        jButton2.setText("Nueva Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btn_productos.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btn_productos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/productos.gif"))); // NOI18N
        btn_productos.setText("Productos");
        btn_productos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_productosActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/ventas.gif"))); // NOI18N
        jButton4.setText("Ventas");

        jButton5.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/configuracion.png"))); // NOI18N
        jButton5.setText("Configuración");

        btn_clientes.setFont(new java.awt.Font("Roboto Medium", 1, 14)); // NOI18N
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/clientes.png"))); // NOI18N
        btn_clientes.setText("Clientes");
        btn_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clientesActionPerformed(evt);
            }
        });

        lbl_vendedor.setText("U001");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(btn_productos)
                .addGap(18, 18, 18)
                .addComponent(btn_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lbl_vendedor)
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(btn_productos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clientes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panel_fondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1360, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(117, 117, 117))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_clienteActionPerformed
String idCliente = txt_codigo_cliente.getText();
    int dni = Integer.parseInt(txt_dni_cliente.getText());
    String nombre = txt_nombre_cliente.getText();
    String apellido = txt_apellido_cliente.getText();
    String email = txt_email_cliente.getText();
    String direccion = txt_direccion_cliente.getText();
    String idDistrito = cb_distrito_cliente.getSelectedItem().toString();
    int telefono = Integer.parseInt(txt_telefono_cliente.getText());
    LocalDate fechaCreacion;
    
    try {
        // Intentar obtener la fecha de creación del JTextField txt_fecha_creacion_cliente
        fechaCreacion = LocalDate.parse(txt_fecha_creacion_cliente.getText());
    } catch (DateTimeParseException ex) {
        // Manejar error si el formato de fecha no es válido
        JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Utiliza el formato YYYY-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Salir del método si hay un error
    }

    // Crear un objeto Cliente
    Cliente cliente = new Cliente(idCliente, dni, nombre, apellido, email, direccion, idDistrito, telefono, fechaCreacion);

    // Crear una instancia de CONEXION y ClienteDao
    CONEXION conexion = new CONEXION();
    ClienteDao clienteDao = new ClienteDao(conexion);

    try {
        // Insertar el cliente en la base de datos
        clienteDao.insertarCliente(cliente);
        JOptionPane.showMessageDialog(this, "Cliente registrado con éxito.");

        // Opcional: Limpiar los campos del formulario después de registrar
        limpiarCampos();     
        // Llamar al método para listar nuevamente los clientes en la tabla
        ListarCliente();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al registrar el cliente: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

// Método para limpiar los campos del formulario después de registrar
private void limpiarCampos() {
    txt_codigo_cliente.setText("");
    txt_dni_cliente.setText("");
    txt_nombre_cliente.setText("");
    txt_apellido_cliente.setText("");
    txt_email_cliente.setText("");
    txt_direccion_cliente.setText("");
    cb_distrito_cliente.setSelectedIndex(0);  // Puedes seleccionar el primer ítem por defecto o limpiar como necesites
    txt_telefono_cliente.setText("");
    txt_fecha_creacion_cliente.setText("");  // Limpiar el campo de fecha de creación

    }//GEN-LAST:event_btn_guardar_clienteActionPerformed

    private void btn_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clientesActionPerformed
                                
    jTabbedPane1.setSelectedIndex(0);
        ListarCliente();
        
    // jTabbedPane1.setSelectedIndex(3);
    }//GEN-LAST:event_btn_clientesActionPerformed

    private void table_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_clientesMouseClicked
     int fila=table_clientes.rowAtPoint(evt.getPoint());
     txt_codigo_cliente.setText(table_clientes.getValueAt(fila,0).toString());
     txt_dni_cliente.setText(table_clientes.getValueAt(fila,1).toString());
     txt_nombre_cliente.setText(table_clientes.getValueAt(fila,2).toString());
     txt_apellido_cliente.setText(table_clientes.getValueAt(fila,3).toString());
     txt_telefono_cliente.setText(table_clientes.getValueAt(fila,4).toString());
     txt_email_cliente.setText(table_clientes.getValueAt(fila,5).toString());
     txt_direccion_cliente.setText(table_clientes.getValueAt(fila,6).toString());
     cb_distrito_cliente.setSelectedItem(table_clientes.getValueAt(fila, 7).toString());
     txt_fecha_creacion_cliente.setText(table_clientes.getValueAt(fila,8).toString());
    }//GEN-LAST:event_table_clientesMouseClicked

    private void btn_eliminar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_clienteActionPerformed
        if (!"".equals(txt_codigo_cliente.getText())) {
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (pregunta == JOptionPane.YES_OPTION) {
            String idCliente = txt_codigo_cliente.getText(); // Obtener el código del cliente como String
            
            // Crear una instancia de CONEXION (suponiendo que tengas una clase así)
            CONEXION conexion = new CONEXION(); // Asegúrate de que esta línea sea correcta según tu implementación
            
            // Crear una instancia de ClienteDao pasando la conexión como argumento
            ClienteDao clienteDao = new ClienteDao(conexion);
            
            // Llamar al método eliminarCliente de ClienteDao
            clienteDao.eliminarCliente(idCliente);
            
            // Después de eliminar, limpiar y volver a llenar la tabla (asumiendo que estos métodos existen en tu interfaz gráfica)
            limpiarCampos();
            ListarCliente(); // Asumiendo que este método vuelve a llenar la tabla con clientes actualizados
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un cliente para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btn_eliminar_clienteActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
      // Verifica si el campo de texto del código del cliente está vacío
      if ("".equals(txt_codigo_cliente.getText().trim())) {
        JOptionPane.showMessageDialog(null, "Seleccione una fila");
    } else {
        // Crear un objeto cliente y establecer sus atributos
        cliente = new Cliente();
        cliente.setIdCliente(txt_codigo_cliente.getText().trim());
        cliente.setDni(Integer.parseInt(txt_dni_cliente.getText().trim()));
        cliente.setNombre(txt_nombre_cliente.getText().trim());
        cliente.setApellido(txt_apellido_cliente.getText().trim());
        cliente.setTelefono(Integer.parseInt(txt_telefono_cliente.getText().trim()));
        cliente.setEmail(txt_email_cliente.getText().trim());
        cliente.setDireccion(txt_direccion_cliente.getText().trim());
        cliente.setIdDistrito(cb_distrito_cliente.getSelectedItem().toString().trim());
        
        // Verificar y parsear la fecha de creación
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaCreacion = LocalDate.parse(txt_fecha_creacion_cliente.getText().trim(), formatter);
            cliente.setFechaCreacion(fechaCreacion);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Ingrese una fecha de creación válida (formato yyyy-MM-dd)");
            return; // Salir del método si la fecha de creación no es válida
        }

        // Verificar si los campos obligatorios no están vacíos
        if (!"".equals(txt_nombre_cliente.getText().trim()) &&
            !"".equals(txt_telefono_cliente.getText().trim())) {

            // Llama al método para modificar el cliente (debes tener un método actualizarCliente en tu clase clienteDao)
            clienteDao.actualizarCliente(cliente);

            // Limpiar los campos de texto después de la operación
            limpiarCampos();
            ListarCliente(); // Supongo que esto lista los clientes actualizados en alguna tabla o lista
        } else {
            JOptionPane.showMessageDialog(null, "Los campos Nombre y Teléfono son obligatorios");
        }
            
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_limpiar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_clienteActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btn_limpiar_clienteActionPerformed

    private void cb_distrito1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_distrito1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_distrito1ActionPerformed

    private void txt_codigo_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo_productoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_productoActionPerformed

    private void btn_productosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_productosActionPerformed
        limpiarProductos();
        listarProductos();
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btn_productosActionPerformed

    private void btn_guardar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardar_productoActionPerformed
      if (!"".equals(txt_codigo_producto.getText()) && 
        !"".equals(txt_nombre_producto.getText()) && 
        !"".equals(txt_precio_unitario.getText()) && 
        cb_categoria_producto.getSelectedItem() != null) {
        
        try {
            // Intenta parsear el precio unitario a Double
            double precioUnitario = Double.parseDouble(txt_precio_unitario.getText());
            
            // Si todo está bien, procede a registrar el producto
            pro.setIdProducto(txt_codigo_producto.getText());
            pro.setNombre(txt_nombre_producto.getText());
            pro.setPrecioUnitario(precioUnitario);
            pro.setIdCategoria((String) cb_categoria_producto.getSelectedItem());
            
            proDao.registrarProducto(pro);
            
            JOptionPane.showMessageDialog(null, "Producto registrado con éxito");
        } catch (NumberFormatException e) {
            // Si ocurre un error al parsear el precio unitario
            JOptionPane.showMessageDialog(null, "El precio unitario debe ser un número válido");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos");
    
}
    }//GEN-LAST:event_btn_guardar_productoActionPerformed

    private void table_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_productosMouseClicked
        int fila=table_productos.rowAtPoint(evt.getPoint());
     txt_codigo_producto.setText(table_productos.getValueAt(fila,0).toString());
     txt_nombre_producto.setText(table_productos.getValueAt(fila,1).toString());
     txt_precio_unitario.setText(table_productos.getValueAt(fila,2).toString());
     cb_categoria_producto.setSelectedItem(table_productos.getValueAt(fila, 3));
    }//GEN-LAST:event_table_productosMouseClicked

    private void btn_eliminar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_productoActionPerformed
        if (!"".equals(txt_codigo_producto.getText())) {
        int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (pregunta == JOptionPane.YES_OPTION) {
            String idCliente = txt_codigo_producto.getText(); // Obtener el código del cliente como String                                                           
            proDao.eliminarProducto(idCliente);
            limpiarCampos();
            
            // Después de eliminar, limpiar y volver a llenar la tabla (asumiendo que estos métodos existen en tu interfaz gráfica)
            limpiarProductos();
            listarProductos();
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
    }
     


    }//GEN-LAST:event_btn_eliminar_productoActionPerformed

    private void btn_actualizar_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizar_productoActionPerformed
                                              
      // Verifica si el campo de texto del código del producto está vacío
    if ("".equals(txt_codigo_producto.getText().trim())) {
        JOptionPane.showMessageDialog(null, "Seleccione una fila");
    } else {
        // Crear un objeto producto y establecer sus atributos
        Productos producto = new Productos();
        producto.setIdProducto(txt_codigo_producto.getText().trim());
        producto.setNombre(txt_nombre_producto.getText().trim());
        
        // Verificar y parsear el precio unitario
        try {
            double precioUnitario = Double.parseDouble(txt_precio_unitario.getText().trim());
            producto.setPrecioUnitario(precioUnitario);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un precio unitario válido");
            return; // Salir del método si el precio unitario no es válido
        }
        
        producto.setIdCategoria(cb_categoria_producto.getSelectedItem().toString().trim());
        
        // Verificar si los campos obligatorios no están vacíos
        if (!"".equals(txt_nombre_producto.getText().trim()) &&
            !"".equals(txt_precio_unitario.getText().trim())) {

            // Llama al método para modificar el producto (debes tener un método actualizarProducto en tu clase ProductosDao)
            proDao.ModificarProducto(producto);

            // Limpiar los campos de texto después de la operación
            limpiarProductos(); // Supongo que esto limpia los campos relacionados con productos
            listarProductos(); // Supongo que esto lista los productos actualizados en alguna tabla o lista
        } else {
            JOptionPane.showMessageDialog(null, "Los campos Nombre y Precio Unitario son obligatorios");
        }
            
        }
    
    }//GEN-LAST:event_btn_actualizar_productoActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        Excel.reporte();
    }//GEN-LAST:event_btn_excelActionPerformed

    private void txt_codigo_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo_producto_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_producto_ventaActionPerformed

    private void txt_codigo_producto_ventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_producto_ventaKeyPressed
     if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        String codigoProducto = txt_codigo_producto_venta.getText().trim(); // Obtener código ingresado
        
        if (!codigoProducto.isEmpty()) {
            // Verificar si el producto ya está en la tabla de ventas
            boolean productoRepetido = false;
            DefaultTableModel modeloTabla = (DefaultTableModel) table_ventas.getModel();
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String codigoEnTabla = modeloTabla.getValueAt(i, 0).toString(); // Suponiendo que la columna 0 es el código del producto
                if (codigoEnTabla.equals(codigoProducto)) {
                    productoRepetido = true;
                    break;
                }
            }
            
            if (productoRepetido) {
                JOptionPane.showMessageDialog(null, "Este producto ya ha sido registrado en la venta.");
                txt_codigo_producto_venta.setText(""); // Limpiar campo de código de producto
            } else {
                // Si no está repetido, buscar el producto en la base de datos
                pro = proDao.BuscarPro(codigoProducto);
                
                if (pro.getNombre() != null) {
                    // Si se encontró el producto, actualizar campos
                    txt_descripcion_producto_venta.setText(pro.getNombre());
                    txt_precio_producto_venta.setText(String.valueOf(pro.getPrecioUnitario()));
                    txt_cantidad_producto_venta.requestFocus(); // Mover foco al siguiente campo si es necesario
                } else {
                    // Si no se encontró el producto, limpiar campos y mostrar mensaje
                    txt_descripcion_producto_venta.setText("");
                    txt_precio_producto_venta.setText("");           
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    txt_codigo_producto_venta.setText("");
                }
            }
        } else {
            // Mostrar mensaje si el campo está vacío
            JOptionPane.showMessageDialog(null, "Ingrese el código del producto");
        }
    }

    }//GEN-LAST:event_txt_codigo_producto_ventaKeyPressed
    private double totalActual = 0.0;
    private void txt_cantidad_producto_ventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidad_producto_ventaKeyPressed
     if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if (!"".equals(txt_cantidad_producto_venta.getText().trim())) {
            try {
                // Obtener valores ingresados
                String codigoProducto = txt_codigo_producto_venta.getText().trim(); // Obtener código del producto
                String descripcion = txt_descripcion_producto_venta.getText().trim();
                int cantidad = Integer.parseInt(txt_cantidad_producto_venta.getText().trim());
                double precio = Double.parseDouble(txt_precio_producto_venta.getText().trim());

                // Calcular total
                double total = cantidad * precio;

                // Agregar datos a la tabla de ventas
                DefaultTableModel modelo = (DefaultTableModel) table_ventas.getModel();
                Object[] fila = {codigoProducto, descripcion, cantidad, precio, total};
                modelo.addRow(fila);
                table_ventas.setModel(modelo);

                // Actualizar el total a pagar
                double totalActual = calcularTotal(modelo);
                txt_total_pagar_venta.setText(String.format("%.2f", totalActual));

                // Limpiar campos
                limpiarProductos_ventas();
                txt_codigo_producto_venta.requestFocus();

            } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(null, "Error al convertir valores numéricos");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad del producto");
        }
    }
}

private double calcularTotal(DefaultTableModel modelo) {
    double total = 0.0;
    for (int i = 0; i < modelo.getRowCount(); i++) {
        int cantidad = (int) modelo.getValueAt(i, 2); // Obtener cantidad como Integer
        double precio = (double) modelo.getValueAt(i, 3); // Obtener precio como Double
        double subtotal = cantidad * precio;
        total += subtotal;
    }
    return total;

    }//GEN-LAST:event_txt_cantidad_producto_ventaKeyPressed

    private void btn_eliminar_producto_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminar_producto_ventaActionPerformed
        modelo=(DefaultTableModel)table_ventas.getModel();
        modelo.removeRow(table_ventas.getSelectedRow());
       calcularTotal(modelo);
       txt_codigo_producto_venta.requestFocus();
       
        
    }//GEN-LAST:event_btn_eliminar_producto_ventaActionPerformed

    private void txt_dni_cliente_ventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dni_cliente_ventaKeyPressed
     if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
        if(!"".equals(txt_dni_cliente_venta.getText())) {
            try {
                int dni = Integer.parseInt(txt_dni_cliente_venta.getText());
                Cliente cl = client.Buscarcliente(dni); // Suponiendo que 'client' es una instancia de 'ClienteDao'
                
                if(cl.getNombre() != null) {
                    // Concatenar nombre y apellido en un solo campo de texto
                    String nombreCompleto = cl.getNombre() + " " + cl.getApellido();
                    txt_nombre_cliente_venta.setText(nombreCompleto);
                    
                    // Establecer otros campos de texto con la información del cliente
                    //txt_TelefonoCV.setText(String.valueOf(cl.getTelefono()));
                    //txtDireccionCV.setText(cl.getDireccion());
                    
                    // Aquí puedes continuar con la lógica adicional si es necesario
                    
                } else {
                    JOptionPane.showMessageDialog(null, "El cliente no existe");
                    txt_dni_cliente_venta.setText("");
                    txt_nombre_cliente_venta.setText("");
                    // Manejar el caso donde el cliente no se encuentra
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "DNI inválido");
                txt_dni_cliente_venta.setText("");
                 txt_nombre_cliente_venta.setText("");
                // Manejar el caso donde el DNI ingresado no es un número válido
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un DNI");
             txt_nombre_cliente_venta.setText("");
            // Manejar el caso donde no se ha ingresado un DNI
        }
       }
    }//GEN-LAST:event_txt_dni_cliente_ventaKeyPressed

    private void btn_generar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generar_ventaActionPerformed

        RegistrarVenta();
        RegistrarDetalle();
    

    }//GEN-LAST:event_btn_generar_ventaActionPerformed

    private void txt_dni_cliente_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dni_cliente_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dni_cliente_ventaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cb_distrito_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_distrito_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_distrito_clienteActionPerformed

    private void btn_salir_productoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salir_productoActionPerformed
         dispose();
    }//GEN-LAST:event_btn_salir_productoActionPerformed
private void limpiarProductos() {
    txt_codigo_producto.setText("");
    txt_nombre_producto.setText("");
    txt_precio_unitario.setText("");
    cb_categoria_producto.setSelectedIndex(0);
}
private void limpiarProductos_ventas() {
    txt_codigo_producto_venta.setText("");
    txt_descripcion_producto_venta.setText("");
    txt_precio_producto_venta.setText("");
    txt_cantidad_producto_venta.setText("");
    txt_dni_cliente_venta.setText("");
    txt_nombre_cliente_venta.setText("");
   // txt_total_pagar_venta.setText("");
}
private void RegistrarVenta() {
         String idVenta = txt_numero_venta.getText().trim(); // Código de la venta
    String idCliente = txt_dni_cliente_venta.getText().trim(); // ID del cliente
    String totalTexto = txt_total_pagar_venta.getText().trim(); // Total de la venta en texto

    // Validar que todos los campos necesarios estén llenos
    if (idVenta.isEmpty() || idCliente.isEmpty() || totalTexto.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convertir el total de la venta a double
    double totalVenta = 0.0;
    try {
        totalVenta = Double.parseDouble(totalTexto);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Ingrese un total válido.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener la fecha y hora actual para la venta
    LocalDateTime fechaHoraVenta = LocalDateTime.now();

    // Crear una instancia de Venta con los datos obtenidos
    Venta venta = new Venta(idVenta, idCliente, fechaHoraVenta, totalVenta);

    // Llamar al método RegistrarVenta de VentaDao para guardar la venta en la base de datos
    VentaDao ventaDao = new VentaDao();
    int resultado = ventaDao.registrarVenta(venta);

    // Verificar el resultado de la operación y mostrar mensajes correspondientes
    if (resultado > 0) {
        JOptionPane.showMessageDialog(null, "Venta registrada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Error al registrar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
    }


}
private void RegistrarDetalle(){
    VentaDao ventaDao = new VentaDao();
    for (int i = 0; i < table_ventas.getRowCount(); i++) {
        String idVenta = txt_numero_venta.getText(); // Obtener el código de la venta desde un campo de texto
        String idProducto = table_ventas.getValueAt(i, 0).toString(); // Obtener el código del producto desde la tabla
        String idUsuario = lbl_vendedor.getText(); // Obtener el ID del usuario (suponiendo que está en un JLabel)
        String nombre = txt_nombre_cliente_venta.getText(); // Obtener el nombre del cliente desde un campo de texto
        int cantidadVendida = Integer.parseInt(table_ventas.getValueAt(i, 2).toString()); // Obtener la cantidad vendida desde la tabla
        double totalVenta = Double.parseDouble(table_ventas.getValueAt(i, 4).toString()); // Obtener el total de la venta desde la tabla
        LocalDateTime fechaHoraVenta = LocalDateTime.now(); // Usar la fecha y hora actual

        // Crear una instancia de DetalleVenta con los datos obtenidos
        DetalleVenta detalleVenta = new DetalleVenta();
        detalleVenta.setId_venta(idVenta);
        detalleVenta.setId_producto(idProducto);
        detalleVenta.setId_usuario(idUsuario);
        detalleVenta.setNombre(nombre);
        detalleVenta.setCantidad_vendida(cantidadVendida);
        detalleVenta.setTotal_venta(totalVenta);
        detalleVenta.setFecha_hora_venta(fechaHoraVenta);

        // Registrar el detalle de la venta
        int resultado = ventaDao.RegistrarDetalle(detalleVenta);

        if (resultado <= 0) {
            // Hubo un error al intentar registrar el detalle de la venta
            JOptionPane.showMessageDialog(null, "Error al registrar el detalle de la venta del producto: " + idProducto, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Si todos los detalles de ventas se registraron correctamente
    JOptionPane.showMessageDialog(null, "Realizar siguiente venta.", "Éxitos", JOptionPane.INFORMATION_MESSAGE);
    limpiarProductos_ventas();
}
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_principal_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_principal_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_principal_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_principal_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_principal_benja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar_producto;
    private javax.swing.JButton btn_clientes;
    private javax.swing.JButton btn_eliminar_cliente;
    private javax.swing.JButton btn_eliminar_producto;
    private javax.swing.JButton btn_eliminar_producto_venta;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_generar_venta;
    private javax.swing.JButton btn_guardar_cliente;
    private javax.swing.JButton btn_guardar_producto;
    private javax.swing.JButton btn_limpiar_cliente;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_productos;
    private javax.swing.JButton btn_salir_producto;
    private javax.swing.JComboBox<String> cb_categoria_producto;
    private javax.swing.JComboBox<String> cb_distrito1;
    private javax.swing.JComboBox<String> cb_distrito_cliente;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_vendedor;
    private javax.swing.JPanel panel_fondo;
    private javax.swing.JPanel panel_fondopos;
    private javax.swing.JPanel panel_superior;
    private javax.swing.JTable table_clientes;
    private javax.swing.JTable table_productos;
    private javax.swing.JTable table_ventas;
    private javax.swing.JTextField txt_apellido1;
    private javax.swing.JTextField txt_apellido_cliente;
    private javax.swing.JTextField txt_cantidad_producto_venta;
    private javax.swing.JTextField txt_codigo1;
    private javax.swing.JTextField txt_codigo_cliente;
    private javax.swing.JTextField txt_codigo_producto;
    private javax.swing.JTextField txt_codigo_producto_venta;
    private javax.swing.JTextField txt_descripcion_producto_venta;
    private javax.swing.JTextField txt_direccion1;
    private javax.swing.JTextField txt_direccion_cliente;
    private javax.swing.JTextField txt_dni1;
    private javax.swing.JTextField txt_dni_cliente;
    private javax.swing.JTextField txt_dni_cliente_venta;
    private javax.swing.JTextField txt_email1;
    private javax.swing.JTextField txt_email_cliente;
    private javax.swing.JTextField txt_fecha1;
    private javax.swing.JTextField txt_fecha_creacion_cliente;
    private javax.swing.JTextField txt_fecha_venta;
    private javax.swing.JTextField txt_nombre1;
    private javax.swing.JTextField txt_nombre_cliente;
    private javax.swing.JTextField txt_nombre_cliente_venta;
    private javax.swing.JTextField txt_nombre_producto;
    private javax.swing.JTextField txt_numero_venta;
    private javax.swing.JTextField txt_precio_producto_venta;
    private javax.swing.JTextField txt_precio_unitario;
    private javax.swing.JTextField txt_telefono1;
    private javax.swing.JTextField txt_telefono_cliente;
    private javax.swing.JTextField txt_total_pagar_venta;
    // End of variables declaration//GEN-END:variables

}
