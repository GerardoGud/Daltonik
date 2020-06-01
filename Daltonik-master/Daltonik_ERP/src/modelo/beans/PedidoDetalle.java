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
public class PedidoDetalle {
    private int idPedidoDetalle;
    private int cantidadPedida;
    private double precioCompra;
    private double subtotal;
    private int cantRecibida;
    private int cantRechazada;
    private double cantAceptada;
    private int idPedido;
    private int idPresentacion;
    private String estatus;

    public PedidoDetalle() {
    }

    public PedidoDetalle(int idPedidoDetalle, int cantidadPedida, double precioCompra, double subtotal, int cantRecibida, int cabtRechazada, double cabtAceptada, int idPedido, int idPresentacion, String estatus) {
        this.idPedidoDetalle = idPedidoDetalle;
        this.cantidadPedida = cantidadPedida;
        this.precioCompra = precioCompra;
        this.subtotal = subtotal;
        this.cantRecibida = cantRecibida;
        this.cantRechazada = cabtRechazada;
        this.cantAceptada = cabtAceptada;
        this.idPedido = idPedido;
        this.idPresentacion = idPresentacion;
        this.estatus = estatus;
    }

    public int getIdPedidoDetalle() {
        return idPedidoDetalle;
    }

    public void setIdPedidoDetalle(int idPedidoDetalle) {
        this.idPedidoDetalle = idPedidoDetalle;
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public void setCantidadPedida(int cantidadPedida) {
        this.cantidadPedida = cantidadPedida;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantRecibida() {
        return cantRecibida;
    }

    public void setCantRecibida(int cantRecibida) {
        this.cantRecibida = cantRecibida;
    }

    public int getCantRechazada() {
        return cantRechazada;
    }

    public void setCantRechazada(int cabtRechazada) {
        this.cantRechazada = cabtRechazada;
    }

    public double getCantAceptada() {
        return cantAceptada;
    }

    public void setCantAceptada(double cabtAceptada) {
        this.cantAceptada = cabtAceptada;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
