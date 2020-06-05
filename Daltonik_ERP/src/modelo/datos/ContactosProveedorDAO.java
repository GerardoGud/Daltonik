/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.ContactosProveedor;

/**
 *
 * @author Rababau
 */
public class ContactosProveedorDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public ContactosProveedorDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public void PruebaConexion(){
        System.out.println("Funciona");
        r = cn.consultar("select * from ContactosProveedor");
        System.out.println(r);
    }
    
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from ContactosProveedor");
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
            
            r = cn.consultar("select cp.*, p.nombre nombreProveedor from contactosproveedor cp join proveedores p on p.idProveedor = cp.idProveedor where cp.estatus = 'A' order by idContacto offset "+reg+"*5 rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
               dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(7));
                dato.add(r.getString(6));
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
            r = cn.consultar("select cp.*, p.nombre nombre from ContactosProveedor cp join proveedores p on cp.idProveedor = p.idProveedor where p.idContacto="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(7));
                dato.add(r.getString(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
    public DefaultTableModel buscarCadena(JTable tDatos,String cad) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select cp.*, p.nombre nombre from ContactosProveedor cp join proveedores p on cp.idProveedor = p.idProveedor where p.nombre like '%"+cad+"%';");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(7));
                dato.add(r.getString(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    
    public ContactosProveedor buscarIdEdicion(int id) {
        ContactosProveedor cp = new ContactosProveedor();
        try {
            r = cn.consultar("select * from ContactosProveedor where idContacto="+id+";");
            while (r.next()) {
                cp.setIdContacto(r.getInt(1));
                cp.setNombre(r.getString(2));
                cp.setTelefono(r.getString(3));
                cp.setEmail(r.getString(4));
                cp.setIdProveedor(r.getInt(5));
                cp.setEstatus(r.getString(6));
            }
            return cp;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarContacto(ContactosProveedor cpro){
        try {
            cn.ejecutar("INSERT INTO ContactosProveedor VALUES ("+cpro.getIdContacto()+",'"+cpro.getNombre()
                    +"','"+cpro.getTelefono()+"','"+cpro.getEmail()+"','"+cpro.getIdProveedor()+"','"+cpro.getEstatus()+"');");
        } catch (Exception e) {
        }
    }
    
    public String UltimoID() throws SQLException {
            String id = "";
            r = cn.consultar("select max(idContacto)+1 idCon from ContactosProveedor");
            if(r.next()){
                id = r.getString("idCon");
            }
            return id;
	}
    public void editarContacto(ContactosProveedor cpro,int id){
        try {
            cn.ejecutar("update ContactosProveedor set nombre='"+cpro.getNombre()+"', telefono='"+cpro.getTelefono()
                    +"', email='"+cpro.getEmail()+"', idProveedor='"+cpro.getIdProveedor()+"', estatus='"+cpro.getEstatus()+"'  where idContacto="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarContacto(int id){
        try {
            cn.ejecutar("update ContactosProveedor set estatus='I' where idContacto="+id+";");
        } catch (Exception e) {
        }
    }
    public ArrayList<String> LlenarCombo(){
        ArrayList<String> lista = new ArrayList<String>();
        try{
            r = cn.consultar("Select * from Proveedores");
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
            r = cn.consultar("Select * from Proveedores");
            while(r.next()){
                listaBusq.add(r.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProveedoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaBusq;
    }
    
}
