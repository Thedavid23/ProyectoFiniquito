package ProyectoIntroProgra;

import javax.swing.JOptionPane;
import ProyectoIntroProgra.Usuario;
public class Ventana_Inicio_Sesion extends javax.swing.JFrame {

    public Ventana_Inicio_Sesion() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        InciarSesion = new javax.swing.JButton();
        RegiUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sistema de Parqueos del Oeste");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("")));

        InciarSesion.setText("Iniciar Sesion");
        InciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InciarSesionActionPerformed(evt);
            }
        });

        RegiUsuario.setText("Registrarse");
        RegiUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegiUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RegiUsuario)
                    .addComponent(InciarSesion))
                .addGap(0, 305, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(InciarSesion)
                .addGap(29, 29, 29)
                .addComponent(RegiUsuario)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InciarSesionActionPerformed

    // Obtener la lista de usuarios
    Usuario[] usuarios = UsuarioManager.getUsuarios();

    // Iniciar sesión
    Usuario usuarioSesion = Inicio_Sesion.IniciarSesion(usuarios);

    // Verificar si el inicio de sesión fue exitoso
    if (usuarioSesion != null) {
        // Verificar el tipo de usuario
        if (usuarioSesion.getTipoUsuario() == TipoUsuario.CLIENTE) {
            // Usuario es cliente, abrir VentanaPrincipal
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);
        } else if (usuarioSesion.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
            // Usuario es administrador, abrir VentanaAdministrador
            VentanaAdministrador ventanaAdministrador = new VentanaAdministrador();
            ventanaAdministrador.setVisible(true);
        }
        // Cerrar la ventana actual
        dispose();
    } else {
        // Mostrar mensaje de error si el inicio de sesión no fue exitoso
        JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos. Inténtelo nuevamente.",
                "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_InciarSesionActionPerformed

    private void RegiUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegiUsuarioActionPerformed
UsuarioManager.agregarUsuarios();
 UsuarioManager.mostrarInformacionUsuarios();
    }//GEN-LAST:event_RegiUsuarioActionPerformed


    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(Ventana_Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inicio_Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inicio_Sesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton InciarSesion;
    private javax.swing.JButton RegiUsuario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
