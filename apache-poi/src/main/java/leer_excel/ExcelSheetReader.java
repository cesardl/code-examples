/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leer_excel;

import crear_excel.EjemploCrearExcel;
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
public class ExcelSheetReader {

    static final Logger log = LoggerFactory.getLogger(ExcelSheetReader.class);

    /**
     * This method is used to read the data's from an excel file.
     *
     * @param file - Name of the excel file.
     */
    public void readExcelFile(File file) {
        /**
         * Create a new instance for cellDataList
         */
        List<List<HSSFCell>> cellDataList = new ArrayList<>();
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
            e.printStackTrace();
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
    private void generateSQL(List<List<HSSFCell>> cellDataList, String path) {
        String salida = "";
        for (int i = 1; i < cellDataList.size(); i++) {
            List<HSSFCell> cellTempList = cellDataList.get(i);

            HSSFCell hssfCell = cellTempList.get(0);
            int id = aInteger(hssfCell.toString());

            String sql = "insert into premio(id_premio, descripcion, stock_base, stock, url_imagen, id_tipo_premio) values "
                    + "(" + id + ", '";

            hssfCell = cellTempList.get(1);
            String descripcion = hssfCell.toString();
            sql = sql + descripcion.trim() + "', ";

            hssfCell = cellTempList.get(2);
            int stock_base = aInteger(hssfCell.toString());
            sql = sql + stock_base + ", ";

            hssfCell = cellTempList.get(4);
            int stock = aInteger(hssfCell.toString());
            sql = sql + stock + ", '', ";

            hssfCell = cellTempList.get(5);
            int tipo_premio = aInteger(hssfCell.toString());
            sql = sql + tipo_premio;

            salida = salida.concat(sql).concat(");\n");
        }
        try (PrintWriter pw = new PrintWriter(path + "data_premio.sql")) {
            pw.write(salida);
        } catch (IOException ioe) {
            log.error(ioe.getMessage(), ioe);
        }
    }

    private int aInteger(String string) {
        return (int) Double.parseDouble(string);
    }
}
