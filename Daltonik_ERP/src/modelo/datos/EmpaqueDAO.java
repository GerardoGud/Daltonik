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
import modelo.beans.Empaque;
/**
 *
 * @author LuisCerv
 */
public class EmpaqueDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;

    public EmpaqueDAO() {
        cn=new ConnectURL();
    }
    
    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Empaques");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getDouble(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel buscarId(JTable tDatos,int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Empaques where idEmpaque="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getDouble(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public void guardarEmpaque(Empaque emp){
        try {
            cn.ejecutar("INSERT INTO Empaques VALUES ("+emp.getIdEmpaque()+",'"+emp.getNombre()
                    +"',"+emp.getCapacidad()+",'"+emp.getEstatus()+"',"+emp.getIdUnidad()+");");
        } catch (Exception e) {
        }
    }
    public void editarEmpaque(Empaque emp,int id){
        try {
            cn.ejecutar("update empaques set capacidad="+emp.getCapacidad()+", nombre='"+emp.getNombre()
                    +"',estatus='"+emp.getEstatus()+"', idUnidad="+emp.getIdUnidad()+" where idEmpaque="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarEmpaque(int id){
        try {
            cn.ejecutar("update empaques set estatus='I' where idEmpaque="+id+";");
        } catch (Exception e) {
        }
    }
    
    
}
