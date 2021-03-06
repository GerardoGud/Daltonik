/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pantallas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.beans.PedidoDetalle;
import modelo.datos.PedidoDetalleDAO;
/**
 *
 * @author LuisCerv
 */
public class PRecepcion extends javax.swing.JPanel {
 private final PedidoDetalleDAO pdao;
    private final String user; 
    private final String pwd;
    private int pagina=0;
    private int noPaginas=0;
    /**
     * Creates new form PRecepcion
     */
    public PRecepcion(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        pdao = new PedidoDetalleDAO(user, pwd);
        noPaginas=pdao.cantPaginas();
        this.tPedido.addKeyListener(new KeyAdapter() {
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

        tPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bCargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDatos = new javax.swing.JTable();
        bGuardar = new javax.swing.JButton();

        tPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPedidoActionPerformed(evt);
            }
        });

        jLabel1.setText("Introduce el id de Pedido que se recibirá:");

        bCargar.setText("Cargar");
        bCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCargarActionPerformed(evt);
            }
        });

        tDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Producto", "cantPedida", "cantRecibida", "cantRechazada", "cantAceptada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tDatos.getTableHeader().setReorderingAllowed(false);
        tDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tDatosMouseExited(evt);
            }
        });
        tDatos.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                tDatosInputMethodTextChanged(evt);
            }
        });
        tDatos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tDatosPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tDatos);
        if (tDatos.getColumnModel().getColumnCount() > 0) {
            tDatos.getColumnModel().getColumn(1).setResizable(false);
            tDatos.getColumnModel().getColumn(2).setResizable(false);
            tDatos.getColumnModel().getColumn(3).setResizable(false);
            tDatos.getColumnModel().getColumn(4).setResizable(false);
            tDatos.getColumnModel().getColumn(5).setResizable(false);
        }

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
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bCargar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bGuardar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(bGuardar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tPedidoActionPerformed

    private void bCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCargarActionPerformed
        if(pdao.estatusPedido(Integer.parseInt(this.tPedido.getText())).equals("P")) {
                cargar();
            } else  if(pdao.estatusPedido(Integer.parseInt(this.tPedido.getText())).equals("R")) {
                JOptionPane.showConfirmDialog(this, "El pedido ya ha sido recibido ","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }else{
                 JOptionPane.showConfirmDialog(this, "El pedido no ha sido liberado","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_bCargarActionPerformed

    private void tDatosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tDatosPropertyChange
        
        
    }//GEN-LAST:event_tDatosPropertyChange

    private void tDatosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDatosMouseExited
        DefaultTableModel modelo=(DefaultTableModel) tDatos.getModel();
        for (int i = 0; i < tDatos.getRowCount(); i++) {
            modelo.setValueAt(modelo.getValueAt(i,1), i, 1);
            modelo.setValueAt(modelo.getValueAt(i,2), i, 2);
            modelo.setValueAt(modelo.getValueAt(i,3), i, 3);
            int n1=Integer.parseInt(String.valueOf(modelo.getValueAt(i,2)));
            int n2=Integer.parseInt(String.valueOf(modelo.getValueAt(i,3)));
            if(n1>=n2){
                modelo.setValueAt(n1-n2, i, 4);
            }else{
                modelo.setValueAt(0, i, 3);
                modelo.setValueAt(modelo.getValueAt(i,2), i, 4);
                JOptionPane.showConfirmDialog(this, "Ingresa un valor menor al de la cantidad pedida", "Error de cantidades", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);           
            }
            modelo.setValueAt(modelo.getValueAt(i,3), i, 5);
            tDatos.setModel(modelo);
        }
    }//GEN-LAST:event_tDatosMouseExited

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        if(pdao.guardarRecepcion((DefaultTableModel) tDatos.getModel())){
             JOptionPane.showConfirmDialog(this, "Se han guardado los datos con exito", "Guardado", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
             pdao.setPedidoRecibido(Integer.parseInt(this.tPedido.getText()));
        }else{
            JOptionPane.showConfirmDialog(this, "Algunos datos no fueron correctamente guardados", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        this.tDatos.setModel(pdao.cargarTablaRecepcion(tDatos,-1));
    }//GEN-LAST:event_bGuardarActionPerformed

    private void tDatosInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tDatosInputMethodTextChanged
        
        
    }//GEN-LAST:event_tDatosInputMethodTextChanged

public void cargar() {
        this.tPedido.setText(this.tPedido.getText().replace(" ", ""));
        if (this.tPedido.getText().equals("")) {
            JOptionPane.showConfirmDialog(this, "Ingresa un valor de busqueda", "Error Id", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
        } else {
            this.tDatos.setModel(pdao.cargarTablaRecepcion(tDatos, Integer.parseInt(this.tPedido.getText())));
            this.repaint();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCargar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tDatos;
    private javax.swing.JTextField tPedido;
    // End of variables declaration//GEN-END:variables
}
