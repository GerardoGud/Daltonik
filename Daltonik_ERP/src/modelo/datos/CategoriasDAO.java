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
import modelo.beans.Laboratorios;

/**
 *
 * @author Francisco Figueroa
 */
public class CategoriasDAO {

    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;

    public CategoriasDAO() {
        cn = new ConnectURL();
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

    public void guardarCategorias(Categorias cat) {
        try {
            cn.ejecutar("INSERT INTO Categorias VALUES (" + cat.getIdCategoria() + ",'" + cat.getNombre()
                    + "'," + cat.getEstatus() + ");");
        } catch (Exception e) {
        }
    }
}
