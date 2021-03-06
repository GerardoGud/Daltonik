/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pantallas;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import modelo.datos.LaboratoriosDAO;
import modelo.beans.Laboratorios;

/**
 *
 * @author Rababau
 */
public class PLaboratorios extends javax.swing.JPanel {
    private LaboratoriosDAO ldao;
    private Laboratorios lab;
    private boolean edit;
    private String user; 
    private String pwd;
    private int pagina=0;
    private int noPaginas=0;
    
    public PLaboratorios(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        ldao=new LaboratoriosDAO(user, pwd);
        lab=new Laboratorios();
        noPaginas=ldao.cantPaginas();
        cargar();
        paginar();
        edit=false;
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
        this.tIdLaboratorio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0')
                        || (caracter > '9'))
                        && (caracter != KeyEvent.VK_BACK_SPACE)) {
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
        tOrigen = new javax.swing.JTextField();
        chkEstatus = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        bGuardar = new javax.swing.JButton();
        tBusqueda = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bEditar = new javax.swing.JButton();
        bEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tIdLaboratorio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        bAtras = new javax.swing.JButton();
        tNumPage = new javax.swing.JLabel();
        bSiguiente = new javax.swing.JButton();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        tOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tOrigenActionPerformed(evt);
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

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Origen:");

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idLaboratorio", "Nombre", "Origen", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        }

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        tBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tBusquedaKeyTyped(evt);
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

        jLabel2.setText("IdLaboratorio");

        tIdLaboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIdLaboratorioActionPerformed(evt);
            }
        });
        tIdLaboratorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tIdLaboratorioKeyTyped(evt);
            }
        });

        jLabel4.setText("IdLaboratorio");

        bAtras.setText("Atras");
        bAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAtrasActionPerformed(evt);
            }
        });

        tNumPage.setText("0");

        bSiguiente.setText("Siguiente");
        bSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSiguienteActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(chkEstatus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bEliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tIdLaboratorio, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tOrigen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(tNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                    .addComponent(bGuardar))
                                .addGap(18, 67, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bBuscar))
                                    .addComponent(bEditar, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tNumPage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSiguiente)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tIdLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(bBuscar)
                    .addComponent(tBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(bEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkEstatus)
                    .addComponent(bEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tNumPage)
                    .addComponent(bSiguiente)
                    .addComponent(bAtras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEstatusActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        lab=new Laboratorios();
        if(this.tIdLaboratorio.getText().length() == 0 || this.tNombre.getText().length() == 0 || this.tOrigen.getText().length() == 0 ){
            JOptionPane.showMessageDialog(tNombre, "No puede haber campos vacios");
        }
        else{
            lab.setIdLaboratorio(Integer.parseInt(this.tIdLaboratorio.getText()));
            lab.setNombre(this.tNombre.getText());
            lab.setOrigen(this.tOrigen.getText());
            if(this.chkEstatus.isSelected()){
                lab.setEstatus("A");
            }else{
                lab.setEstatus("I");
            }
            ldao.guardarLaboratorio(lab);
            noPaginas=ldao.cantPaginas();
            cargar();
            paginar();
            limpiar();
        }
        
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tOrigenActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed
        // TODO add your handling code here:
        this.tDatos.setModel(ldao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
        limpiar();
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditarActionPerformed
        // TODO add your handling code here:
        if(edit) {
            edit=false;
            lab = new Laboratorios();
            lab.setIdLaboratorio(Integer.parseInt(this.tBusqueda.getText()));
            lab.setOrigen(this.tOrigen.getText());
            lab.setNombre(this.tNombre.getText());
            if (this.chkEstatus.isSelected()) {
                lab.setEstatus("A");
            } else {
                lab.setEstatus("I");
            }
            ldao.editarLaboratorio(lab, lab.getIdLaboratorio());
            cargar();
            limpiar();
        }else{
            edit=true;
            this.tDatos.setModel(ldao.buscarId(tDatos, Integer.parseInt(this.tBusqueda.getText())));
            lab = ldao.buscarIdEdicion(Integer.parseInt(this.tBusqueda.getText()));
            this.tNombre.setText(lab.getNombre());
            this.tOrigen.setText(lab.getOrigen());
            if (lab.getEstatus().equals("A")) {
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
       ldao.eliminarLaboratorio(Integer.parseInt(this.tBusqueda.getText()));
       this.tDatos.setModel(ldao.cargarTabla(tDatos, pagina));
       noPaginas=ldao.cantPaginas();
        paginar();
        limpiar();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void tIdLaboratorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIdLaboratorioKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(tNombre, "Caracter no valido");
        }
    }//GEN-LAST:event_tIdLaboratorioKeyTyped

    private void tBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tBusquedaKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
            
            JOptionPane.showMessageDialog(tNombre, "Caracter no valido");
        }
    }//GEN-LAST:event_tBusquedaKeyTyped

    private void tIdLaboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIdLaboratorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIdLaboratorioActionPerformed

    private void bAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAtrasActionPerformed
        // TODO add your handling code here:
        if(pagina>0)pagina--;
        paginar();
        cargar();
    }//GEN-LAST:event_bAtrasActionPerformed

    private void bSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSiguienteActionPerformed
        // TODO add your handling code here:
        if(pagina<noPaginas)pagina++;
        paginar();
        cargar();
    }//GEN-LAST:event_bSiguienteActionPerformed
    public void cargar() {
        this.tDatos.setModel(ldao.cargarTabla(tDatos, pagina));
    }
    public void limpiar(){
        this.tOrigen.setText("");
        this.tNombre.setText("");
        this.tIdLaboratorio.setText("");
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

    public void datoTabla(){
        
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tBusqueda;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField tIdLaboratorio;
    private javax.swing.JTextField tNombre;
    private javax.swing.JLabel tNumPage;
    private javax.swing.JTextField tOrigen;
    // End of variables declaration//GEN-END:variables
}
