package daltonik_erp;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.datos.ConnectURL;
import modelo.RegPedido;
import modelo.datos.PedidosDAO;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
    private CellStyle tituloEstilo ;
    private CellStyle headerStyle ;
    private CellStyle datosEstilo ;
    private final String ruta;
    
    public Excel(String ruta) {
        this.ruta=ruta;
    }
    
    public void crearExcel() {
        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Pedidos");
        try {
            int imgIndex;
            try (InputStream is = new FileInputStream("src\\iconos\\dk.png")) {
                byte[] bytes = IOUtils.toByteArray(is);
                imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            }
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();

            ClientAnchor anchor = help.createClientAnchor();
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = draw.createPicture(anchor, imgIndex);
            pict.resize(2, 4);
            sheet.addMergedRegion(new CellRangeAddress(0, 3, 0, 1));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        tituloEstilo = book.createCellStyle();
        tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
        tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
        tituloEstilo.setBorderBottom(BorderStyle.THIN);
        tituloEstilo.setBorderLeft(BorderStyle.THIN);
        tituloEstilo.setBorderRight(BorderStyle.THIN);
        tituloEstilo.setBorderBottom(BorderStyle.THIN);
        Font fuenteTitulo = book.createFont();
        fuenteTitulo.setFontName("Arial");
        fuenteTitulo.setBold(true);
        fuenteTitulo.setFontHeightInPoints((short) 16);
        tituloEstilo.setFont(fuenteTitulo);
        Row filaTitulo = sheet.createRow(1);
        Cell celdaTitulo = filaTitulo.createCell(2);
        celdaTitulo.setCellStyle(tituloEstilo);
        celdaTitulo.setCellValue("Reporte de Pedidos");
        sheet.addMergedRegion(new CellRangeAddress(1, 2, 2, 8));
        String[] cabecera = new String[]{"idPedido", "Registro", "Recepcion", "Total", "Cantidad Pagada",
            "Estatus", "Proveedor", "Sucursal", "idEmpleado"};
        headerStyle = book.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);

        Font font = book.createFont();
        font.setFontName("Arial");
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());
        font.setFontHeightInPoints((short) 12);
        headerStyle.setFont(font);

            Row filaEncabezados = sheet.createRow(4);

            for (int i = 1; i < cabecera.length+1; i++) {
                Cell celdaEnzabezado = filaEncabezados.createCell(i);
                celdaEnzabezado.setCellStyle(headerStyle);
                celdaEnzabezado.setCellValue(cabecera[i-1]);
            }
        try {
            try (FileOutputStream fileout = new FileOutputStream(new File(ruta))) {
                book.write(fileout);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leer() throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File(ruta));

            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet sheet = wb.getSheetAt(0);

            int numFilas = sheet.getLastRowNum();

            for (int a = 0; a <= numFilas; a++) {
                Row fila = sheet.getRow(a);
                int numCols = fila.getLastCellNum();

                for (int b = 0; b < numCols; b++) {
                    Cell celda = fila.getCell(b);

                    switch (celda.getCellTypeEnum().toString()) {
                        case "NUMERIC":
                            System.out.print(celda.getNumericCellValue() + " ");
                            break;

                        case "STRING":
                            System.out.print(celda.getStringCellValue() + " ");
                            break;

                        case "FORMULA":
                            System.out.print(celda.getCellFormula() + " ");
                            break;
                    }

                }

                System.out.println("");

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cargar(String tabla) throws IOException, SQLException {

        ConnectURL con = new ConnectURL();
        PreparedStatement ps;

        try {
            try (Connection conn = con.getConexion()) {
                FileInputStream file = new FileInputStream(new File(ruta));
                
                XSSFWorkbook wb = new XSSFWorkbook(file);
                XSSFSheet sheet = wb.getSheetAt(0);
                
                int numFilas = sheet.getLastRowNum();
                
                for (int a = 1; a <= numFilas; a++) {
                    Row fila = sheet.getRow(a);
                    
                    ps = conn.prepareStatement("INSERT INTO  "+tabla+" VALUES(?,?,?,?)");
                    ps.setString(1, fila.getCell(0).getStringCellValue());
                    ps.setString(2, fila.getCell(1).getStringCellValue());
                    ps.setDouble(3, fila.getCell(2).getNumericCellValue());
                    ps.setDouble(4, fila.getCell(3).getNumericCellValue());
                    ps.execute();
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificar() throws IOException {
        try {
            XSSFWorkbook wb;
            try (FileInputStream file = new FileInputStream(new File(ruta))) {
                wb = new XSSFWorkbook(file);
                XSSFSheet sheet = wb.getSheetAt(0);
                PedidosDAO pd = new PedidosDAO("sa", "123");
                datosEstilo = wb.createCellStyle();
                datosEstilo.setBorderBottom(BorderStyle.THIN);
                datosEstilo.setBorderLeft(BorderStyle.THIN);
                datosEstilo.setBorderRight(BorderStyle.THIN);
                datosEstilo.setBorderBottom(BorderStyle.THIN);
                ArrayList<RegPedido> p = pd.Imprimir();
                double totalPagar=0;
                double cantidadPagada=0;
                for (int i = 0; i < p.size(); i++) {
                    XSSFRow fila = sheet.getRow(i+5);
                    
                    if (fila == null) {
                        fila = sheet.createRow(i+5);
                    }
                    
                    XSSFCell celda = fila.createCell(1);
                    if (celda == null) {
                        celda = fila.createCell(1);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getIdPedido());
                    celda = fila.createCell(2);
                    if (celda == null) {
                        celda = fila.createCell(2);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getFechaRegistro());
                    celda = fila.createCell(3);
                    if (celda == null) {
                        celda = fila.createCell(3);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getFechaRecepcion());
                    celda = fila.createCell(4);
                    if (celda == null) {
                        celda = fila.createCell(4);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getTotalPagar());
                    totalPagar+=p.get(i).getTotalPagar();
                    celda = fila.createCell(5);
                    if (celda == null) {
                        celda = fila.createCell(5);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getCantidadPagada());
                    cantidadPagada+=p.get(i).getCantidadPagada();
                    celda = fila.createCell(6);
                    if (celda == null) {
                        celda = fila.createCell(6);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getEstatus());
                    celda = fila.createCell(7);
                    if (celda == null) {
                        celda = fila.createCell(7);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getProveedor());
                    celda = fila.createCell(8);
                    if (celda == null) {
                        celda = fila.createCell(8);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getSucursal());
                    celda = fila.createCell(9);
                    if (celda == null) {
                        celda = fila.createCell(9);
                    }
                    celda.setCellStyle(datosEstilo);
                    celda.setCellValue(p.get(i).getIdEmpleado());
                    
                }   
                headerStyle = wb.createCellStyle();
                headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
                headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setBorderLeft(BorderStyle.THIN);
                headerStyle.setBorderRight(BorderStyle.THIN);
                headerStyle.setBorderBottom(BorderStyle.THIN);
                headerStyle.setAlignment(HorizontalAlignment.RIGHT);
                Font font = wb.createFont();
                font.setFontName("Arial");
                font.setBold(true);
                font.setColor(IndexedColors.WHITE.getIndex());
                font.setFontHeightInPoints((short) 12);
                headerStyle.setFont(font);
                XSSFRow fila = sheet.getRow(3);
                if (fila == null) {
                    fila = sheet.createRow(3);
                }
                XSSFCell celda = fila.createCell(12);
                if (celda == null) {
                    celda = fila.createCell(12);
                }   celda.setCellStyle(headerStyle);
                celda.setCellValue("Total pedidos");
                celda = fila.createCell(13);
                if (celda == null) {
                    celda = fila.createCell(13);
                }   celda.setCellStyle(datosEstilo);
                celda.setCellValue(totalPagar);
                fila = sheet.getRow(4);
                if (fila == null) {
                    fila = sheet.createRow(4);
                }
                celda = fila.createCell(12);
                if (celda == null) {
                    celda = fila.createCell(12);
                }   celda.setCellStyle(headerStyle);
                celda.setCellValue("Total pagado");
                celda = fila.createCell(13);
                if (celda == null) {
                    celda = fila.createCell(13);
                }   celda.setCellStyle(datosEstilo);
                celda.setCellValue(cantidadPagada);
                fila = sheet.getRow(5);
                if (fila == null) {
                    fila = sheet.createRow(5);
                }
                celda = fila.createCell(12);
                if (celda == null) {
                    celda = fila.createCell(12);
                }   celda.setCellStyle(headerStyle);
                celda.setCellValue("Total deuda");
                celda = fila.createCell(13);
                if (celda == null) {
                    celda = fila.createCell(13);
                }   celda.setCellStyle(datosEstilo);
                celda.setCellValue(totalPagar-cantidadPagada);
            }
            
            try (FileOutputStream output = new FileOutputStream(ruta)) {
                wb.write(output);
            }
            

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
