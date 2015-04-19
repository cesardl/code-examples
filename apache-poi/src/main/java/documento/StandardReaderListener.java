/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hpsf.MarkUnsupportedException;
import org.apache.poi.hpsf.NoPropertySetStreamException;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderEvent;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class StandardReaderListener implements POIFSReaderListener {

    static final Logger log = LoggerFactory.getLogger(StandardReaderListener.class);

    private AnalizadorWord datos = null;

    public void setDatos(AnalizadorWord datos) {
        this.datos = datos;
    }

    @Override
    public void processPOIFSReaderEvent(POIFSReaderEvent event) {
        // Clase que almacena las características estándar de un documento.
        SummaryInformation si = null;

        try {
            si = (SummaryInformation) PropertySetFactory.create(event.getStream());
        } catch (NoPropertySetStreamException | MarkUnsupportedException | IOException ex) {
            throw new RuntimeException("Property set stream \""
                    + event.getPath() + event.getName() + "\": " + ex);
        }

        /* Recogemos los datos que nos interesan y los almacenamos en la clase AnalizadorWord.*/
        datos.setTitulo(si.getTitle());
        datos.setAutor(si.getAuthor());
        datos.setComentarios(si.getComments());
        datos.setNumeroCaracteres(si.getCharCount());
        datos.setNumeroPalabras(si.getWordCount());
        datos.setNumeroPaginas(si.getPageCount());

        /* Usamos la clase WordExtractor para obtener el texto del documento */
        try (FileInputStream fis = new FileInputStream(datos.getFichero())) {
            WordExtractor we = new WordExtractor(fis);
            datos.setTexto(we.getText());
        } catch (Exception e1) {
            log.error(e1.getMessage(), e1);
        }
    }
}
