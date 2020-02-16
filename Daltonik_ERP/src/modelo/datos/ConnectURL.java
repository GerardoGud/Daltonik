package modelo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ConnectURL {
    public static Connection usu=null;
    public ConnectURL() {
    }

    
    public static Connection conectar(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,"sa","123");
            System.out.println("Ya quedo carnal");
        } catch (SQLException e) {
            System.out.println("Conexion no establecida ... \n"+e.getMessage());
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
    public ResultSet ejecutar(String sql){
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
