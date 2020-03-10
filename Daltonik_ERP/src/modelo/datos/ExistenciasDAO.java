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
import modelo.beans.ExistenciasSucursal;
import static modelo.datos.EmpaqueDAO.r;

/**
 *
 * @author Nadia Cross
 */
public class ExistenciasDAO {
    static ResultSet cts;
    ConnectURL cn;
    
    public ExistenciasDAO(){
        cn=new ConnectURL();
    }
    
    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ExistenciasSucursal");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getInt(3));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
    public void guardarExistecias(ExistenciasSucursal exis) {
       
        try {
            cn.ejecutar("INSERT INTO ExistenciasSucursal VALUES ("+exis.getIdPresentacion()+",'"+exis.getIdSucursal()
                    +"','"+exis.getCantidad()+"','"+exis.getEstatus()+"'"+");");
        } catch (Exception e) {
        }
    }
    
    public void editarExistencias(ExistenciasSucursal exis) {
        try {
            cn.ejecutar("update ExistenciasSucursal set idSucursal='"+exis.getIdSucursal()
                    +"',cantidad='"+exis.getCantidad()+"',estatus='"+exis.getEstatus()+"'"+"where idUnidad="+exis.getIdPresentacion()+";");
        } catch (Exception e) {
        }
    }
    
    public void eliminarExistencias(int id){
        try {
            cn.ejecutar("update ExistenciasSucursal set estatus='I' where idPrensentacion="+id+";");
        } catch (Exception e) {
        }
    }
    
    public ExistenciasSucursal buscarIdEdicion(int id) {
        ExistenciasSucursal exS=new ExistenciasSucursal();
        try {
            r = cn.consultar("select * from ExistenciasSucursal where idPrensentacion="+id+";");
            while (r.next()) {
                exS.setIdPresentacion(r.getInt(1));
                exS.setIdSucursal(r.getInt(2));
                exS.setCantidad(r.getString(3));
                exS.setEstatus(r.getString(4));
                
            }
            return exS;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel buscarId(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ExistenciasSucursal where idPresentacion="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
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
    
}
