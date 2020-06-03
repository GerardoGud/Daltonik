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
public class ImagenesProducto {
    private int idImagen;
    private String nombreImagen;
   private byte[] imagen;
    private String principal;
    private int idProducto;
    private String estatus;

    public ImagenesProducto(int idImagen, String nombreImagen, byte[] imagen, String principal, int idProducto, String estatus) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        this.imagen = imagen;
        this.principal = principal;
        this.idProducto = idProducto;
        this.estatus = estatus;
    }

    public ImagenesProducto() {
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
            
    
}
