/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Empaque;
import modelo.beans.PresentacionesProducto;
import static modelo.datos.EmpaqueDAO.r;

/**
 *
 * @author Francisco Figueroa
 */
public class PresentacionesProductoDAO {

    static ResultSet r;
    ConnectURL cn;
    private final String user;
    private final String pwd;

    public PresentacionesProductoDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from PresentacionesProducto");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getFloat(2));
                dato.add(r.getFloat(3));
                dato.add(r.getFloat(4));
                dato.add(r.getInt(5));
                dato.add(r.getInt(6));
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
            r = cn.consultar("select * from PresentacionesProducto where idPresentacion=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getFloat(2));
                dato.add(r.getFloat(3));
                dato.add(r.getFloat(4));
                dato.add(r.getInt(5));
                dato.add(r.getInt(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public PresentacionesProducto buscarIdEdicion(int id) {
        PresentacionesProducto pr = new PresentacionesProducto();
        try {
            r = cn.consultar("select * from PresentacionesProducto where idPresentacion=" + id + ";");
            while (r.next()) {
                pr.setIdPresentacion(r.getInt(1));
                pr.setPrecioCompra(r.getFloat(2));
                pr.setPrecioVenta(r.getFloat(3));
                pr.setPuntoReorden(r.getFloat(4));
                pr.setIdProducto(r.getInt(5));
                pr.setIdEmpaque(r.getInt(6));
            }
            return pr;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarPresentacionesProducto(PresentacionesProducto pr) {
        try {
            cn.ejecutar("INSERT INTO PresentacionesProducto VALUES (" + pr.getIdPresentacion() + ",'" + pr.getPrecioCompra()
                    + "'," + pr.getPrecioVenta() + ",'" + pr.getPuntoReorden() + "'," + pr.getIdProducto() + "'," + pr.getIdEmpaque() + ");");
        } catch (Exception e) {
        }
    }

    public void editarPresentacionesProducto(PresentacionesProducto pr, int id) {
        try {
            cn.ejecutar("update PresentacionesProducto set puntoReorden=" + pr.getPuntoReorden() + ", precioCompra='" + pr.getPrecioCompra()
                    + "',precioVenta='" + pr.getPrecioVenta() + "', idProducto=" + pr.getIdProducto() + "',idEmpaque='" + pr.getIdEmpaque() + " where idPresentacion=" + id + ";");
        } catch (Exception e) {
        }
    }

    public void eliminarPresentacionesProducto(int id) {
        try {
            cn.ejecutar("update PresentacionesProducto set estatus='I' where idPresentacion=" + id + ";");
        } catch (Exception e) {
        }
    }
}
