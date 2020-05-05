/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Nadia Cross
 */
public class ExistenciasSucursal {
    private int idPresentacion;
    private int idSucursal;
    private String cantidad;
   

    public ExistenciasSucursal(int idPresentacion, int idSucursal, String cantidad, String estatus) {
        this.idPresentacion = idPresentacion;
        this.idSucursal = idSucursal;
        this.cantidad = cantidad;
    }
    
    public ExistenciasSucursal() {
    }
 
    
    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
