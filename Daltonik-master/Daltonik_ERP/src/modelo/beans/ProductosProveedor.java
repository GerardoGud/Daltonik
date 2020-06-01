/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Francisco Figueroa
 */
public class ProductosProveedor {

    private int idProveedor;
    private int idPresentacion;
    private int diasRetardo;
    private Double precioEstandar;
    private Double precioUltimaCompra;
    private int cantMinPedir;
    private int cantMaxPedir;
    private String estatus;
    
    public ProductosProveedor() {
    }

    public ProductosProveedor(int idProveedor,int idPresentacion,int diasRetardo,Double precioEstandar,Double precioUltimaCompra,int cantMinPedir,int cantMaxPedir, String estatus) {
        this.idProveedor = idProveedor;
        this.idPresentacion = idPresentacion;
        this.diasRetardo = diasRetardo;
        this.precioEstandar = precioEstandar;
        this.precioUltimaCompra = precioUltimaCompra;
        this.cantMinPedir = cantMaxPedir;
        this.cantMaxPedir = cantMaxPedir;
        this.estatus = estatus;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public int getDiasRetardo() {
        return diasRetardo;
    }

    public void setDiasRetardo(int diasRetardo) {
        this.diasRetardo = diasRetardo;
    }

    public Double getPrecioEstandar() {
        return precioEstandar;
    }

    public void setPrecioEstandar(Double precioEstandar) {
        this.precioEstandar = precioEstandar;
    }

    public Double getPrecioUltimaCompra() {
        return precioUltimaCompra;
    }

    public void setPrecioUltimaCompra(Double precioUltimaCompra) {
        this.precioUltimaCompra = precioUltimaCompra;
    }
    
    public int getCantMinPedir() {
        return cantMinPedir;
    }

    public void setCantMinPedir(int cantMinPedir) {
        this.cantMinPedir = cantMinPedir;
    }

    public int getCantMaxPedir() {
        return cantMaxPedir;
    }

    public void setCantMaxPedir(int cantMaxPedir) {
        this.cantMaxPedir = cantMaxPedir;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
