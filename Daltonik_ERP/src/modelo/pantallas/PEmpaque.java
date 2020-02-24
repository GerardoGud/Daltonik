/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pantallas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modelo.datos.EmpaqueDAO;
import modelo.beans.Empaque;

/**
 *
 * @author LuisCerv
 */
public class PEmpaque extends javax.swing.JPanel {
    private EmpaqueDAO edao;
    private Empaque emp;
    private boolean edit;
    private String user; 
    private String pwd;
    
    public PEmpaque(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        edit=false;
        edao=new EmpaqueDAO(user, pwd);
        emp=new Empaque();
        cargar();
        this.tBusqueda.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        this.tUnidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });
        this.tCapacidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE)&& (caracter != '.')) {
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tCapacidad = new javax.swing.JTextField();
        tUnidad = new javax.swing.JTextField();
        chkEstatus = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        bGuardar = new javax.swing.JButton();
        tBusqueda = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tIdEmpaque = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        tCapacidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCapacidadActionPerformed(evt);
            }
        });

        chkEstatus.setText("Activar");
        chkEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstatusActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("idUnidad");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Capacidad:");

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idEmpaque", "Nombre", "Capacidad", "Estatus", "idUnidadMedida"
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
        if (tDatos.getColumnModel().getColumnCount() > 0) {
            tDatos.getColumnModel().getColumn(0).setResizable(false);
            tDatos.getColumnModel().getColumn(1).setResizable(false);
            tDatos.getColumnModel().getColumn(2).setResizable(false);
            tDatos.getColumnModel().getColumn(3).setResizable(false);
            tDatos.getColumnModel().getColumn(4).setResizable(false);
        }

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
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

        jLabel2.setText("idEmpaque");

        tIdEmpaque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdEmpaqueActionPerformed(evt);
            }
        });

        jLabel6.setText("idEmpaque");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chkEstatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bGuardar)
                                        .addGap(222, 222, 222))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(tUnidad, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(tCapacidad, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(tNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                            .addComponent(tIdEmpaque))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(bEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bEliminar))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bBuscar))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBuscar)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bEliminar)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tIdEmpaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(bGuardar)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chkEstatus)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstatusActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        emp=new Empaque();
        emp.setIdEmpaque(Integer.parseInt(this.tIdEmpaque.getText()));
        emp.setCapacidad(Double.parseDouble(this.tCapacidad.getText()));
        emp.setNombre(this.tNombre.getText());
        emp.setIdUnidad(Integer.parseInt(this.tUnidad.getText()));
        if(this.chkEstatus.isSelected()){
            emp.setEstatus("A");
        }else{
            emp.setEstatus("I");
        }
        edao.guardarEmpaque(emp);
        cargar();
        limpiar();
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tCapacidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCapacidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCapacidadActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        edao.eliminarEmpaque(Integer.parseInt(this.tBusqueda.getText()));
        cargar();
        limpiar();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        this.tDatos.setModel(edao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
        limpiar();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        // TODO add your handling code here:
        if(edit) {
            edit=false;
            emp = new Empaque();
            emp.setIdUnidad(Integer.parseInt(this.tBusqueda.getText()));
            emp.setCapacidad(Double.parseDouble(this.tCapacidad.getText()));
            emp.setNombre(this.tNombre.getText());
            emp.setIdUnidad(Integer.parseInt(this.tUnidad.getText()));
            if (this.chkEstatus.isSelected()) {
                emp.setEstatus("A");
            } else {
                emp.setEstatus("I");
            }
            edao.editarEmpaque(emp, emp.getIdEmpaque());
            cargar();
            limpiar();
        }else{
            edit=true;
            this.tDatos.setModel(edao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
            emp = edao.buscarIdEdicion(Integer.parseInt(this.tBusqueda.getText()));
            this.tNombre.setText(emp.getNombre());
            this.tCapacidad.setText(String.valueOf(emp.getCapacidad()));
            this.tUnidad.setText(String.valueOf(emp.getIdUnidad()));
            if (emp.getEstatus().equals("A")) {
                this.chkEstatus.setSelected(true);
            } else {
                this.chkEstatus.setSelected(false);
            }
        }
        this.bBuscar.setVisible(!edit);
        this.bEliminar.setVisible(!edit);
        this.bGuardar.setVisible(!edit);
    }//GEN-LAST:event_bEditarActionPerformed

    private void tIdEmpaqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdEmpaqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdEmpaqueActionPerformed
    public void cargar() {
        this.tDatos.setModel(edao.cargarTabla(tDatos));
    }
    public void limpiar(){
        this.tCapacidad.setText("");
        this.tIdEmpaque.setText("");
        this.tNombre.setText("");
        this.tUnidad.setText("");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JCheckBox chkEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBusqueda;
    private javax.swing.JTextField tCapacidad;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField tIdEmpaque;
    private javax.swing.JTextField tNombre;
    private javax.swing.JTextField tUnidad;
    // End of variables declaration//GEN-END:variables
}
