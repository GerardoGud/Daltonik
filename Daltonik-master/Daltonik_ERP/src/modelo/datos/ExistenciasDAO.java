/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.ExistenciasSucursal;

/**
 *
 * @author Nadia Cross
 */
public class ExistenciasDAO {
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public ExistenciasDAO(String user, String pwd){
        cn=new ConnectURL(user, pwd);
        this.user = user;
        this.pwd = pwd;
    }
    
//    public DefaultTableModel cargarTabla(JTable tDatos) {
//        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
//        tabla.setRowCount(0);
//        try {
//            r = cn.consultar("select * from ExistenciasSucursal");
//            while (r.next()) {
//                Vector dato = new Vector();
//                dato.add(r.getInt(1));
//                dato.add(r.getInt(2));
//                dato.add(r.getInt(3));
//                tabla.addRow(dato);
//                tDatos.setModel(tabla);
//            }
//            return tabla;//jTable---jdatos
//        } catch (Exception e) {
//            return null;
//        }
//    }
    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ExistenciasSucursal order by idPresentacion offset ("+reg+"*5) rows fetch next 5 rows only");
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
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from ExistenciasSucursal");
            while (r.next()) {
                p=r.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(p%5==0){
            s=(int)p/5;
            s--;
        }else{
            s=(int)p/5;
        }
        return s;
    }
    public void guardarExistecias(ExistenciasSucursal exis) {
       
        try {
            cn.ejecutar("INSERT INTO ExistenciasSucursal VALUES ("+exis.getIdPresentacion()+",'"+exis.getIdSucursal()
                    +"','"+exis.getCantidad()+"'"+");");
        } catch (Exception e) {
        }
    }
    
    public void editarExistencias(ExistenciasSucursal exis) {
        try {
            cn.ejecutar("update ExistenciasSucursal set idSucursal='"+exis.getIdSucursal()
                    +"',cantidad='"+exis.getCantidad()+"'"+"where idPresentacion="+exis.getIdPresentacion()+";");
        } catch (Exception e) {
        }
    }
    
    public void eliminarExistencias(int id){
        try {
            cn.ejecutar("delete ExistenciasSucursal where idPresentacion="+id+";");
        } catch (Exception e) {
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
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public ExistenciasSucursal buscarIdEdicion(int id) {
        ExistenciasSucursal exS=new ExistenciasSucursal();
        try {
            r = cn.consultar("select * from ExistenciasSucursal where idPresentacion="+id+";");
            while (r.next()) {
                exS.setIdPresentacion(r.getInt(1));
                exS.setIdSucursal(r.getInt(2));
                exS.setCantidad(r.getString(3));                
            }
            return exS;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
}
