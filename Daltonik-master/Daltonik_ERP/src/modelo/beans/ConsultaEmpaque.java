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
public class ConsultaEmpaque {
    private String nombre;
    private int Id;

    public ConsultaEmpaque(String nombre, int Id) {
        this.nombre = nombre;
        this.Id = Id;
    }

    public ConsultaEmpaque() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
    
}
