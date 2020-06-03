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
public class ContactosProveedor {
    private int idContacto;
    private String nombre;
    private String telefono;
    private String email;
    private int idProveedor;
    private String estatus;

    public ContactosProveedor(int idContacto, String nombre, String telefono, String email, int idProveedor, String estatus) {
        this.idContacto = idContacto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.idProveedor = idProveedor;
        this.estatus = estatus;
    }

    public ContactosProveedor() {
        
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
}
