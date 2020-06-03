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
public class RegistroCompra {
    private int idPresentacion;
    private String nombre;
    private String empaque;
    private double capacidad;
    private String siglas;
    private double precio;   
    public RegistroCompra() {
    }

    public RegistroCompra(int idPresentacion, String nombre, String empaque, double capacidad, String siglas, double precio) {
        this.idPresentacion = idPresentacion;
        this.nombre = nombre;
        this.empaque = empaque;
        this.capacidad = capacidad;
        this.siglas = siglas;
        this.precio = precio;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpaque() {
        return empaque;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
