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
public class Empaque {
    private int idEmpaque;
    private String nombre;
    private double capacidad;
    private String estatus;
    private int idUnidad;

    public Empaque() {
    }

    public Empaque(int idEmpaque, String nombre, double capacidad, String estatus, int idUnidad) {
        this.idEmpaque = idEmpaque;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estatus = estatus;
        this.idUnidad = idUnidad;
    }

    public int getIdEmpaque() {
        return idEmpaque;
    }

    public void setIdEmpaque(int idEmpaque) {
        this.idEmpaque = idEmpaque;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }
    
    
    
    
}
