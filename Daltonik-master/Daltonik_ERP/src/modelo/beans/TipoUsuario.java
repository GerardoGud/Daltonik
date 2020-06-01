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
public class TipoUsuario {
    private int idTipoUsuario;
    private String nombre;
    private String estatus;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario, String nompre, String estatus) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nompre;
        this.estatus = estatus;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
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
