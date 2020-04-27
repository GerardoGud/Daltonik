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
import modelo.beans.PedidoDetalle;
import modelo.beans.RegistroCompra;

public class PedidoDetalleDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;

    public PedidoDetalleDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from PedidoDetalle");
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
            r = cn.consultar("select * from PedidoDetalle order by IdPedidoDetalle offset ("+reg+"*10) rows fetch next 10 rows only");
            while (r.next()) {
                Vector dato = new Vector();
               dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getDouble(3));
                dato.add(r.getDouble(4));
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
            r = cn.consultar("select * from PedidoDetalle where estatus = 'A'");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getDouble(3));
                dato.add(r.getDouble(4));
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
            r = cn.consultar("select * from PedidoDetalle where idPedido="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getInt(2));
                dato.add(r.getDouble(3));
                dato.add(r.getDouble(4));
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
    public ArrayList<RegistroCompra> buscarProductosProveedor(int id) {
        ArrayList<RegistroCompra> reg=new ArrayList();
        try {
            r = cn.consultar("select p.nombre, pp.idPresentacion,e.nombre empaque,e.capacidad,um.siglas,pp.precioCompra precio from productos p join PresentacionesProducto \n" +
"pp on p.idProducto=pp.idProducto join ProductosProveedor pv on pv.idPresentacion=pp.idPresentacion join empaques e \n" +
"on e.idEmpaque=pp.idEmpaque join UnidadMedida um on um.idUnidad=e.idUnidad where pv.idProveedor="+id+";");
            while (r.next()) {
                RegistroCompra dato = new RegistroCompra();
                dato.setNombre(r.getString(1));
                dato.setIdPresentacion(r.getInt(2));
                dato.setEmpaque(r.getString(3));
                dato.setCapacidad(r.getDouble(4));
                dato.setSiglas(r.getString(5));
                dato.setPrecio(r.getDouble(6));
                reg.add(dato);
            }
            return reg;
        } catch (Exception e) {
            return null;
        }
    }
        public PedidoDetalle buscarIdEdicion(int id) {
        PedidoDetalle pd=new PedidoDetalle();
        try {
            r = cn.consultar("select * from PedidoDetalle where idSucursal="+id+";");
            while (r.next()) {
                pd.setIdPedidoDetalle(r.getInt(1));
                pd.setCantidadPedida(r.getInt(2));
                pd.setPrecioCompra(r.getDouble(3));
                pd.setSubtotal(r.getDouble(4));
                pd.setCantRecibida(r.getInt(5));
                pd.setCantRechazada(r.getInt(6));
                pd.setCantAceptada(r.getDouble(7));
                pd.setIdPedido(r.getInt(8));
                pd.setIdPresentacion(r.getInt(9));
                pd.setEstatus(r.getString(10));
            }
            return pd;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarPedidoDetalle(PedidoDetalle pd){
        try {
            cn.ejecutar("INSERT INTO PedidoDetalle VALUES ("+pd.getIdPedidoDetalle()+","+pd.getCantidadPedida()+","+
                    pd.getPrecioCompra()+","+pd.getSubtotal()+","+pd.getCantRecibida()+","+pd.getCantRechazada()+","+
                    pd.getCantAceptada()+","+pd.getIdPedido()+","+pd.getIdPresentacion()+",'"+pd.getEstatus()+"');");
        } catch (Exception e) {
        }
    }
    
    public int UltimoIDPedidoDetalle() {
		int idPedidoDetalle = -1;
		String sql = "select max(idPedidoDetalle)+1 idPedidoDetalle from PedidoDetalle";
		try {
			 r = cn.consultar(sql);
                        if(r.next()){
                            idPedidoDetalle=r.getInt("idPedidoDetalle");
                        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPedidoDetalle;
                
	}
    public int UltimoIDPedidos() {
		int idPedidos = 1;
		String sql = "select max(idPedido)+1 idPedido from Pedidos";
		try {
			cn.ejecutar(sql);
			if(r.next()) {
				idPedidos=r.getInt("idPedido");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPedidos;
	}
    public int ProveedorPedido(int id) {
		int idPedidos = 1;
		String sql = "select idProveedor from Pedidos where idPedido="+id;
		try {
			cn.ejecutar(sql);
			if(r.next()) {
				idPedidos=r.getInt("idProveedor");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idPedidos;
	}
    public void editarPedidoDetalle(PedidoDetalle pd,int id){
        try {
            cn.ejecutar("update PedidoDetalle set cantPedida="+pd.getCantidadPedida()+",PrecioCompra="+
                    pd.getPrecioCompra()+",Subtotal="+pd.getSubtotal()+",CantRecibida="+pd.getCantRecibida()+",CabtRechazada="+pd.getCantRechazada()
                    +",CantAceptada="+pd.getCantAceptada()+",IdPresentacion="+pd.getIdPresentacion()+",'"+pd.getEstatus()
                    +"'  where idPedidoDetalle="+id+";");
        } catch (Exception e) {
        }
    }
    public void actualizarTotalPedido(int id){
        try {
            cn.ejecutar("update Pedidos set totalPagar=(select sum(subtotal) from pedidodetalle where idpedido="+id+") where idPedido="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarPedidoDetalle(int id){
        try {
            cn.ejecutar("update PedidoDetalle set estatus='I' where idPedidoDetalle="+id+";");
        } catch (Exception e) {
        }
    }
    
}
