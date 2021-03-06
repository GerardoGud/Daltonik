/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

/**
 *
 * @author Rababau
 */
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Sucursales;

public class SucursalesDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public SucursalesDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public void PruebaConexion(){
        System.out.println("Funciona");
        r = cn.consultar("select * from sucursales");
        System.out.println(r);
    }
    
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Sucursales");
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
            r = cn.consultar("select * from Sucursales where estatus = 'A' order by idSucursal offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
               dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                dato.add(r.getString(6));
                dato.add(r.getFloat(7));
                dato.add(r.getString(8));
                dato.add(r.getInt(9));
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
            r = cn.consultar("select * from Sucursales where idSucursal="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                dato.add(r.getString(6));
                dato.add(r.getFloat(7));
                dato.add(r.getString(8));
                dato.add(r.getInt(9));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
        public Sucursales buscarIdEdicion(int id) {
        Sucursales sc=new Sucursales();
        try {
            r = cn.consultar("select * from Sucursales where idSucursal="+id+";");
            while (r.next()) {
                sc.setIdSucursal(r.getInt(1));
                sc.setNombre(r.getString(2));
                sc.setTelefono(r.getString(3));
                sc.setDireccion(r.getString(4));
                sc.setColonia(r.getString(5));
                sc.setCodigoPostal(r.getString(6));
                sc.setPresupuesto(r.getFloat(7));
                sc.setEstatus(r.getString(8));
                sc.setIdCiudad(r.getInt(9));
            }
            return sc;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarSucursal(Sucursales suc){
        try {
            cn.ejecutar("INSERT INTO Sucursales VALUES ("+suc.getIdSucursal()+",'"+suc.getNombre()
                    +"','"+suc.getTelefono()+"','"+suc.getDireccion()+"','"+suc.getColonia()+"','"+suc.getCodigoPostal()+"','"+suc.getPresupuesto()+"','"+suc.getEstatus()+"','"+suc.getIdCiudad()+"');");
        } catch (Exception e) {
        }
    }
    
    public String UltimoID() throws SQLException {
            String id = "";
            r = cn.consultar("select max(idSucursal)+1 idSuc from sucursales");
            if(r.next()){
                id = r.getString("idSuc");
            }
            return id;
	}
    public void editarSucursal(Sucursales suc,int id){
        try {
            cn.ejecutar("update Sucursales set nombre='"+suc.getNombre()+"', telefono='"+suc.getTelefono()
                    +"', direccion='"+suc.getDireccion()+"', colonia='"+suc.getColonia()+"', codigoPostal='"+suc.getCodigoPostal()+"', presupuesto='"+suc.getPresupuesto()+"', estatus='"+suc.getEstatus()+"', idCiudad='"+suc.getIdCiudad()+"'  where idSucursal="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarSucursal(int id){
        try {
            cn.ejecutar("update Sucursales set estatus='I' where idSucursal="+id+";");
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
    
    public ArrayList<String> LlenarComboBusq(){
        ArrayList<String> listaBusq = new ArrayList<String>();
        
        try {
            r = cn.consultar("Select * from sucursales");
            while(r.next()){
                listaBusq.add(r.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBusq;
    }
    
}
