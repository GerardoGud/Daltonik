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
public class CuentasProveedor {

    private int idCuentaProveedor;
    private int idProveedor;
    private String noCuenta;
    private String Banco;
    private String estatus;

    public CuentasProveedor() {
    }

    public CuentasProveedor(int idCuentaProveedor, int idProveedor, String noCuenta, String Banco, String estatus) {
        this.idCuentaProveedor = idCuentaProveedor;
        this.idProveedor = idProveedor;
        this.noCuenta = noCuenta;
        this.Banco = Banco;
        this.estatus = estatus;
    }

    public int getIdCuentaProveedor() {
        return idCuentaProveedor;
    }

    public void setIdCuentaProveedor(int idCuentaProveedor) {
        this.idCuentaProveedor = idCuentaProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNoCuenta() {
        return noCuenta;
    }

    public void setNoCuenta(String noCuenta) {
        this.noCuenta = noCuenta;
    }

    public String getBanco() {
        return Banco;
    }

    public void setBanco(String Banco) {
        this.Banco = Banco;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
   
}
