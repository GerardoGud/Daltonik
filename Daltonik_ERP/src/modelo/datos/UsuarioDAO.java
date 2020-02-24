/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Usuario;

/**
 *
 * @author LuisCerv
 */
public class UsuarioDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public UsuarioDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }

    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Usuarios");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getString(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getInt(4));
                dato.add(r.getInt(5));
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
            r = cn.consultar("select * from Usuarios where idEmpleado=" + id + ";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getInt(4));
                dato.add(r.getInt(5));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
public Usuario buscarIdEdicion(int id) {
        Usuario u=new Usuario();
        try {
            r = cn.consultar("select * from Usuarios where idEmpleado="+id+";");
            while (r.next()) {
                u.setNombre(r.getString(1));
                u.setContrasena(r.getString(2));
                u.setEstatus(r.getString(3));
                u.setIdEmpleado(r.getInt(4));
                u.setIdTipoUsuario(r.getInt(5));
            }
            return u;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }

    public void guardarUsuario(Usuario u) {
        try {
            cn.ejecutar("CREATE LOGIN "+u.getNombre()+" WITH PASSWORD = '"+u.getContrasena()+"'\n" +
            "CREATE USER "+u.getNombre()+" FOR LOGIN "+u.getNombre()+" ;  \n" +
            "alter server role sysadmin add member "+u.getNombre()+";\n");
            cn.ejecutar("INSERT INTO Usuarios VALUES ('" + u.getNombre() + "','" + u.getContrasena()
                    + "','" + u.getEstatus()+ "'," + u.getIdEmpleado()+ "," + u.getIdTipoUsuario() + ");");
            
        } catch (Exception e) {
        }
    }

    public void editarUsuario(Usuario u, int id) {
        try {
            cn.ejecutar("update Usuarios set  nombre='" + u.getNombre()
                    + "',estatus='" + u.getEstatus() + "',IdTipoUsuario='" + u.getIdTipoUsuario()
                     + "',contrasenia='" + u.getContrasena() + "' where idEmpleado=" + id + ";");
        } catch (Exception e) {
        }
    }

    public void eliminarUsuario(int id) {
        try {
            cn.ejecutar("update Usuarios set estatus='I' where idEmpleado=" + id + ";");
        } catch (Exception e) {
        }
    }
}
