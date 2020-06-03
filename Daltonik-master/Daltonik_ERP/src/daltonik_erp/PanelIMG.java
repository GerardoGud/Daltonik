/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonik_erp;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author LuisCerv
 */
public class PanelIMG extends javax.swing.JPanel {

    /**
     * Creates new form PanelIMG
     */
    private String nombre="15275";
    private ImageIcon icon;
    private boolean bnd;
    public PanelIMG() {
        initComponents();
        icon=null;
        bnd=false;
    }
    public PanelIMG(String n) {
        initComponents();
        nombre=n;
        icon=null;
        bnd=true;
    }
    public PanelIMG(ImageIcon ico) {
        initComponents();
        icon=ico;
    }
    public void paint(Graphics g){
        Dimension dim=this.getSize();
        if (icon == null) {
            if (bnd) {
                icon = new javax.swing.ImageIcon(getClass().getResource("/iconos/" + nombre + ".jpg"));
            } else {
                icon = new javax.swing.ImageIcon(getClass().getResource("/iconos/15275.jpg"));
            }
        }
    g.drawImage(icon.getImage(), 0, 0, dim.width,dim.height,null);
    this.setOpaque(false);
    super.paintChildren(g);
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
