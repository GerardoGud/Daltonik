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
import modelo.beans.TipoUsuario;

/**
 *
 * @author LuisCerv
 */
public class TipoUsuarioDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public TipoUsuarioDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from TipoUsuario");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
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
            r = cn.consultar("select * from TipoUsuario where idTipoUsuario=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
public TipoUsuario buscarIdEdicion(int id) {
        TipoUsuario tu=new TipoUsuario();
        try {
            r = cn.consultar("select * from TipoUsuario where idTipoUsuario="+id+";");
            while (r.next()) {
                tu.setIdTipoUsuario(r.getInt(1));
                tu.setNombre(r.getString(2));
                tu.setEstatus(r.getString(3));
            }
            return tu;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public void guardarTipoUsuario(TipoUsuario tu) {
        try {
            cn.ejecutar("INSERT INTO TipoUsuario VALUES (" + tu.getIdTipoUsuario() + ",'" + tu.getNombre()
                    + "','" + tu.getEstatus() + "');");
        } catch (Exception e) {
        }
    }

    public void editarTipoUsuario(TipoUsuario tu, int id) {
        try {
            cn.ejecutar("update TipoUsuario set  nombre='" + tu.getNombre()
                    + "',estatus='" + tu.getEstatus() + "' where idTipoUsuario=" + id + ";");
        } catch (Exception e) {
        }
    }

    public void eliminarTipoUsuario(int id) {
        try {
            cn.ejecutar("update TipoUsuario set estatus='I' where idTipoUsuario=" + id + ";");
        } catch (Exception e) {
        }
    }
}
