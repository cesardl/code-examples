/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leer_excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author cesardl
 */
public class ExcelSheetReader_mejorado {

    static final Logger log = LoggerFactory.getLogger(ExcelSheetReader_mejorado.class);

    /**
     * This method is used to read the data's from an excel file.
     *
     * @param file - Name of the excel file.
     */
    public void readExcelFile(File file) {
        /**
         * Create a new instance for cellDataList
         */
        List cellDataList = new ArrayList();
        try {
            /**
             * Create a new instance for FileInputStream class
             */
            FileInputStream fileInputStream = new FileInputStream(file);
            /**
             * Create a new instance for POIFSFileSystem class
             */
            POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
             * Create a new instance for HSSFWorkBook Class
             */
            HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(0);
            /**
             * Iterate the rows and cells of the spreadsheet to get all the
             * datas.
             */
            Iterator rowIterator = hssfSheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator iterator = hssfRow.cellIterator();
                List<HSSFCell> cellTempList = new ArrayList<>();
                while (iterator.hasNext()) {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        /**
         * Call the printToConsole method to print the cell data in the console.
         */
        generateSQL(cellDataList, file.getParent() + File.separator);
    }

    /**
     * This method is used to print the cell data to the console.
     *
     * @param cellDataList - List of the data's in the spreadsheet.
     */
    private void generateSQL(List cellDataList, String path) {
        String salida = "";
        List<HSSFCell> premios_ids = (List) cellDataList.get(1);

        for (int i = 2; i < cellDataList.size(); i++) {
            List<HSSFCell> agencias = (List) cellDataList.get(i);

            int id_agencia = aInteger(agencias.get(0).toString());

            for (int j = 2; j < agencias.size() - 2; j++) {
                int cantidad = aInteger(agencias.get(j).toString());
                if (cantidad != 0) {
                    String sql = "insert into agencia_premio(cantidad, fecha_modificacion, id_agencia, id_premio) values "
                            + "(" + cantidad + ", getdate(), " + id_agencia + ", "
                            + aInteger(premios_ids.get(j).toString()) + ");\n";

                    salida = salida.concat(sql);
                }
            }
        }
        try (PrintWriter pw = new PrintWriter(path + "data.sql")) {
            pw.write(salida);
        } catch (IOException ioe) {
            log.error(ioe.getMessage(), ioe);
        }
    }

    private int aInteger(String string) {
        try {
            return (int) Double.parseDouble(string);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return 0;
        }
    }
}
