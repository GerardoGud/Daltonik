/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daltonik_erp;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Cervantes
 */
public class Archivos{
private Scanner text;
private String archivoRuta; 
private String nombre;
private String extencion;

    public Archivos() {
    this.archivoRuta="";
    this.setExtencion(".Daltonik");
    }

    public String AbrirArc(String ruta){
        String code="";
        archivoRuta=ruta;
            File file = new File(archivoRuta);
            getnombre();
            try{
                text=new Scanner(file);
                while (text.hasNextLine()) {
                    code=code+text.nextLine()+"\n";
                }
                text.close();
            } catch (FileNotFoundException e) {
            } 
            return code;
    }
    public Scanner AbrirArc(){
            File file = new File(archivoRuta+nombre+extencion);
            getnombre();
            try{
                text=new Scanner(file);
            } catch (FileNotFoundException e) {
            } 
            return text;
    }
    public String AbrirFondo(){
        String code="";
            File file = new File(archivoRuta+nombre+extencion);
            try{
                text=new Scanner(file);
                code=text.nextLine();
                text.close();
            } catch (FileNotFoundException e) {
            } 
            return code;
    }
    public String AbrirArchivo(){
        String code="";
        JFileChooser dlgAbrir=new JFileChooser();
        dlgAbrir.addChoosableFileFilter(new FiltroIDE());
        dlgAbrir.setFileFilter(dlgAbrir.getChoosableFileFilters()[1]);
        int opcion=dlgAbrir.showOpenDialog(null);
        if(opcion==JFileChooser.APPROVE_OPTION){
            //Obtiene la ruta del fichero seleccionado
            AbrirArc(dlgAbrir.getSelectedFile().getAbsolutePath());
            
        }else{
            code="Operacion cancelada";
            JOptionPane.showMessageDialog(null, code);
        }
        return code;
    }
    
    public void GuardarArchivo(String codF){
        if(archivoRuta.equals("")){
            GuardarArchivoComo(codF);
        }else{
            File x;
            x=new File(archivoRuta+nombre+extencion);
            x.delete();
            guardar(codF);
            getnombre();
        }
    }
    public void GuardarArchivoComo(String codF){
        JFileChooser dlgGuardar=new JFileChooser();
        int opcion=dlgGuardar.showOpenDialog(null);
        dlgGuardar.setName("Guardar");
        String s;

        if(opcion==JFileChooser.APPROVE_OPTION){
            //Obtiene el nombredel fichero seleccionado
            s=dlgGuardar.getSelectedFile().getAbsolutePath()+extencion;
            this.archivoRuta=s;
            guardar(codF);
            getnombre();
        }
        else{
            codF="Operacion cancelada";
            JOptionPane.showMessageDialog(null, codF);
        }
    }
    private void getnombre(){
      if(archivoRuta.equals("")){
          nombre="Sin nombre";
      }else{
          StringTokenizer cortador=new StringTokenizer(archivoRuta,String.valueOf((char)92));
          while(cortador.hasMoreTokens()){
            nombre=cortador.nextToken();
          }
      }  
    }
    public String getPalabra(String txt){
        StringTokenizer cortador=new StringTokenizer(txt," ");
        return cortador.nextToken(); 
    }
    public void guardar(String codF){
        FileWriter arcEsc = null;
		try {
                    arcEsc = new FileWriter((archivoRuta+nombre+extencion), true);
			PrintWriter linEsc = new PrintWriter(arcEsc);
                        text = new Scanner(codF);
                        while (text.hasNextLine()) {
                            linEsc.println(text.nextLine());
                        }
                        text.close();
                        JOptionPane.showMessageDialog(null, "Se ha guardado con exito :)", "Atención", 2);
                        linEsc.close();
                        arcEsc.close();
                } catch (IOException e) {
			e.printStackTrace();
		} 
    }

    public String getNombre() {
        return nombre;
    }

    public void setArchivoRuta(String archivoRuta) {
        this.archivoRuta = archivoRuta;
    }

    public void setExtencion(String extencion) {
        this.extencion = extencion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExtencion() {
        return extencion;
    }
    
    
       private class FiltroIDE extends javax.swing.filechooser.FileFilter{

        @Override
        public boolean accept(File f) {
            if(f.isDirectory()) return true;
            String nombre=f.getName().toLowerCase();
            if(nombre!=null)
                if(nombre.endsWith(extencion))
                    return true;
            return false;
        }

        @Override
        public String getDescription() {
            return "Ficheros Daltonik";
        }

       }
    
}
