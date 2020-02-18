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

    public LaboratoriosDAO() {
        cn=new ConnectURL();
    }
    
    public DefaultTableModel cargarTabla(JTable tDatos) {
        DefaultTableModel tabla = (DefaultTableModel) tDatos.getModel();
        tabla.setRowCount(0);
        try {
            r = cn.consultar("select * from Laboratorios");
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
    
    
}
