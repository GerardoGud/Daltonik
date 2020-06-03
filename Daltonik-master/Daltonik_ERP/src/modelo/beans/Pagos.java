/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author LuisCerv
 */
public class Pagos {
    private int idPago;
    private String fecha;
    private double importe;
    private int idPedido;
    private int idFormaPago;
    private int idCuentaProveedor;
    private String estatus;

    public Pagos() {
    }

    public Pagos(int idPago, String fecha, double importe, int idPedido, int idFormaPago, int idCuentaProveedor, String estatus) {
        this.idPago = idPago;
        this.fecha = fecha;
        this.importe = importe;
        this.idPedido = idPedido;
        this.idFormaPago = idFormaPago;
        this.idCuentaProveedor = idCuentaProveedor;
        this.estatus = estatus;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public int getIdCuentaProveedor() {
        return idCuentaProveedor;
    }

    public void setIdCuentaProveedor(int idCuentaProveedor) {
        this.idCuentaProveedor = idCuentaProveedor;
    }
    
    
}
