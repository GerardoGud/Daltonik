/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tplate file, choose Tools | Tplates
 * and open the tplate in the editor.
 */
package modelo.pantallas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.beans.CuentasProveedor;
import modelo.beans.DProveedor;
import modelo.datos.CuentasProveedorDAO;

/**
 *
 * @author Francisco Figueroa
 */
public class PCuentasProveedor extends javax.swing.JPanel {

    private final CuentasProveedorDAO cpdao;
    private CuentasProveedor cp;
    private boolean edit;
    private final String user;
    private final String pwd;
    private int pagina = 0;
    private int noPaginas = 0;
    private int idCuentaProveedor = 0;
    private int idProveedor = 0;
    private int proSelected = 0;
    private int CuentaPr = 0;
    ArrayList<DProveedor> reg;

    /**
     * Creates new form PPedidos
     */
    public PCuentasProveedor(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        cpdao = new CuentasProveedorDAO(user, pwd);
        cp = new CuentasProveedor();
        noPaginas = cpdao.cantPaginas();
        cargar();
        paginar();
        edit = false;

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
        this.tnoCuenta.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE) && (caracter != '-')) {
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

        bEliminar = new javax.swing.JButton();
        chkEstatus = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        tnoCuenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tNumPage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        bSiguiente = new javax.swing.JButton();
        bAtras = new javax.swing.JButton();
        tBusqueda = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bBuscar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        tBanco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cProveedor = new javax.swing.JComboBox<>();
        bGuardar = new javax.swing.JButton();

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        chkEstatus.setText("Activar");
        chkEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEstatusActionPerformed(evt);
            }
        });

        jLabel2.setText("idCuentaProveedor");

        tnoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnoCuentaActionPerformed(evt);
            }
        });

        jLabel6.setText("noCuenta");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("idProveedor");

        tNumPage.setText("0");

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idCuentaProveedor", "idProveedor", "noCuenta", "Banco", "Estatus"
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

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

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

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Banco");

        cProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cProveedor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cProveedorItemStateChanged(evt);
            }
        });
        cProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProveedorActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bGuardar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tnoCuenta))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cProveedor, 0, 157, Short.MAX_VALUE)
                                .addComponent(tBanco)))))
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(bBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNumPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bSiguiente)
                        .addGap(170, 170, 170))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkEstatus)
                            .addComponent(bEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bEliminar))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(bBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(bEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkEstatus)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNumPage)
                    .addComponent(bSiguiente)
                    .addComponent(bAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(this, "Estas seguro de que deseas borrar este registro?", "Alerta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            cpdao.eliminarCuentasProveedor(Integer.parseInt(this.tBusqueda.getText()));
            noPaginas = cpdao.cantPaginas();
        }
        cargar();
        paginar();
        limpiar();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void chkEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstatusActionPerformed

    private void tnoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnoCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnoCuentaActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if (pagina < noPaginas) {
            pagina++;
        }
        paginar();
        cargar();
    }//GEN-LAST:event_bSiguienteActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        // TODO add your handling code here:
        if (pagina > 0) {
            pagina--;
        }
        paginar();
        cargar();
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        if(!this.tBusqueda.getText().equals("")){
            this.tDatos.setModel(cpdao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
        }else{
             JOptionPane.showConfirmDialog(this, "necesita introducir el id del pedido para realizar la busqueda", "error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        }
        limpiar();
        
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        // TODO add your handling code here:
        if (edit) {
                edit = false;
                this.tBusqueda.setEnabled(!edit);
                cp = new CuentasProveedor();
                idCuentaProveedor = cpdao.UltimoIDCuenta();
                idProveedor = reg.get(proSelected).getIdProveedor();
                cp.setIdCuentaProveedor(CuentaPr);
                cp.setIdProveedor(reg.get(proSelected).getIdProveedor());
                cp.setNoCuenta(this.tnoCuenta.getText());
                cp.setBanco(this.tBanco.getText());
                if (this.chkEstatus.isSelected()) {
                    cp.setEstatus("A");
                } else {
                    cp.setEstatus("I");
                }
                cpdao.editarCuentasProveedor(cp, cp.getIdCuentaProveedor());
                cargar();
                limpiar();
            }else{
            if(!this.tBusqueda.getText().equals("")){
                edit=true;
                 cp = cpdao.buscarIdEdicion(Integer.parseInt(this.tBusqueda.getText()));
                 this.tnoCuenta.setText(cp.getNoCuenta());
                 
                this.cProveedor.setSelectedItem(reg.indexOf(cp.getIdProveedor()));
                CuentaPr=cp.getIdCuentaProveedor();
                 this.tBanco.setText(cp.getBanco());
                 this.tDatos.setModel(cpdao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
            }else{
              JOptionPane.showConfirmDialog(this, "necesita introducir el id del pedido para realizar la busqueda", "error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

            }
                
        }
    }//GEN-LAST:event_bEditarActionPerformed

    private void cProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cProveedorActionPerformed

    private void cProveedorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cProveedorItemStateChanged
        // TODO add your handling code here:
        proSelected = this.cProveedor.getSelectedIndex();

    }//GEN-LAST:event_cProveedorItemStateChanged

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        cp=new CuentasProveedor();
        if(  this.tnoCuenta.getText().length() == 0 ){
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios");
        }else{
            cp.setIdCuentaProveedor(cpdao.UltimoIDCuenta());
            cp.setIdProveedor(reg.get(proSelected).getIdProveedor());
            cp.setNoCuenta(this.tnoCuenta.getText());
            cp.setBanco(this.tBanco.getText());
            if(this.chkEstatus.isSelected()){
                cp.setEstatus("A");
            }else{
                cp.setEstatus("I");
            }
            cpdao.guardarCuentasProveedor(cp);
            noPaginas=cpdao.cantPaginas();
            cargar();
            paginar();
            limpiar();
        }

    }//GEN-LAST:event_bGuardarActionPerformed
    private int buscarPr(int id) {
        int idx = -1;
        for (int i = 0; i < reg.size(); i++) {
            if (reg.get(i).getIdProveedor() == id) {
                return i;
            }
        }
        return idx;
    }

    public void cargar() {
        this.tDatos.setModel(cpdao.cargarTabla(tDatos, pagina));
        reg = new ArrayList();
        reg = cpdao.buscarProveedores();
        cProveedor.removeAllItems();
        for (int i = 0; i < reg.size(); i++) {
            this.cProveedor.addItem(reg.get(i).getNombre());
        }
        this.repaint();
    }

    public void paginar() {
        if (pagina == 0) {
            this.bAtras.setVisible(false);
        } else {
            this.bAtras.setVisible(true);
        }
        if (pagina < noPaginas) {
            this.bSiguiente.setVisible(true);
        } else {
            this.bSiguiente.setVisible(false);
        }
        this.tNumPage.setText((pagina + 1) + " de " + (noPaginas + 1));
    }

    public void limpiar() {
        this.tBusqueda.setText("");
        this.tnoCuenta.setText("");
        this.tBanco.setText("");
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAtras;
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bEditar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSiguiente;
    private javax.swing.JComboBox<String> cProveedor;
    private javax.swing.JCheckBox chkEstatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBanco;
    private javax.swing.JTextField tBusqueda;
    private javax.swing.JTable tDatos;
    private javax.swing.JLabel tNumPage;
    private javax.swing.JTextField tnoCuenta;
    // End of variables declaration//GEN-END:variables
}
