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
public class Medida {
    private int idUnidad;
    private String nombre;
    private String siglas;
    private String estatus;

    public Medida(int idUnidad, String nombre, String siglas, String estatus) {
        this.idUnidad = idUnidad;
        this.nombre = nombre;
        this.siglas = siglas;
        this.estatus = estatus;
    }

    public Medida() {
    }

    public int getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(int idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
