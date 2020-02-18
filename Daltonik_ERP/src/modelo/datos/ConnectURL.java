package modelo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;




public class ConnectURL {
    public static Connection usu=null;
    public ConnectURL() {
    }

    
    public static Connection conectar(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,"sa","123");
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
        return usu;
    }
    public static Connection conectar(String user,String pwd){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Conexion no establecida ... \n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return usu;
    }
    public void desconectar(){
        try {
            usu.close();
        } catch (SQLException e) {
            System.out.println("No existia una conexion a SQL que cerrar");
        }
    }
    public void ejecutar(String sql){
        Connection con= conectar();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(sql);
            desconectar();
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
    }
    public ResultSet consultar(String sql){
        Connection con= conectar();
        Statement declara;
        try {
            declara=con.createStatement();
            ResultSet respuesta=declara.executeQuery(sql);
            return respuesta;
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
        }
        return null;
    }
}
