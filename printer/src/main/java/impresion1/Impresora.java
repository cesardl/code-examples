/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impresion1;

/********************************************************************
 *	El siguiente programa es un ejemplo bastante sencillo de 		*
 *	impresión con JAVA. 											*
 ********************************************************************/
import java.awt.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/********************************************************************
 *	La siguiente clase llamada "Impresora", es la encargada de  	*
 *	establecer la fuente con que se va a imprimir, de obtener el	*
 *	trabajo de impresion, la página. En esta clase hay un método	*
 *	llamado imprimir, el cual recibe una cadena y la imprime.		*
 ********************************************************************/
class Impresora {

    static final Logger log = LoggerFactory.getLogger(Impresora.class);
    
    Font fuente = new Font("Dialog", Font.PLAIN, 10);
    PrintJob pj;
    Graphics pagina;

    /********************************************************************
     *	A continuación el constructor de la clase. Aquí lo único que	*
     *	hago es tomar un objeto de impresion.							*
     ********************************************************************/
    Impresora() {
        pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "Impresion desde Java", null);
    }

    /********************************************************************
     *	A continuación el método "imprimir(String)", el encargado de 	*
     *	colocar en el objeto gráfico la cadena que se le pasa como 		*
     *	parámetro y se imprime.											*
     ********************************************************************/
    public void imprimir(String Cadena) {
        //LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
        try {
            pagina = pj.getGraphics();
            pagina.setFont(fuente);
            pagina.setColor(Color.black);

            pagina.drawString(Cadena, 60, 60);

            pagina.dispose();
            pj.end();
        } catch (Exception e) {
            log.error("LA IMPRESION HA SIDO CANCELADA...", e);
        }
    }//FIN DEL PROCEDIMIENTO imprimir(String...)
}//FIN DE LA CLASE Impresora