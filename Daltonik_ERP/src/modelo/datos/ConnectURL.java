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
    
    public ConnectURL(String usr,String pw){
            user = usr;
            pwd = pw;
    }
    private static Connection conectar(){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null,"Conexion no establecida ... \n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        return usu;
    }
    public static Connection Login(String usr,String pw){
        String url="jdbc:sqlserver://localhost:1433;databaseName=ERP2020";
        try {
            usu=DriverManager.getConnection(url,usr,pw);
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
            declara.execute(sql);
            desconectar();
        } catch (SQLException e) {
            System.out.println("Ejecucion fallida\n"
                    + "Conexion no establecida ... \n"+e.getMessage());
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
            System.out.println("Consulta fallida\n"
                    + "Conexion no establecida ... \n"+e.getMessage());
        }
        return null;
    }
}
