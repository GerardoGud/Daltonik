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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.DProveedor;
import modelo.beans.Pedidos;
import modelo.beans.RegistroCompra;

public class PedidosDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public PedidosDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Pedidos");
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
            r = cn.consultar("select * from Pedidos order by IdPedido offset ("+reg+"*10) rows fetch next 10 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getDouble(4));
                dato.add(r.getDouble(5));
                dato.add(r.getString(6));
                dato.add(r.getInt(7));
                dato.add(r.getInt(8));
                dato.add(r.getInt(9));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Pedidos where estatus = 'A'");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getDouble(4));
                dato.add(r.getDouble(5));
                dato.add(r.getString(6));
                dato.add(r.getInt(7));
                dato.add(r.getInt(8));
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
            r = cn.consultar("select * from Pedidos where idPedido="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getDouble(4));
                dato.add(r.getDouble(5));
                dato.add(r.getString(6));
                dato.add(r.getInt(7));
                dato.add(r.getInt(8));
                dato.add(r.getInt(9));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public Pedidos buscarIdEdicion(int id) {
        Pedidos p=new Pedidos();
        try {
            r = cn.consultar("select * from Pedidos where idPedido="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getDouble(4));
                dato.add(r.getDouble(5));
                dato.add(r.getString(6));
                dato.add(r.getInt(7));
                dato.add(r.getInt(8));
                dato.add(r.getInt(9));
            }
            return p;//jTable---jdatos
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
        
    public void guardarPedidos(Pedidos pd){
        try {
            cn.ejecutar("INSERT INTO Pedidos VALUES ("+pd.getIdPedido()+",'"+pd.getFechaRegistro()+"','"+
                    pd.getFechaRecepcion()+"',"+pd.getTotalPagar()+","+pd.getCantidadPagada()+",'"+
                    pd.getEstatus()+"',"+pd.getIdProveedor()+","+pd.getIdSucursal()+","+pd.getIdEmpleado()+");");
        } catch (Exception e) {
        }
    }
    
    public int UltimoIDPedidos() {
		int idPedidos = -1;
		String sql = "select max(idPedido)+1 idPedidos from Pedidos";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idPedidos=r.getInt("idPedidos");
                        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPedidos;
                
	}
    public void editarPedidos(Pedidos pd,int id){
        try {
            cn.ejecutar("update Pedidos set FechaRegistro='"+pd.getFechaRegistro()+"',FechaRecepcion='"+
                    pd.getFechaRecepcion()+"',TotalPagar="+pd.getTotalPagar()+",CantidadPagada="+pd.getCantidadPagada()+",Estatus='"+
                    pd.getEstatus()+"',IdProveedor="+pd.getIdProveedor()+",IdSucursal="+pd.getIdSucursal()+",IdEmpleado="+pd.getIdEmpleado()
                    +"  where idPedido="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarPedidos(int id){
        try {
            cn.ejecutar("update Pedidos set estatus='I' where idPedido="+id+";");
        } catch (Exception e) {
        }
    }
    
}
