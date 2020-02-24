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
import modelo.beans.Categorias;

/**
 *
 * @author FranciscoFigueroa
 */
public class CategoriasDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public CategoriasDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Categorias");
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
            r = cn.consultar("select * from Categorias where idCategoria=" + id + ";");
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
public Categorias buscarIdEdicion(int id) {
        Categorias ca=new Categorias();
        try {
            r = cn.consultar("select * from Categorias where idCategoria="+id+";");
            while (r.next()) {
                ca.setIdCategoria(r.getInt(1));
                ca.setNombre(r.getString(2));
                ca.setEstatus(r.getString(3));
            }
            return ca;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public void guardarCategorias(Categorias cat) {
        try {
            cn.ejecutar("INSERT INTO Categorias VALUES (" + cat.getIdCategoria() + ",'" + cat.getNombre()
                    + "','" + cat.getEstatus() + "');");
        } catch (Exception e) {
        }
    }

    public void editarCategorias(Categorias cat, int id) {
        try {
            cn.ejecutar("update categorias set  nombre='" + cat.getNombre()
                    + "',estatus='" + cat.getEstatus() + "' where idCategoria=" + id + ";");
        } catch (Exception e) {
        }
    }

    public void eliminarCategorias(int id) {
        try {
            cn.ejecutar("update categorias set estatus='I' where idCategoria=" + id + ";");
        } catch (Exception e) {
        }
    }
}
