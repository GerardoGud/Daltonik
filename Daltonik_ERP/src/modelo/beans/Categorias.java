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
public class Categorias {

    private int idCategoria;
    private String nombre;
    private String estatus;

    public Categorias() {
    }

    public Categorias(int idCategorias, String nombre, String estatus) {
        this.idCategoria = idCategorias;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
