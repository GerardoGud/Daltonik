/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonik_erp;

import java.sql.SQLException;
import modelo.datos.ConnectURL;
/**
 *
 * @author LuisCerv
 */
public class Daltonik_ERP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
//        ConnectURL.conectar();
//        ConnectURL.desconectar();
        
        Login lg= new Login();
        lg.setVisible(true);
//    }
    
    }
}
