/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilidades;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.datos.ConnectURL;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
public class RGeneradorPDF {
 private ConnectURL cn;
 private int id;
	public RGeneradorPDF(String ruta) {
                 cn= new ConnectURL("sa","123");
                 System.setProperty("log4j.debug", "");
		java.util.Scanner teclado = new java.util.Scanner(System.in);
                Map parametro=new HashMap();
                parametro.put("pedido", 1);
		JasperReport reporte;
     try {
         reporte = (JasperReport) JRLoader.loadObject("src\\modelo\\reportes\\RP.jasper");
         JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, cn.getConexion());
         System.out.print("Ingrese la opcion... ");
		String opcion = teclado.next();

		if(opcion.equals("guardar")){
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(ruta));
			exporter.exportReport();
			System.out.println("Ya está guardado");
		}

		if(opcion.equals("ver")){
			JasperViewer viewer = new JasperViewer(jasperPrint);
			viewer.setTitle("Mi Rporte");
			viewer.setVisible(true);
			System.out.println("Ya está listo para ver");
		}
     } catch (JRException ex) {
         Logger.getLogger(RGeneradorPDF.class.getName()).log(Level.SEVERE, null, ex);
     }
		

		

		System.out.println("Aplicacion Finalizada");

	}//fin main
         

}
