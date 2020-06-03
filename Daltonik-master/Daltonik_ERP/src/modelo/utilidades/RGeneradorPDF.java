/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.utilidades;


import modelo.datos.ConnectURL;
import java.util.HashMap;
import java.util.Map;
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
 private String outFileName;
    private JasperReport rp;
    private JasperViewer jv;
    private JasperPrint jp;
    

    public RGeneradorPDF(String usu, String pwd, int id) {
        cn = new ConnectURL(usu, pwd);
        this.id=id;
    }
  
  public void mostrarReporte(){
            jv=new JasperViewer(jp,false);
            jv.setTitle("Orden de compra "+id);
            jv.setVisible(true);
    }
    public void generarRP_PDF(){
        try{
//            File file=new File("src//modelo//reportes//RP.jasper");
            rp = (JasperReport) JRLoader.loadObjectFromFile("src//modelo//reportes//RP.jasper");
            Map parametro=new HashMap();
            parametro.put("pedido", id);
            jp=JasperFillManager.fillReport(rp, parametro,cn.getConexion());
        } catch (JRException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
  public void crearReporte(String n){
        outFileName = n;
        try {
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, outFileName);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.exportReport();
        } catch (JRException ex) {
            ex.printStackTrace();
            System.exit(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }
    }
