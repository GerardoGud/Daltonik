/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.datos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.beans.Laboratorios;

public class LaboratoriosDAO {
    CallableStatement cts;
    static ResultSet r;
    ConnectURL cn;
    private final String user; 
    private final String pwd;
    
    public LaboratoriosDAO(String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
        cn = new ConnectURL(user, pwd);
    }
    public int cantPaginas(){
        int p=0,s=0;
        try {
            r = cn.consultar("Select count(*) from Laboratorios");
            while (r.next()) {
                p=r.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        if(p%5==0){
            s=(int)p/5;
            s--;
        }else{
            s=(int)p/5;
        }
        return s;
    }
    public DefaultTableModel cargarTabla(JTable tDatos, int reg) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Laboratorios where estatus = 'A' order by idLaboratorio offset ("+reg+"*5) rows fetch next 5 rows only");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
    public DefaultTableModel buscarId(JTable tDatos,int id) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Laboratorios where idLaboratorio="+id+";");
            while (r.next()) {
                Vector dato = new Vector();
                dato.add(r.getInt(1));
                dato.add(r.getString(2));
                dato.add(r.getString(3));
                dato.add(r.getString(4));
                tabla.addRow(dato);
                tDatos.setModel(tabla);
            }
            return tabla;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
    }
        public Laboratorios buscarIdEdicion(int id) {
        Laboratorios em=new Laboratorios();
        try {
            r = cn.consultar("select * from Laboratorios where idLaboratorio="+id+";");
            while (r.next()) {
                em.setIdLaboratorio(r.getInt(1));
                em.setNombre(r.getString(2));
                em.setOrigen(r.getString(3));
                em.setEstatus(r.getString(4));
            }
            return em;//jTable---jdatos
        } catch (Exception e) {
            return null;
        }
        }
        
    public void guardarLaboratorio(Laboratorios lab){
        try {
            cn.ejecutar("INSERT INTO Laboratorios VALUES ("+lab.getIdLaboratorio()+",'"+lab.getNombre()
                    +"','"+lab.getOrigen()+"','"+lab.getEstatus()+"');");
        } catch (Exception e) {
        }
    }
    
    public int UltimoID() {
		int idLaboratorioU = 1;
		String sql = "select max(idLaboratorio)+1 idLab from Laboratorios";
		try {
			cn.ejecutar(sql);
			if(r.next()) {
				idLaboratorioU=r.getInt("idLab");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idLaboratorioU;
	}
    public void editarLaboratorio(Laboratorios lab,int id){
        try {
            cn.ejecutar("update Laboratorios set origen='"+lab.getOrigen()+"', nombre='"+lab.getNombre()
                    +"',estatus='"+lab.getEstatus()+"' where idLaboratorio="+id+";");
        } catch (Exception e) {
        }
    }
    public void eliminarLaboratorio(int id){
        try {
            cn.ejecutar("update Laboratorios set estatus='I' where idLaboratorio="+id+";");
        } catch (Exception e) {
        }
    }
    
    
}
