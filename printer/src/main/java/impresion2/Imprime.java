/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impresion2;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class Imprime {

    static final Logger log = LoggerFactory.getLogger(Imprime.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
         // Creamos un objeto de impresión.
         PrinterJob job = PrinterJob.getPrinterJob();

         // Hacemos imprimible el objeto ObjetoAImprimir
         job.setPrintable(new ObjetoAImprimir());
         //Pondrá algo tipo Información job: sun.awt.windows.WPrinterJob@4a5ab2
         log.info("Información job: " + job.toString());
         //Abre el cuadro de diálogo de la impresora, si queremos que imprima
         //directamente sin cuadro de diálogo quitamos el if...
         if (job.printDialog()) {
         //Imprime, llama a la función print del objeto a imprimir
         //en nuestro caso el Objeto ObjetoAImprimir
         try {
         job.print();
         } catch (PrinterException e) {
         log.error("Error de impresión", e);
         }
         }
         */
        /*
         //Cogemos el servicio de impresión por defecto (impresora por defecto)
         PrintService service = PrintServiceLookup.lookupDefaultPrintService();
         //Le decimos el tipo de datos que vamos a enviar a la impresora
         //Tipo: bytes Subtipo: autodetectado
         DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
         //Creamos un trabajo de impresión
         DocPrintJob pj = service.createPrintJob();
         //Nuestro trabajo de impresión envía una cadena de texto
         String ss = "Aquí lo que vamos a imprimir.";
         byte[] bytes;
         //Transformamos el texto a bytes que es lo que soporta la impresora
         bytes = ss.getBytes();
         //Creamos un documento (Como si fuese una hoja de Word para imprimir)
         Doc doc = new SimpleDoc(bytes, flavor, null);

         //Obligado coger la excepción PrintException
         try {
         //Mandamos a impremir el documento
         pj.print(doc, null);
         } catch (PrintException e) {
         log.error("Error al imprimir", e.getMessage());
         }
         */

        PrintService service = PrintServiceLookup.lookupDefaultPrintService();
        //Indicamos que lo que vamos a imprimir es un objeto imprimible
        DocFlavor flavor = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
        DocPrintJob pj = service.createPrintJob();
        //Creamos el documento a imprimir que contendrá el objeto
        Doc doc = new SimpleDoc(new ObjetoAImprimir(), flavor, null);

        try {
            pj.print(doc, null);
        } catch (PrintException e) {
            log.error("Error al imprimir", e);
        }
    }
}
