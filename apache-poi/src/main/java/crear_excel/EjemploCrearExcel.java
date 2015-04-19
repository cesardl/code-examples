/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crear_excel;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Ejemplo sencillo de cómo crear una hoja Excel con POI.
 * @author Cesardl
 */
public class EjemploCrearExcel {

    static final Logger log = LoggerFactory.getLogger(EjemploCrearExcel.class);
    
    /**
     * Crea una hoja Excel y la guarda.
     * @param args
     */
    public static void main(String[] args) {
        int[][] datos = {
            {25, 96, 325, 1, 422},
            {258, 741, 336},
            {88, 99, 33, 22},
            {23, 111, 299, 691, 21, 64}
        };

        // Se crea el libro
        HSSFWorkbook libro = new HSSFWorkbook();

        // Se crea una hoja dentro del libro
        HSSFSheet hoja = libro.createSheet();

        // Se crea una fila dentro de la hoja
        HSSFRow fila = hoja.createRow((short) 0);

        // Establecemos una fuente
        HSSFFont fuente = libro.createFont();
        fuente.setFontHeightInPoints((short) 11);
        fuente.setFontName(HSSFFont.FONT_ARIAL);
        fuente.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        // Luego creamos el objeto que se encargará de aplicar el estilo a la celda
        HSSFCellStyle estiloCelda = libro.createCellStyle();
        estiloCelda.setWrapText(true);
        estiloCelda.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);
        estiloCelda.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
        estiloCelda.setFont(fuente);

        // También, podemos establecer bordes...
        estiloCelda.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setBottomBorderColor((short) 8);
        estiloCelda.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setLeftBorderColor((short) 8);
        estiloCelda.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setRightBorderColor((short) 8);
        estiloCelda.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        estiloCelda.setTopBorderColor((short) 8);

        // Establecemos el tipo de sombreado de nuestra celda
        estiloCelda.setFillForegroundColor((short) 22);
        estiloCelda.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        // Se crea una celda dentro de la fila, aplicamos el estilo y definimos
        // el tipo de dato que contendrá la celda
        HSSFCell celda = fila.createCell((short) 0);
        celda.setCellStyle(estiloCelda);
        celda.setCellType(HSSFCell.CELL_TYPE_STRING);

        // Se crea el contenido de la celda y se mete en ella.
        HSSFRichTextString texto = new HSSFRichTextString("Primera Prueba de Excel");
        celda.setCellValue(texto);

        // Insertamos los valores de la matriz
        for (int i = 0; i < datos.length; i++) {
            fila = hoja.createRow(i + 1);
            for (int j = 0; j < datos[i].length; j++) {
                celda = fila.createCell(j);
                celda.setCellValue(datos[i][j]);
            }
        }

        // Se salva el libro
        String output = "target/libroJava.xls";
        try (FileOutputStream fos = new FileOutputStream(output)) {
            libro.write(fos);
            log.info("Excel file was created in {}", output);
        } catch (IOException ioe) {
            log.error(ioe.getMessage(), ioe);
        }
    }
}
