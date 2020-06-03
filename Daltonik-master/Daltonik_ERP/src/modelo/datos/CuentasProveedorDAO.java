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
import modelo.beans.CuentasProveedor;
import modelo.beans.DProveedor;
import modelo.datos.PedidosDAO;

/**
 *
 * @author Francisco Figueroa
 */
public class CuentasProveedorDAO {

    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user;
    private final String pwd;

    public CuentasProveedorDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from CuentasProveedor where estatus='A' order by idCuentaProveedor offset (" + reg + "*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getString(3));
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

    public int cantPaginas() {
        int p = 0, s = 0;
        try {
            r = cn.consultar("Select count(*) from CuentasProveedor where estatus='A'");
            while (r.next()) {
                p = r.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if (p % 5 == 0) {
            s = (int) p / 5;
            s--;
        } else {
            s = (int) p / 5;
        }
        return s;
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
    public DefaultTableModel buscarId(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from CuentasProveedor where idCuentaProveedor=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                dato.add(r.getString(5));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public CuentasProveedor buscarIdEdicion(int id) {
        CuentasProveedor cp = new CuentasProveedor();
        try {
            r = cn.consultar("select * from CuentasProveedor where idCuentaProveedor=" + id + ";");
            while (r.next()) {
                cp.setIdCuentaProveedor(r.getInt(1));
                cp.setIdProveedor(r.getInt(2));
                cp.setNoCuenta(r.getString(3));
                cp.setBanco(r.getString(4));
                cp.setEstatus(r.getString(5));
            }
            return cp;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarCuentasProveedor(CuentasProveedor cpro) {
        try {
            cn.ejecutar("INSERT INTO CuentasProveedor VALUES (" + cpro.getIdCuentaProveedor() + "," + cpro.getIdProveedor()
                    + ",'" + cpro.getNoCuenta() + "','" + cpro.getBanco() + "','" + cpro.getEstatus() + "');");
        } catch (Exception e) {
        }
    }

    public void editarCuentasProveedor(CuentasProveedor cpro, int id) {
        try {
            cn.ejecutar("update cuentasproveedor set  noCuenta='" + cpro.getNoCuenta()
                    + "',Banco='" + cpro.getBanco() + "',estatus= '" + cpro.getEstatus() + "' where idCuentaProveedor=" + id );
        } catch (Exception e) {
        }
    }

    public void eliminarCuentasProveedor(int id) {
        try {
            cn.ejecutar("update cuentasproveedor set estatus='I' where idProveedor=" + id + ";");
        } catch (Exception e) {
        }
    }
    
    public int UltimoIDCuenta() {
		int idCuentaProveedor = -1;
		String sql = "select max(idCuentaProveedor)+1 idCuentaProveedor from CuentasProveedor";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idCuentaProveedor=r.getInt("idCuentaProveedor");
                        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idCuentaProveedor;
                
	}
}
