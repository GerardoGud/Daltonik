/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pantallas;

import modelo.beans.Usuario;
import modelo.datos.UsuarioDAO;

/**
 *
 * @author LuisCerv
 */
public class PUsuario extends javax.swing.JPanel {

    /**
     * Creates new form PTiposUsuario
     */
    private final UsuarioDAO udao;
    private Usuario u;
    private boolean edit;
    private final String user; 
    private final String pwd;
    private int pagina=0;
    private int noPaginas=0;
    /**
     * Creates new form PCategorias
     * @param user
     * @param pwd
     */
    public PUsuario(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        udao = new UsuarioDAO(user, pwd);
        u = new Usuario();
        noPaginas=udao.cantPaginas();
        cargar();
        paginar();
        edit = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        bGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tIdEmpleado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        chkEstatus = new javax.swing.JCheckBox();
        tidTipoUsuario = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        tNombre = new javax.swing.JTextField();
        tContrasena = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tNumPage = new javax.swing.JLabel();
        bSiguiente = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nombre", "Contrasena", "estatus", "idEmpleado", "idTipoUsuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tDatos);

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        jLabel2.setText("idEmpleado");

        jLabel1.setText("Tipo de usuario");

        chkEstatus.setText("Estatus");

        tidTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidTipoUsuarioActionPerformed(evt);
            }
        });

        bBuscar.setText("Buscar");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        bEditar.setText("Editar");
        bEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditarActionPerformed(evt);
            }
        });

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        tContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tContrasenaActionPerformed(evt);
            }
        });

        jLabel3.setText("Nombre");

        jLabel4.setText("Contrasena");

        tNumPage.setText("0");

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

        bAtras.setText("Atras");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tidTipoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                                .addComponent(tIdEmpleado)
                                .addComponent(tNombre)
                                .addComponent(tContrasena))
                            .addComponent(chkEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(129, 129, 129)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEliminar)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNumPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSiguiente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(tIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bBuscar)
                            .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tidTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkEstatus)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNumPage)
                    .addComponent(bSiguiente)
                    .addComponent(bAtras))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        u = new Usuario();
        u.setNombre(this.tNombre.getText());
        u.setContrasena(this.tContrasena.getText());
        u.setIdEmpleado(Integer.parseInt(this.tIdEmpleado.getText()));
        u.setIdTipoUsuario(Integer.parseInt(this.tidTipoUsuario.getText()));
        if (this.chkEstatus.isSelected()) {
            u.setEstatus("A");
        } else {
            u.setEstatus("I");
        }
        udao.guardarUsuario(u);
        cargar();
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tidTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidTipoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidTipoUsuarioActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        this.tDatos.setModel(udao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        // TODO add your handling code here:
        if (edit) {
            edit=false;
            u = new Usuario();
            u.setNombre(this.tNombre.getText());
            u.setContrasena(this.tContrasena.getText());
            u.setIdEmpleado(Integer.parseInt(this.tIdEmpleado.getText()));
            u.setIdTipoUsuario(Integer.parseInt(this.tidTipoUsuario.getText()));
            if (this.chkEstatus.isSelected()) {
                u.setEstatus("A");
            } else {
                u.setEstatus("I");
            }
            udao.editarUsuario(u, u.getIdTipoUsuario());
            cargar();
        } else {
            edit = true;
            this.tDatos.setModel(udao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
            u = udao.buscarIdEdicion(Integer.parseInt(this.tBusqueda.getText()));
            this.tNombre.setText(u.getNombre());
            this.tContrasena.setText(u.getContrasena());
            this.tidTipoUsuario.setText(String.valueOf(u.getIdTipoUsuario()));
            this.tIdEmpleado.setText(String.valueOf(u.getIdEmpleado()));
            if (u.getEstatus().equals("A")) {
                this.chkEstatus.setSelected(true);
            } else {
                this.chkEstatus.setSelected(false);
            }
        }
        this.bBuscar.setVisible(!edit);
        this.bEliminar.setVisible(!edit);
        this.bGuardar.setVisible(!edit);
    }//GEN-LAST:event_bEditarActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        udao.eliminarUsuario(Integer.parseInt(this.tBusqueda.getText()));
        cargar();
        Limpiar();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void tContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tContrasenaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tContrasenaActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if(pagina<noPaginas)pagina++;
        paginar();
        cargar();
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        // TODO add your handling code here:
        if(pagina>0)pagina--;
        paginar();
        cargar();
    }//GEN-LAST:event_bAtrasActionPerformed
    public void cargar() {
        this.tDatos.setModel(udao.cargarTabla(tDatos,pagina));
    }
    
    public void paginar(){
        if(pagina==0){
            this.bAtras.setVisible(false);
        }else{
            this.bAtras.setVisible(true);
        }
        if(pagina<noPaginas){
            this.bSiguiente.setVisible(true);
        }else{
            this.bSiguiente.setVisible(false);
        }
        this.tNumPage.setText((pagina+1)+" de "+(noPaginas+1));
    }
    
    public void Limpiar() {
        this.tNombre.setText("");
            this.tContrasena.setText("");
            this.tidTipoUsuario.setText("");
            this.tIdEmpleado.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JCheckBox chkEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBusqueda;
    private javax.swing.JTextField tContrasena;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField tIdEmpleado;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel tNumPage;
    private javax.swing.JTextField tidTipoUsuario;
    // End of variables declaration//GEN-END:variables
}
