/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class Main {

    static final Logger log = LoggerFactory.getLogger(leer_excel.Main.class);

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
                if (file.getName().contains("doc")) {
                    AnalizadorWord analizador = new AnalizadorWord(file);
                    analizador.analizar();
                    log.info(analizador.toString());
                } else {
                    log.info("No se pudo procesar el archivo");
                }
            } else {
                log.info("No selecciono ningun");
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException | HeadlessException | IOException e) {
            log.error("Error al cargar el LookAndFeel", e);
        }

    }
}
