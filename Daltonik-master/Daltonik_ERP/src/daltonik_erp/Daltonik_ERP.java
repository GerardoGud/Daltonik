/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonik_erp;

import config.daltoniksetup.Instalador;
import java.io.File;

/**
 *
 * @author LuisCerv
 */
public class Daltonik_ERP {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo = new File("C:\\Daltonik");
        if (archivo.exists()) {
            if (archivo.isDirectory()) {
                Login lg = new Login();
                lg.setVisible(true);
            }
        } else {
            Instalador i = new Instalador();
            i.setBounds(0, 0, 930, 590);
            i.setVisible(true);
        }
    }
}
