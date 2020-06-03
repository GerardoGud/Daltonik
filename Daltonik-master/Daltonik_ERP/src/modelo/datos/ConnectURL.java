package modelo.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;
import modelo.utilidades.Archivos;




public class ConnectURL {
    public static Connection usu=null;
    private static String user; 
    private static String pwd;
    private String url;
    
    public ConnectURL(){
        cadenaConex();
    }
    public ConnectURL(String usr,String pw){
            user = usr;
            pwd = pw;
            cadenaConex();
            conectar();
    }
    public Connection getConexion(){
        return usu;
    }
    private void cadenaConex(){
        Archivos arc=new Archivos();
        arc.setNombre("Conexion");
        arc.setExtencion(".DConex");
        arc.setArchivoRuta("C:\\Daltonik\\");
        Scanner n=arc.AbrirArc();
        url=n.nextLine();
    }
    private Connection conectar(){
        cadenaConex();
        try {
            usu=DriverManager.getConnection(url,user,pwd);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null,e.getMessage(),"Error de Conexion",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
        return usu;
    }
    public static boolean Login(String usr,String pw){
        Connection s;
        Archivos arc=new Archivos();
        arc.setNombre("Conexion");
        arc.setExtencion(".DConex");
        arc.setArchivoRuta("C:\\Daltonik\\");
        Scanner n=arc.AbrirArc();
        String url=n.nextLine();
        try {
            s=DriverManager.getConnection(url,usr,pw);
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null,e.getMessage(),"Error de Conexion",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
            s=null;
        }
        return s!=null;
    }
    public void desconectar(){
        try {
            usu.close();
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null,e.getMessage(),"Error de Conexion",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showConfirmDialog(null,e.getMessage(),"Error de Conexion",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showConfirmDialog(null,e.getMessage(),"Error de Conexion",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}
