/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Medida;
import static modelo.datos.EmpaqueDAO.r;

/**
 *
 * @author Nadia Cross
 */
public class MedidaDAO {
    
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public MedidaDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from UnidadMedida");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public DefaultTableModel buscarId(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from UnidadMedida where idUnidad="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public Medida buscarIdEdicion(int id) {
        Medida me=new Medida();
        try {
            r = cn.consultar("select * from UnidadMedida where idUnidad="+id+";");
            while (r.next()) {
                me.setIdUnidad(r.getInt(1));
                me.setNombre(r.getString(2));
                me.setSiglas(r.getString(3));
                me.setEstatus(r.getString(4));
                
            }
            return me;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarMedida(Medida med) {
        try {
            cn.ejecutar("INSERT INTO UnidadMedida VALUES ("+med.getIdUnidad()+",'"+med.getNombre()
                    +"','"+med.getSiglas()+"','"+med.getEstatus()+"'"+");");
        } catch (Exception e) {
        }
    }
    public void editarMedida(Medida med) {
        try {
            cn.ejecutar("update UnidadMedida set nombre='"+med.getNombre()
                    +"',Siglas='"+med.getSiglas()+"',estatus='"+med.getEstatus()+"'"+"where idUnidad="+med.getIdUnidad()+";");
        } catch (Exception e) {
        }
    }
    public void eliminarMedida(int id){
        try {
            cn.ejecutar("update UnidadMedida set estatus='I' where idUnidad="+id+";");
        } catch (Exception e) {
        }
    }
}
    