/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Proveedores;
/**
 *
 * @author Rababau
 */
public class ProveedoresDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public ProveedoresDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }
    
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Proveedores");
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
    
    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Proveedores where estatus = 'A' order by idProveedor offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
               dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                dato.add(r.getString(6));
                dato.add(r.getInt(7));
                dato.add(r.getString(8));
                dato.add(r.getString(9));
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
            r = cn.consultar("select * from Proveedores where idProveedor="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                dato.add(r.getString(6));
                dato.add(r.getString(8));
                dato.add(r.getInt(8));
                dato.add(r.getString(9));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

public Proveedores buscarIdEdicion(int id) {
        Proveedores pv=new Proveedores();
        try {
            r = cn.consultar("select * from Proveedores where idProveedor="+id+";");
            while (r.next()) {
                pv.setIdProveedor(r.getInt(1));
                pv.setNombre(r.getString(2));
                pv.setTelefono(r.getString(3));
                pv.setEmail(r.getString(4));
                pv.setDireccion(r.getString(5));
                pv.setColonia(r.getString(6));
                pv.setCodigoPostal(r.getString(7));
                pv.setIdCiudad(r.getInt(8));
                pv.setEstatus(r.getString(9));
            }
            return pv;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }

public void guardarProveedor(Proveedores pro){
        try {
            cn.ejecutar("INSERT INTO Proveedores VALUES ("+pro.getIdProveedor()+",'"+pro.getNombre()
                    +"','"+pro.getTelefono()+"','"+pro.getEmail()+"','"+pro.getDireccion()+"','"+pro.getColonia()+"','"+pro.getCodigoPostal()+"','"+pro.getIdCiudad()+"','"+pro.getEstatus()+"');");
        } catch (Exception e) {
        }
    }
    
    public String UltimoID() throws SQLException {
            String id = "";
            r = cn.consultar("select max(idProveedor)+1 idPro from Proveedores");
            if(r.next()){
                id = r.getString("idPro");
            }
            return id;
	}
    public void editarProveedor(Proveedores pro,int id){
        try {
            cn.ejecutar("update Sucursales set nombre='"+pro.getNombre()+"', telefono='"+pro.getTelefono()
                    +"', email='"+pro.getEmail()+"', direccion='"+pro.getDireccion()+"', colonia='"+pro.getColonia()+"', codigoPostal='"+pro.getCodigoPostal()+"', idCiudad='"+pro.getIdCiudad()+"', estatus='"+pro.getEstatus()+"'  where idProveedor="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarProveedor(int id){
        try {
            cn.ejecutar("update Proveedores set estatus='I' where idProveedor="+id+";");
        } catch (Exception e) {
        }
    }
    
    public ArrayList<String> LlenarCombo(){
        ArrayList<String> lista = new ArrayList<String>();
        try{
            r = cn.consultar("Select * from ciudades");
            while(r.next()){
                lista.add(r.getString("nombre"));
            }
        }
        catch(Exception e){
            System.out.println("No funciona");
        }
        return lista;
    }
    
    public String idProEditar(String nombre) throws SQLException{
        String id = "";
        r = cn.consultar("select idProveedor from Proveedores where nombre = "+nombre+";");
            if(r.next()){
                id = r.getString("idProveedor");
            }
            return id;
    }
}


