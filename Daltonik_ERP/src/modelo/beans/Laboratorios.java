/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

/**
 *
 * @author Rababau
 */
public class Laboratorios {
    private int idLaboratorio;
    private String nombre;
    private String origen;
    private char estatus;

    public Laboratorios(){
    
    }
    
    public Laboratorios(int idLaboratorio, String nombre, String origen, char estatus) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.origen = origen;
        this.estatus = estatus;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public char getEstatus() {
        return estatus;
    }

    public void setEstatus(char estatus) {
        this.estatus = estatus;
    }
}

