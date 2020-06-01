/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

/**
 *
 * @author Luis Cervantes
 */
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.ImagenesProducto;

public class ImagenesProductoDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public ImagenesProductoDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from ImagenesProducto");
            while (r.next()) {
                p=r.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(p%10==0){
            s=(int)p/10;
            s--;
        }else{
            s=(int)p/10;
        }
        return s;
    }
    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ImagenesProducto order by IdImagen offset ("+reg+"*10) rows fetch next 10 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getBytes(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public DefaultTableModel cargarId(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ImagenesProducto where idImagen="+id);
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getBytes(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public byte[] cargarImagen(int id){
        byte[] x=null;
        try {
            r = cn.consultar("select * from ImagenesProducto where idImagen="+id);
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                x=r.getBytes(3);
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(6));
            }
            return x;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public String buscarProducto(int id){
        try {
            r = cn.consultar("select estatus from Productos where idProducto="+id);
            return r.getString(1);
        } catch (SQLException ex) {
            return "";
        }
    }
    public DefaultTableModel cargarIdProducto(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from ImagenesProducto where idProducto="+id);
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getBytes(3));
                dato.add(r.getString(4));
                dato.add(r.getInt(5));
                dato.add(r.getString(6));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
        public ImagenesProducto buscarIdEdicion(int id) {
        ImagenesProducto im=new ImagenesProducto();
        try {
            r = cn.consultar("select * from ImagenesProducto where idImagen="+id+";");
            while (r.next()) {
                im.setIdImagen(id);
                im.setNombreImagen(r.getString(2));
                im.setImagen(r.getBytes(3));
                im.setPrincipal(r.getString(4));
                im.setIdProducto(r.getInt(5));
                im.setEstatus(r.getString(6));
            }
            return im;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarImagenesProducto(ImagenesProducto im) {
        if (im.getPrincipal().equals("P")) {
            cn.ejecutar("update Pagos set principal='S' where IdProducto=" + im.getIdProducto() + ";");
        }
        String sql = "INSERT INTO ImagenesProducto VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = cn.getConexion().prepareStatement(sql);
            ps.setInt(1, im.getIdImagen());
            ps.setString(2, im.getNombreImagen());
            ps.setBytes(3, im.getImagen());
            ps.setString(4, im.getPrincipal());
            ps.setInt(5, im.getIdProducto());
            ps.setString(6, im.getEstatus());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }
    
    public int UltimoIDImagenesProducto() {
		int idImagenesProducto = -1;
		String sql = "select max(idImagen)+1 idImagenesProducto from ImagenesProducto";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idImagenesProducto=r.getInt("idImagenesProducto");
                        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idImagenesProducto;
                
	}

    public void editarImagenesProducto(ImagenesProducto im, int id) {
        if (im.getPrincipal().equals("P")) {
            cn.ejecutar("update ImagenesProducto set principal='S' where IdProducto=" + im.getIdProducto() + ";");
        }
        String sql = "update ImagenesProducto set nombreImagen=?,imagen=?,principal=?,idProducto=?,estatus=?  where idImagen=?;";
        PreparedStatement ps = null;
        try {
            ps = cn.getConexion().prepareStatement(sql);
            ps.setString(1, im.getNombreImagen());
            ps.setBytes(2, im.getImagen());
            ps.setString(3, im.getPrincipal());
            ps.setInt(4, im.getIdProducto());
            ps.setString(5, im.getEstatus());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarImagenesProducto(int id){
        try {
            cn.ejecutar("update ImagenesProducto set estatus='I' where IdImagen="+id+";");
        } catch (Exception e) {
        }
    }
    
}
