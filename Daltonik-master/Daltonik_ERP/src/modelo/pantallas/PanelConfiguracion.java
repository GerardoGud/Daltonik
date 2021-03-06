/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pantallas;

import modelo.utilidades.Archivos;
import daltonik_erp.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author LuisCerv
 */
public class PanelConfiguracion extends javax.swing.JPanel {
    private String nombre;
    private String nomServ;
    private String nPuerto;
    private String contrasena;
    
    /**
     * Creates new form PanelMuestra
     */
    public PanelConfiguracion() {
        
        cargarConfig();
        String con;
        String con1;
        String con2;
        con=JOptionPane.showInputDialog(this, "Introduzca su contraseña de configuracion", "Seguridad", JOptionPane.WARNING_MESSAGE);
        try{
        if(con.equals("")){
            con1=JOptionPane.showInputDialog(this, "Necesita crear una contraseña para proteger\n"
                    + "su configuracion", "Seguridad", JOptionPane.WARNING_MESSAGE);
            con2=JOptionPane.showInputDialog(this, "Confirme la contraseña", "Seguridad", JOptionPane.WARNING_MESSAGE);
            if(con2.equals(con1)){
                contrasena=con1;
                guardarConfig();
            }else{
                JOptionPane.showMessageDialog(this,"Contaseña erronea","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            if(con.equals(contrasena)){
                initComponents();
                mostrarConfig();
            }else{
                JOptionPane.showMessageDialog(this,"Contaseña erronea","Error",JOptionPane.ERROR_MESSAGE);
                this.removeAll();
            }
        }
        }catch(NullPointerException e){
            
        }
    }
    
    private void cargarConfig(){
        Archivos arc = new Archivos();
        arc.setNombre("Configuracion");
        arc.setExtencion(".daltonik");
        arc.setArchivoRuta("C:\\Daltonik\\");
        Scanner n=arc.AbrirArc();
        nombre=n.nextLine();
        nomServ=n.nextLine();
        nPuerto=n.nextLine();
        
        String con1;
        String con2;
        try {
            contrasena=n.nextLine();
        } catch (java.util.NoSuchElementException e) {
            con1=JOptionPane.showInputDialog(this, "Necesita crear una contraseña para proteger\n"
                    + "su configuracion", "Seguridad", JOptionPane.WARNING_MESSAGE);
            con2=JOptionPane.showInputDialog(this, "Confirme la contraseña", "Seguridad", JOptionPane.WARNING_MESSAGE);
            if(con2.equals(con1)){
                contrasena=con1;
                guardarConfig();
            }else{
                JOptionPane.showMessageDialog(this,"Contaseña erronea","Error",JOptionPane.ERROR_MESSAGE);
                
            }
        }
        n.close();
    }
    private void mostrarConfig(){
        System.out.println("nmms");
        this.tPuerto.setText(nPuerto);
        this.tServ.setText(nomServ);
        PanelIMG pimg=new PanelIMG(nombre);
        pimg.setBounds(0, 0, 267, 121);
        this.pImagen.removeAll();
        this.pImagen.add(pimg);
        this.pImagen.repaint();
        this.repaint();
    }
    private void guardarConfig(){
        Archivos arc = new Archivos();
        arc.setNombre("Configuracion");
        arc.setExtencion(".daltonik");
        arc.setArchivoRuta("C:\\Daltonik\\");
        String usu=nombre+"\n"+nomServ+"\n"+nPuerto+"\n"+contrasena;
        arc.GuardarArchivo(usu);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pSeguridad = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        cImagen = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pImagen = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tServ = new javax.swing.JTextField();
        tPuerto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        guardar3 = new javax.swing.JButton();
        contra1 = new javax.swing.JPasswordField();
        contra2 = new javax.swing.JPasswordField();

        cImagen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Imagen 1", "Imagen 2", "Imagen 3", "Imagen 4" }));
        cImagen.setToolTipText("Elige la imagen de tu agrado");
        cImagen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cImagenItemStateChanged(evt);
            }
        });

        jLabel1.setText("Fondo");

        javax.swing.GroupLayout pImagenLayout = new javax.swing.GroupLayout(pImagen);
        pImagen.setLayout(pImagenLayout);
        pImagenLayout.setHorizontalGroup(
            pImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        pImagenLayout.setVerticalGroup(
            pImagenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 121, Short.MAX_VALUE)
        );

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(pImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(pImagen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pSeguridad.addTab("Diseño", jPanel1);

        jLabel2.setText("Nombre del servidor");

        jLabel3.setText("Puerto");

        tServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tServActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tServ, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap(215, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tServ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(tPuerto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pSeguridad.addTab("Conexion", jPanel2);

        jLabel4.setText("Contraseña de seguridad, esta contraseña no cambiará a menos que se ingrese nuevamente aqui");

        jLabel5.setText("Antes de cambiar la contrasena tenga en cuenta que es la misma que utilzan todos los usuarios");

        guardar3.setText("Guardar");
        guardar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardar3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(contra2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contra1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contra1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(contra2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar3)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pSeguridad.addTab("Seguridad", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSeguridad)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pSeguridad)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tServActionPerformed

    private void cImagenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cImagenItemStateChanged
        // TODO add your handling code here:
        int op=cImagen.getSelectedIndex();
        PanelIMG pimg=null;
        switch (op) {
            case 0:
                nombre="15260";
                pimg=new PanelIMG(nombre);
                break;
            case 1:
                nombre="15275";
                pimg=new PanelIMG(nombre);
                break;
            case 2:
                nombre="15281";
                pimg=new PanelIMG(nombre);
                break;
            case 3:
                nombre="15295";
                pimg=new PanelIMG(nombre);
                break;
            default:
                break;
        }
        pimg.setBounds(0, 0, 267, 121);
        this.pImagen.removeAll();
        this.pImagen.add(pimg);
        this.pImagen.repaint();
        this.repaint();
    }//GEN-LAST:event_cImagenItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        guardarConfig();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Archivos arc = new Archivos();
        arc.setNombre("Configuracion");
        arc.setExtencion(".daltonik");
        arc.setArchivoRuta("C:\\Daltonik\\");
        String usu=nombre+"\n"+this.tServ.getText()+"\n"+tPuerto.getText()+"\n"+contrasena;
        arc.GuardarArchivo(usu);
        arc.GuardarArchivo(usu);
            arc = new Archivos("");
            arc.setNombre("Conexion");
            arc.setExtencion(".DConex");
            arc.setArchivoRuta("C:\\Daltonik\\");
            usu="jdbc:sqlserver://"+nomServ+":"+nPuerto+";databaseName=ERP2020";;
            arc.GuardarArchivo(usu);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void guardar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar3ActionPerformed
        if(String.copyValueOf(contra1.getPassword()).equals(String.copyValueOf(contra2.getPassword()))){
            Archivos arc = new Archivos();
            arc.setNombre("Configuracion");
            arc.setExtencion(".daltonik");
            arc.setArchivoRuta("C:\\Daltonik\\");
            String usu=nombre+"\n"+nomServ+"\n"+nPuerto+"\n"+String.copyValueOf(contra2.getPassword());
            
        }
    }//GEN-LAST:event_guardar3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cImagen;
    private javax.swing.JPasswordField contra1;
    private javax.swing.JPasswordField contra2;
    private javax.swing.JButton guardar3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel pImagen;
    private javax.swing.JTabbedPane pSeguridad;
    private javax.swing.JTextField tPuerto;
    private javax.swing.JTextField tServ;
    // End of variables declaration//GEN-END:variables
}
