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
public class Productos {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private int puntoReorden;
    private double precioCompra;
    private double precioVenta;
    private String ingredienteActivo;
    private String bandaToxicologica;
    private String aplicacion;
    private String uso;
    private String estatus;
    private int idLaboratorio;
    private int idCategoria;

    public Productos() {
    }

    public Productos(int idProducto, String nombre, String descripcion, int puntoReorden, double precioCompra, double precioVenta, String ingredienteActivo, String bandaToxicologica, String aplicacion, String uso, String estatus, int idLaboratorio, int idCategoria) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntoReorden = puntoReorden;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.ingredienteActivo = ingredienteActivo;
        this.bandaToxicologica = bandaToxicologica;
        this.aplicacion = aplicacion;
        this.uso = uso;
        this.estatus = estatus;
        this.idLaboratorio = idLaboratorio;
        this.idCategoria = idCategoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntoReorden() {
        return puntoReorden;
    }

    public void setPuntoReorden(int puntoReorden) {
        this.puntoReorden = puntoReorden;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getIngredienteActivo() {
        return ingredienteActivo;
    }

    public void setIngredienteActivo(String ingredienteActivo) {
        this.ingredienteActivo = ingredienteActivo;
    }

    public String getBandaToxicologica() {
        return bandaToxicologica;
    }

    public void setBandaToxicologica(String bandaToxicologica) {
        this.bandaToxicologica = bandaToxicologica;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    
}
