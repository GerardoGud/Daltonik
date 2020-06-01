/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Categorias;
import static modelo.datos.EmpaqueDAO.r;
import static modelo.datos.PresentacionesProductoDAO.r;

/**
 *
 * @author FranciscoFigueroa
 */
public class CategoriasDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public CategoriasDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Categorias where estatus='A' order by idCategoria offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
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
            r = cn.consultar("Select count(*) from Categorias where estatus='A'");
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
            r = cn.consultar("select * from Categorias where idCategoria=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
public Categorias buscarIdEdicion(int id) {
        Categorias ca=new Categorias();
        try {
            r = cn.consultar("select * from Categorias where idCategoria="+id+";");
            while (r.next()) {
                ca.setIdCategoria(r.getInt(1));
                ca.setNombre(r.getString(2));
                ca.setEstatus(r.getString(3));
            }
            return ca;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public void guardarCategorias(Categorias cat) {
        try {
            cn.ejecutar("INSERT INTO Categorias VALUES (" + cat.getIdCategoria() + ",'" + cat.getNombre()
                    + "','" + cat.getEstatus() + "');");
        } catch (Exception e) {
        }
    }
      public int UltimoID() {
		int idCategoriasU = 1;
		String sql = "select max(idCategoria)+1 idCategoria from Categorias";
		try {
			cn.ejecutar(sql);
			if(r.next()) {
				idCategoriasU=r.getInt("idCategoria");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idCategoriasU;
	}
    public void editarCategorias(Categorias cat, int id) {
        try {
            cn.ejecutar("update categorias set  nombre='" + cat.getNombre()
                    + "',estatus='" + cat.getEstatus() + "' where idCategoria=" + id + ";");
        } catch (Exception e) {
        }
    }

    public void eliminarCategorias(int id) {
        try {
            cn.ejecutar("update categorias set estatus='I' where idCategoria=" + id + ";");
        } catch (Exception e) {
        }
    }
}
