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
import modelo.beans.DProveedor;
import modelo.beans.DSucursal;
import modelo.beans.Productos;
/**
 *
 * @author LuisCerv
 */
public class ProductosDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public ProductosDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("SELECT p.idProducto,p.nombre ,p.descripcion,p.puntoReorden,p.precioCompra\n" +
"      ,p.precioVenta,p.ingredienteActivo,p.bandaToxicologica,p.aplicacion,p.uso\n" +
"      ,p.estatus,l.nombre,c.nombre\n" +
"  FROM Productos p join Laboratorios l on l.idLaboratorio=p.idLaboratorio join \n" +
"  Categorias c on c.idCategoria=p.idCategoria order by idProducto offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getInt(4));
                dato.add(r.getDouble(5));
                dato.add(r.getDouble(6));
                dato.add(r.getString(7));
                dato.add(r.getString(8));
                dato.add(r.getString(9));
                dato.add(r.getString(10));
                dato.add(r.getString(11));
                dato.add(r.getString(12));
                dato.add(r.getString(13));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public ArrayList<DProveedor> buscarProveedores() {
        ArrayList<DProveedor> p=new ArrayList<DProveedor>();
        try {
            r = cn.consultar("select idLaboratorio,nombre from Laboratorios");
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
    public ArrayList<DSucursal> buscarSucursales() {
        ArrayList<DSucursal> p=new ArrayList<DSucursal>();
        try {
            r = cn.consultar("select idCategoria,nombre from Categorias");
            while (r.next()) {
                DSucursal dato = new DSucursal();
                dato.setIdSucursal(r.getInt(1));
                dato.setNombre(r.getString(2));
                p.add(dato);
            }
            return p;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Productos");
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
            r = cn.consultar("select * from Productos where idProducto=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getInt(4));
                dato.add(r.getDouble(5));
                dato.add(r.getDouble(6));
                dato.add(r.getString(7));
                dato.add(r.getString(8));
                dato.add(r.getString(9));
                dato.add(r.getString(10));
                dato.add(r.getString(11));
                dato.add(r.getInt(12));
                dato.add(r.getInt(13));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
public Productos buscarIdEdicion(int id) {
        Productos p=new Productos();
        try {
            r = cn.consultar("select * from Productos where idProducto="+id+";");
            while (r.next()) {
                p.setIdProducto(r.getInt(1));
                p.setNombre(r.getString(2));
                p.setDescripcion(r.getString(3));
                p.setPuntoReorden(r.getInt(4));
                p.setPrecioCompra(r.getDouble(5));
                p.setPrecioVenta(r.getDouble(6));
                p.setIngredienteActivo(r.getString(7));
                p.setBandaToxicologica(r.getString(8));
                p.setAplicacion(r.getString(9));
                p.setUso(r.getString(10));
                p.setEstatus(r.getString(11));
                p.setIdLaboratorio(r.getInt(12));
                p.setIdCategoria(r.getInt(13));
            }
            return p;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarProducto(Productos p) {
        try {
            cn.ejecutar("INSERT INTO Productos VALUES ("+p.getIdProducto()+",'"+p.getNombre()+"','"+
                    p.getDescripcion()+"',"+p.getPuntoReorden()+","+p.getPrecioCompra()+","+p.getPrecioVenta()+
                    ",'"+p.getIngredienteActivo()+"','"+p.getBandaToxicologica()+"','"+p.getAplicacion()+
                    "','"+p.getUso()+"','"+p.getEstatus()+"',"+p.getIdLaboratorio()+","+p.getIdCategoria()+");");
        } catch (Exception e) {
        }
    }

    public void editarProducto(Productos p, int id) {
        try {
            cn.ejecutar("update Productos set  nombre='" + p.getNombre()+
                    "',descripcion='"+p.getDescripcion()+"',puntoReorden="+p.getPuntoReorden()
                    +",precioCompra="+p.getPrecioCompra()+",precioVenta="+p.getPrecioVenta()+
                    ",ingredienteActivo='"+p.getIngredienteActivo()+"',bandaToxicologica='"+p.getBandaToxicologica()
                    +"',aplicacion='"+p.getAplicacion()+"',uso='"+p.getUso()
                    +"',estatus='"+p.getEstatus()+"',idLaboratorio="+p.getIdLaboratorio()
                    +",idCategoria="+p.getIdCategoria() + " where idProducto=" + id + ";");
        } catch (Exception e) {
        }
    }
public int UltimoProducto() {
		int idPedidoDetalle = -1;
		String sql = "select max(idProducto)+1 Produc from Productos";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idPedidoDetalle=r.getInt("Produc");
                        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPedidoDetalle;
                
	}
    public void eliminarProducto(int id) {
        try {
            cn.ejecutar("update Productos set estatus='I' where idProducto=" + id + ";");
        } catch (Exception e) {
        }
    }
}
