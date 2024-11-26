
package FOR_BENJA;
import java.awt.Color;
import MODELO.LOGIN;
import MODELO.LOGINDAO;
import MODELO.CONEXION;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class login_benja extends javax.swing.JFrame {

  
    public login_benja() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

   public void validar() {
       int dni = Integer.parseInt(txt_usuario.getText());
        String pass = String.valueOf(txt_contraseña.getPassword());

        try {
            // Crear una instancia de CONEXION y obtener la conexión
            CONEXION conexionManager = new CONEXION();
            Connection connection = conexionManager.getConnection();

            // Crear una instancia de LOGINDAO y llamar al método log()
            LOGINDAO loginDAO = new LOGINDAO(conexionManager);
            LOGIN user = loginDAO.log(dni, pass);

            // Verificar si el usuario y la contraseña son válidos
            if (user != null && user.getDni() > 0) {
                // Mostrar un mensaje de éxito o realizar alguna otra acción
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                 menu_principal_benja abrir=new menu_principal_benja();
       abrir.setVisible(true);
       this.setVisible(false);
            } else {
                // Mostrar un mensaje de error
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RuntimeException e) {
            // Manejar la excepción de una manera más informativa
             JOptionPane.showMessageDialog(this, "Error al validar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_fondo = new javax.swing.JPanel();
        lbl_imagen_derecha = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        lbl_iniciar = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        separador_contraseña = new javax.swing.JSeparator();
        separador_usuario = new javax.swing.JSeparator();
        txt_usuario = new javax.swing.JTextField();
        txt_contraseña = new javax.swing.JPasswordField();
        panel_fondo_ingresar = new javax.swing.JPanel();
        lbl_ingresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setLocationByPlatform(true);
        setResizable(false);

        panel_fondo.setBackground(new java.awt.Color(255, 255, 255));
        panel_fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_imagen_derecha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMA_BENJA/logo_benja.png"))); // NOI18N
        panel_fondo.add(lbl_imagen_derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 410, 410));

        lbl_contraseña.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbl_contraseña.setText("Contraseña");
        panel_fondo.add(lbl_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 90, 30));

        lbl_iniciar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_iniciar.setText("INICIAR SESIÓN");
        panel_fondo.add(lbl_iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, 50));

        lbl_usuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        lbl_usuario.setText("Usuario");
        panel_fondo.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 50, 30));

        separador_contraseña.setForeground(new java.awt.Color(0, 0, 0));
        panel_fondo.add(separador_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 290, 20));

        separador_usuario.setForeground(new java.awt.Color(0, 0, 0));
        panel_fondo.add(separador_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 290, 10));

        txt_usuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txt_usuario.setForeground(new java.awt.Color(204, 204, 204));
        txt_usuario.setText("Ingrese su nombre de usuario");
        txt_usuario.setBorder(null);
        txt_usuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_usuarioMousePressed(evt);
            }
        });
        panel_fondo.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 220, 20));

        txt_contraseña.setForeground(new java.awt.Color(204, 204, 204));
        txt_contraseña.setText("********");
        txt_contraseña.setBorder(null);
        txt_contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_contraseña.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txt_contraseñaMousePressed(evt);
            }
        });
        panel_fondo.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 290, -1));

        panel_fondo_ingresar.setBackground(new java.awt.Color(0, 0, 0));

        lbl_ingresar.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbl_ingresar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ingresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ingresar.setText("INGRESAR");
        lbl_ingresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ingresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel_fondo_ingresarLayout = new javax.swing.GroupLayout(panel_fondo_ingresar);
        panel_fondo_ingresar.setLayout(panel_fondo_ingresarLayout);
        panel_fondo_ingresarLayout.setHorizontalGroup(
            panel_fondo_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        panel_fondo_ingresarLayout.setVerticalGroup(
            panel_fondo_ingresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_ingresar, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        panel_fondo.add(panel_fondo_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_usuarioMousePressed
        if( txt_usuario.getText().equals("Ingrese su nombre de usuario")){
        txt_usuario.setText("");
    txt_usuario.setForeground(Color.BLACK);
    }
        if(String.valueOf(txt_contraseña.getPassword()).isEmpty()){
    txt_contraseña.setText("********");
    txt_contraseña.setForeground(Color.GRAY);
    }
    }//GEN-LAST:event_txt_usuarioMousePressed

    private void txt_contraseñaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_contraseñaMousePressed
       if(String.valueOf(txt_contraseña.getPassword()).equals("********")){
        txt_contraseña.setText("");
    txt_contraseña.setForeground(Color.BLACK);
    }
       if(txt_usuario.getText().isEmpty()){
    txt_usuario.setText("Ingrese sus contraseña de usuario");
    txt_usuario.setForeground(Color.GRAY);
    }
    }//GEN-LAST:event_txt_contraseñaMousePressed

    private void lbl_ingresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ingresarMouseClicked
       validar();  // Llamada al método validar() que probablemente valida credenciales
      

    
    }//GEN-LAST:event_lbl_ingresarMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(login_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_benja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_benja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_imagen_derecha;
    private javax.swing.JLabel lbl_ingresar;
    private javax.swing.JLabel lbl_iniciar;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel panel_fondo;
    private javax.swing.JPanel panel_fondo_ingresar;
    private javax.swing.JSeparator separador_contraseña;
    private javax.swing.JSeparator separador_usuario;
    private javax.swing.JPasswordField txt_contraseña;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
