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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.ConsultaPresentacion;
import modelo.beans.DProveedor;
import modelo.beans.ProductosProveedor;
import static modelo.datos.PedidosDAO.r;

/**
 *
 * @author FranciscoFigueroa
 */
public class ProductosProveedorDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public ProductosProveedorDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ProductosProveedor where estatus='A' order by idProveedor offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getInt(3));
                dato.add(r.getFloat(4));
                dato.add(r.getFloat(5));
                dato.add(r.getInt(6));
                dato.add(r.getInt(7));
                dato.add(r.getString(8));
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
            r = cn.consultar("Select count(*) from ProductosProveedor where estatus='A'");
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
    public DefaultTableModel buscarId(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ProductosProveedor where idProveedor=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getInt(3));
                dato.add(r.getFloat(4));
                dato.add(r.getFloat(5));
                dato.add(r.getInt(6));
                dato.add(r.getInt(7));
                dato.add(r.getString(8));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
public ProductosProveedor buscarIdEdicion(int id) {
        ProductosProveedor pr=new ProductosProveedor();
        try {
            r = cn.consultar("select * from ProductosProveedor where idProveedor="+id+";");
            while (r.next()) {
                pr.setIdProveedor(r.getInt(1));
                pr.setIdPresentacion(r.getInt(2));
                pr.setDiasRetardo(r.getInt(3));
                pr.setPrecioEstandar(r.getDouble(4));
                pr.setPrecioUltimaCompra(r.getDouble(5));
                pr.setCantMinPedir(r.getInt(6));
                pr.setCantMaxPedir(r.getInt(7));
                pr.setEstatus(r.getString(8));
            }
            return pr;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public void guardarProductosProveedor(ProductosProveedor pro) {
        try {
            cn.ejecutar("INSERT INTO ProductosProveedor VALUES (" + pro.getIdProveedor() + "," + pro.getIdPresentacion()
                    + "," + pro.getDiasRetardo() + "," + pro.getPrecioEstandar()+ "," + pro.getPrecioUltimaCompra()+ 
                    "," + pro.getCantMinPedir()+ "," + pro.getCantMaxPedir()+ ",'" + pro.getEstatus() +"');");
        } catch (Exception e) {
        }
    }
//      public int UltimoID() {
//		int idProveedorU = 1;
//		String sql = "select max(idProveedor)+1 idProveedor from ProductosProveedor";
//		try {
//			r=cn.consultar(sql);
//			if(r.next()) {
//				idProveedorU=r.getInt("idProveedor");
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return idProveedorU;
//	}
    public void editarProductosProveedor(ProductosProveedor pro, int id, int idP) {
        try {
            cn.ejecutar("update productosproveedor set  diasRetardo=" + pro.getDiasRetardo()
                    + ",precioEstandar=" + pro.getPrecioEstandar() + ",precioUltimaCompra=" + pro.getPrecioUltimaCompra() +
                    ",cantMinPedir=" + pro.getCantMinPedir() + ",cantMaxPedir=" + pro.getCantMaxPedir() +
                    ",estatus= '"+ pro.getEstatus() +"' where idProveedor=" + id + " and idPresentacion="+idP);
        } catch (Exception e) {
        }
    }
public ArrayList<ConsultaPresentacion> consultarPres() {
         ArrayList< ConsultaPresentacion> pr = new  ArrayList< ConsultaPresentacion>();
          ConsultaPresentacion c;
        try {
            r = cn.consultar("select p.idPresentacion idPresentacion, (pr.nombre+' '+e.nombre) nombre from PresentacionesProducto p join Empaques e on e.idEmpaque=p.idEmpaque\n" +
                                "join Productos pr on pr.idProducto=p.idProducto;");
            while (r.next()) {
                c=new ConsultaPresentacion();
                c.setId(r.getInt(1));
                c.setNombre(r.getString(2));
                pr.add(c);
            }
            return pr;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
public ArrayList<DProveedor> buscarProveedores() {
        ArrayList<DProveedor> p=new ArrayList<DProveedor>();
        try {
            r = cn.consultar("select idProveedor, nombre from Proveedores");
            while (r.next()) {
                DProveedor dato = new DProveedor();
                dato.setIdProveedor(r.getInt(1));
                dato.setNombre(r.getString(2));
                p.add(dato);
            }
            return p;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
    public void eliminarProductosProveedor(int id,int idP) {
        try {
            cn.ejecutar("update productosproveedor set estatus='I' where idProveedor=" + id + " and idPresentacion="+idP);
        } catch (Exception e) {
        }
    }
}
