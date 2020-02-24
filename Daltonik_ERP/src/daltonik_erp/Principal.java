/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonik_erp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import modelo.pantallas.PCategorias;
import modelo.pantallas.PEmpaque;
import modelo.pantallas.PLaboratorios;
import modelo.pantallas.PMedida;
import modelo.pantallas.PTiposUsuario;
import modelo.pantallas.PUsuario;

/**
 *
 * @author LuisCerv
 */
public class Principal extends javax.swing.JFrame{
    private String user; 
    private String pwd;
    private Date date;
    private String fecha;
    private String hora;
    
    public Principal(String user, String pwd) {
        initComponents();
        this.user = user;
        this.pwd = pwd;
        this.lUsuario.setText("Sesion activa: "+user);
        //FECHA DEL SISTEMA
        Date sistFecha=new Date();
        SimpleDateFormat formato=new SimpleDateFormat("dd MMMMM YYYY");
        fecha=formato.format(sistFecha);
        //HORA DEL SISTEMA
        Timer tiempo=new Timer(100, new Principal.horas());
        tiempo.start();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
    }
    class horas implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Date sistHora = new Date();
            String pmAm = "hh:mm:ss a";
            SimpleDateFormat format = new SimpleDateFormat(pmAm);
            Calendar hoy = Calendar.getInstance();
            hora = String.format(format.format(sistHora), hoy);
            lHyF.setText(fecha + "  \t  " + hora);
        }
    }
    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
//        Salir();
        System.out.println("cerrado");
    }                                 

    private void formWindowClosing(java.awt.event.WindowEvent evt) {                                   
        Salir();
        System.out.println("saliendo");
    }
    public void Salir(){
        int op=JOptionPane.showConfirmDialog(this, "Esta seguro de que desea salir,\n"
                + "si tiene algun avance este podria perderse!","Salir",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION){
            this.dispose();
            System.exit(0);
        }
    }
    public void CerrarSesion(){
        int op=JOptionPane.showConfirmDialog(this, user+" esta seguro de que desea cerrar sesion,\n"
                + "si tiene algun avance este podria perderse!","Cerrar sesion :"+user,
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(op==JOptionPane.YES_OPTION){
            Login lg= new Login();
            lg.setVisible(true);
            this.dispose();
        }
    }
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        Pantallas = new javax.swing.JTabbedPane();
        lUsuario = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        lHyF = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mSesion = new javax.swing.JMenuItem();
        mTipoUsu = new javax.swing.JMenuItem();
        mUsu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mCategorias = new javax.swing.JMenuItem();
        mMedidas = new javax.swing.JMenuItem();
        mEmpaques = new javax.swing.JMenuItem();
        mLaboratorios = new javax.swing.JMenuItem();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lUsuario.setText("Sesion activa: ");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/closeWindow.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/next.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/back.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jMenu1.setText("Sesion");

        mSesion.setText("Cerrar Sesion");
        mSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSesionActionPerformed(evt);
            }
        });
        jMenu1.add(mSesion);

        mTipoUsu.setText("Registrar tipo usuario");
        mTipoUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTipoUsuActionPerformed(evt);
            }
        });
        jMenu1.add(mTipoUsu);

        mUsu.setText("Registrar usuario");
        mUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mUsuActionPerformed(evt);
            }
        });
        jMenu1.add(mUsu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Compras x");

        mCategorias.setText("Categorias");
        mCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCategoriasActionPerformed(evt);
            }
        });
        jMenu2.add(mCategorias);

        mMedidas.setText("UnidadMedida");
        mMedidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mMedidasActionPerformed(evt);
            }
        });
        jMenu2.add(mMedidas);

        mEmpaques.setText("Empaques");
        mEmpaques.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mEmpaquesActionPerformed(evt);
            }
        });
        jMenu2.add(mEmpaques);

        mLaboratorios.setText("Laboratorios");
        mLaboratorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mLaboratoriosActionPerformed(evt);
            }
        });
        jMenu2.add(mLaboratorios);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lHyF, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pantallas, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pantallas)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lUsuario)
                    .addComponent(lHyF, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCategoriasActionPerformed
       PCategorias pe=new PCategorias (user,pwd);
        this.Pantallas.add("Categorias ",pe);
    }//GEN-LAST:event_mCategoriasActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(this.Pantallas.getComponentCount()>0){
           int p=Pantallas.getSelectedIndex();
           this.Pantallas.remove(p);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int limit=this.Pantallas.getComponentCount();
        int sel=this.Pantallas.getSelectedIndex();
        if(limit>0){
            if(sel<limit-1){
                this.Pantallas.setSelectedIndex(sel+1);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int limit=this.Pantallas.getComponentCount();
        int sel=this.Pantallas.getSelectedIndex();
        if(limit>0){
            if(sel>0){
                this.Pantallas.setSelectedIndex(sel-1);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void mEmpaquesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mEmpaquesActionPerformed
        // TODO add your handling code here:
        PEmpaque pe=new PEmpaque (user,pwd);
        this.Pantallas.add("Empaques",pe);
        
    }//GEN-LAST:event_mEmpaquesActionPerformed

    private void mMedidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mMedidasActionPerformed
        PMedida pm=new PMedida (user,pwd);
        this.Pantallas.add("Medidas",pm);
    }//GEN-LAST:event_mMedidasActionPerformed

    private void mLaboratoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mLaboratoriosActionPerformed
        // TODO add your handling code here:
        PLaboratorios pe=new PLaboratorios (user,pwd);
        this.Pantallas.add("Laboratorios",pe);
    }//GEN-LAST:event_mLaboratoriosActionPerformed

    private void mSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSesionActionPerformed
        CerrarSesion();
    }//GEN-LAST:event_mSesionActionPerformed

    private void mTipoUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTipoUsuActionPerformed
        PTiposUsuario ptu=new PTiposUsuario (user,pwd);
        this.Pantallas.add("Tipos de usuario",ptu);
    }//GEN-LAST:event_mTipoUsuActionPerformed

    private void mUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mUsuActionPerformed
        PUsuario pu=new PUsuario (user,pwd);
        this.Pantallas.add("Empaques",pu);
    }//GEN-LAST:event_mUsuActionPerformed

    /**
     * @param args the command line arguments
     */
    public  void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Pantallas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lHyF;
    private javax.swing.JLabel lUsuario;
    private javax.swing.JMenuItem mCategorias;
    private javax.swing.JMenuItem mEmpaques;
    private javax.swing.JMenuItem mLaboratorios;
    private javax.swing.JMenuItem mMedidas;
    private javax.swing.JMenuItem mSesion;
    private javax.swing.JMenuItem mTipoUsu;
    private javax.swing.JMenuItem mUsu;
    // End of variables declaration//GEN-END:variables

    
}
