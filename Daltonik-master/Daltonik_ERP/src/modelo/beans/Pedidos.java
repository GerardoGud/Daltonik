/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.util.Date;

/**
 *
 * @author Nadia Cross
 */
public class Pedidos {
    private int idPedido;
    private String fechaRegistro;
    private String fechaRecepcion;
    private double totalPagar;
    private double cantidadPagada;
    private String estatus;
    private int idProveedor;
    private int idSucursal;
    private int idEmpleado;

    public Pedidos(int idPedido, String fechaRegistro, String fechaRecepcion, float totalPagar, float cantidadPagada, String estatus, int idProveedor, int idSucursal, int idEmpleado) {
        this.idPedido = idPedido;
        this.fechaRegistro = fechaRegistro;
        this.fechaRecepcion = fechaRecepcion;
        this.totalPagar = totalPagar;
        this.cantidadPagada = cantidadPagada;
        this.estatus = estatus;
        this.idProveedor = idProveedor;
        this.idSucursal = idSucursal;
        this.idEmpleado = idEmpleado;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(String fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    

    public Pedidos() {
    }
    
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public double getCantidadPagada() {
        return cantidadPagada;
    }

    public void setCantidadPagada(double cantidadPagada) {
        this.cantidadPagada = cantidadPagada;
    }

    

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
}
