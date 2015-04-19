/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documento;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.poifs.eventfilesystem.POIFSReader;

/**
 *
 * @author Cesardl
 */
public class AnalizadorWord {

    private int numeroCaracteres;
    private int numeroPalabras;
    private int numeroPaginas;
    private String titulo;
    private String autor;
    private String comentarios;
    private String texto;
    private File fichero;

    public AnalizadorWord(File fichero) {
        this.fichero = fichero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public File getFichero() {
        return fichero;
    }

    public void setFichero(File fichero) {
        this.fichero = fichero;
    }

    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }

    public void setNumeroCaracteres(int numeroCaracteres) {
        this.numeroCaracteres = numeroCaracteres;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPalabras() {
        return numeroPalabras;
    }

    public void setNumeroPalabras(int numeroPalabras) {
        this.numeroPalabras = numeroPalabras;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void analizar() throws IOException {
        POIFSReader poifsr = new POIFSReader();
        // Registramos el listener para después analizar la información.
        StandardReaderListener stdReader = new StandardReaderListener();
        stdReader.setDatos(this);
        poifsr.registerListener(stdReader, "\005SummaryInformation");

        try (FileInputStream fis = new FileInputStream(fichero)) {
            // Forzamos la lectura del documento.
            poifsr.read(fis);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("");
        sb.append("\n TITULO DEL DOCUMENTO:");
        sb.append(titulo);
        sb.append("\n AUTOR DEL DOCUMENTO:");
        sb.append(autor);
        sb.append("\n COMENTARIOS DEL DOCUMENTO:");
        sb.append(comentarios);
        sb.append("\n NUMERO DE CARACTERES:");
        sb.append(numeroCaracteres);
        sb.append("\n NUMERO DE PALABRAS:");
        sb.append(numeroPalabras);
        sb.append("\n NUMERO DE PAGINAS:");
        sb.append(numeroPaginas);
        sb.append("\n ------ TEXTO --------");
        sb.append("\n");
        sb.append(getTexto());
        sb.append("\n ------ TEXTO --------");

        return new String(sb);
    }
}
