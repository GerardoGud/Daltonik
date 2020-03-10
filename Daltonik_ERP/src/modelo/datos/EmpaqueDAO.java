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
import modelo.beans.Empaque;
/**
 *
 * @author LuisCerv
 */
public class EmpaqueDAO {
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public EmpaqueDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public DefaultTableModel cargarTabla(JTable tDatos,int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Empaques where estatus='A' order by idEmpaque offset ("+reg+"*5) rows fetch next 5 rows only");
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
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Empaques where estatus='A'");
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
    public Empaque buscarIdEdicion(int id) {
        Empaque em=new Empaque();
        try {
            r = cn.consultar("select * from Empaques where idEmpaque="+id+";");
            while (r.next()) {
                em.setIdEmpaque(r.getInt(1));
                em.setNombre(r.getString(2));
                em.setCapacidad(r.getDouble(3));
                em.setEstatus(r.getString(4));
                em.setIdUnidad(r.getInt(5));
            }
            return em;//jTable---jdatos
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
