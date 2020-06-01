package modelo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ConnectURL {
    public static Connection usu=null;
    private static String user; 
    private static String pwd;
    
    public ConnectURL(){
    }
    public ConnectURL(String usr,String pw){
            user = usr;
            pwd = pw;
            conectar();
    }
    public Connection getConexion(){
        return usu;
    }
    private Connection conectar(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usu;
    }
    public static boolean Login(String usr,String pw){
        Connection s;
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            s=DriverManager.getConnection(url,usr,pw);
        } catch (SQLException e) {
            s=null;
        }
        return s!=null;
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
            declara.execute(sql);
            desconectar();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
        }
        return null;
    }
}
