/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leer_excel;

import java.awt.HeadlessException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.swing.JFileChooser;

/**
 *
 * @author cesardl
 */
public class Main {

    static final Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFileChooser chooser = new JFileChooser();

            int i = chooser.showOpenDialog(null);
            if (i == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (file.getName().contains("xls")) {
                    new ExcelSheetReader().readExcelFile(file);
                } else {
                    log.info("No se pudo procesar el archivo");
                }
            } else {
                log.info("No selecciono ningun");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | HeadlessException e) {
            log.error("Error al cargar el LookAndFeel", e);
        }
    }
}
