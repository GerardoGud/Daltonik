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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.DProveedor;
import modelo.beans.Pagos;
import modelo.beans.Pedidos;
import modelo.datos.PedidosDAO;

public class PagosDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public PagosDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Pagos");
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
            r = cn.consultar("select * from Pagos order by Idpago offset ("+reg+"*10) rows fetch next 10 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getDouble(3));
                dato.add(r.getInt(4));
                dato.add(r.getInt(5));
                dato.add(r.getInt(6));
                dato.add(r.getString(7));
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
            r = cn.consultar("select * from Pagos where idpago="+id);
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getDouble(3));
                dato.add(r.getInt(4));
                dato.add(r.getInt(5));
                dato.add(r.getInt(6));
                dato.add(r.getString(7));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public Pedidos buscarPedido(int id){
        Pedidos p=new Pedidos();
        try {
            r = cn.consultar("select p.idPedido,p.fechaRegistro,p.fechaRecepcion,p.totalPagar,p.cantidadPagada,p.estatus,cp.idCuentaProveedor,p.idSucursal,p.idEmpleado\n" +
"from Pedidos p join CuentasProveedor cp on cp.idProveedor=p.idProveedor where p.idPedido="+id);
            while (r.next()) {
                 p.setIdPedido(r.getInt(1));//idpedido
                p.setFechaRegistro(r.getString(2));//fRegistro
                p.setFechaRecepcion(r.getString(3));//fRecepcion
                p.setTotalPagar(r.getDouble(4));//totalpagar
                p.setCantidadPagada(r.getDouble(5));//pagado
                p.setEstatus(r.getString(6));//estatus
                p.setIdProveedor(r.getInt(7));//idproveedor
                p.setIdSucursal(r.getInt(8));//idSucursal
                p.setIdEmpleado(r.getInt(9));//idEmpleado
            }
            return p;
        } catch (SQLException ex) {
            return null;
        }
    }
    public DefaultTableModel cargarIdProducto(JTable tDatos, int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Pagos where idProducto="+id);
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getDouble(3));
                dato.add(r.getInt(4));
                dato.add(r.getInt(5));
                dato.add(r.getInt(6));
                dato.add(r.getString(7));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
        public Pagos buscarIdEdicion(int id) {
        Pagos pg=new Pagos();
        try {
            r = cn.consultar("select * from Pagos where idpago="+id+";");
            while (r.next()) {
                pg.setIdPago(id);
                pg.setFecha(r.getString(2));
                pg.setImporte(r.getDouble(3));
                pg.setIdPedido(r.getInt(4));
                pg.setIdFormaPago(r.getInt(5));
                pg.setIdCuentaProveedor(r.getInt(6));
                pg.setEstatus(r.getString(7));
            }
            return pg;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarPagos(Pagos pg) {
        String sql = "INSERT INTO Pagos VALUES (?,getdate(),?,?,?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = cn.getConexion().prepareStatement(sql);
            ps.setInt(1, pg.getIdPago());
            ps.setDouble(2, pg.getImporte());
            ps.setInt(3, pg.getIdPedido());
            ps.setInt(4,pg.getIdFormaPago());
            ps.setInt(5, pg.getIdCuentaProveedor());
            ps.setString(6, pg.getEstatus());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public int UltimoIDPagos() {
		int idPagos = -1;
		String sql = "select max(idpago)+1 idPagos from Pagos";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idPagos=r.getInt("idPagos");
                        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idPagos;
                
	}
    public void actualizarTotalPedido(int id) {
        try {
            cn.ejecutar("update Pedidos set cantidadPagada=(select sum(importe) from pagos where idpedido="+id+"),estatus='P' where idPedido="+id+";");
        } catch (Exception e) {
        }
    }
    public void editarPagos(Pagos pg, int id){
        String sql = "update Pagos set fecha=?,importe=?,idpedido=?,idFormaPago=?,idcuentaproveedor,estatus=?  where idpago=?;";
        PreparedStatement ps = null;
        try {
            ps = cn.getConexion().prepareStatement(sql);
            ps.setString(1, pg.getFecha());
            ps.setDouble(2, pg.getImporte());
            ps.setInt(3, pg.getIdPedido());
            ps.setInt(4,pg.getIdFormaPago());
            ps.setInt(5, pg.getIdCuentaProveedor());
            ps.setString(6, pg.getEstatus());
            ps.setInt(7, pg.getIdPago());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarPagos(int id){
        try {
            cn.ejecutar("update Pagos set estatus='I' where idpago="+id+";");
        } catch (Exception e) {
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
}
