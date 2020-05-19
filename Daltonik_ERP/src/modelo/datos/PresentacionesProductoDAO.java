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
import modelo.beans.ConsultaEmpaque;
import modelo.beans.ConsultaProductos;
import modelo.beans.Empaque;
import modelo.beans.PresentacionesProducto;
import static modelo.datos.EmpaqueDAO.r;
import static modelo.datos.LaboratoriosDAO.r;

/**
 *
 * @author Francisco Figueroa
 */
public class PresentacionesProductoDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user;
    private final String pwd;

    public PresentacionesProductoDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from PresentacionesProducto where estatus='A'");
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
            r = cn.consultar("select * from PresentacionesProducto where estatus='A' order by idPresentacion offset ("+reg+"*5) rows fetch next 5 rows only");
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
public ArrayList<ConsultaProductos> consultarProd() {
         ArrayList<ConsultaProductos> pr = new  ArrayList<ConsultaProductos>();
         ConsultaProductos c;
        try {
            r = cn.consultar("select idProducto,nombre from Productos;");
            while (r.next()) {
                c=new ConsultaProductos();
                c.setId(r.getInt(1));
                c.setNombre(r.getString(2));
                pr.add(c);
            }
            return pr;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
public ArrayList<ConsultaEmpaque> consultarEmp() {
         ArrayList<ConsultaEmpaque> pr = new  ArrayList<ConsultaEmpaque>();
         ConsultaEmpaque c;
        try {
            r = cn.consultar("select idEmpaque,nombre from Empaques;");
            while (r.next()) {
                c=new ConsultaEmpaque();
                c.setId(r.getInt(1));
                c.setNombre(r.getString(2));
                pr.add(c);
            }
            return pr;//jTable---jdatos
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
                pr.setEstatus(r.getString(7));
            }
            return pr;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarPresentacionesProducto(PresentacionesProducto pr) {
        try {
            cn.ejecutar("INSERT INTO PresentacionesProducto VALUES (" + pr.getIdPresentacion() + "," + pr.getPrecioCompra()
                    + "," + pr.getPrecioVenta() + "," + pr.getPuntoReorden() + "," + pr.getIdProducto() + "," + pr.getIdEmpaque() + ",'"+pr.getEstatus()+"');");
        } catch (Exception e) {
        }
    }
    public int UltimoID() {
		int idPresentacionesProductoU = 1;
		String sql = "select max(idPresentacion)+1 idPresentacion from PresentacionesProducto";
		try {
			r=cn.consultar(sql);
			if(r.next()) {
				idPresentacionesProductoU=r.getInt("idPresentacion");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPresentacionesProductoU;
	}
    public void editarPresentacionesProducto(PresentacionesProducto pr, int id) {
        try {
            cn.ejecutar("update PresentacionesProducto set puntoReorden=" + pr.getPuntoReorden() + ", precioCompra=" + pr.getPrecioCompra()
                    + ",precioVenta=" + pr.getPrecioVenta() + ", idProducto=" + pr.getIdProducto() + ",idEmpaque=" + pr.getIdEmpaque() + ",estatus='"+pr.getEstatus()+"' where idPresentacion=" + id + ";");
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
