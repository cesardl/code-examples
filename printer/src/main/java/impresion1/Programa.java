/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package impresion1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class Programa extends JFrame {

    static final Logger log = LoggerFactory.getLogger(Programa.class);

    String cadena;
    JTextField campo;
    JButton imprimir;
    JLabel info;
    Impresora imp;
    JPanel principal = new JPanel(new BorderLayout());
    JPanel etiq = new JPanel(new FlowLayout());
    JPanel dos = new JPanel(new FlowLayout());

    //CONSTRUCTOR DE LA CLASE
    Programa() {
        super("Muestra Simple de Impresión en JAVA...");

        info = new JLabel("ESCRIBA ALGO EN EL CAMPO Y HAGA CLIC EN IMPRIMIR...");
        cadena = new String();
        campo = new JTextField(30);
        imprimir = new JButton("IMPRIMIR");

        dos.add(campo);
        dos.add(imprimir);
        etiq.add(info);

        campo.setToolTipText("ESCRIBA ALGO AQUÍ...");
        imprimir.setToolTipText("CLIC AQUI PARA IMPRIMIR...");

        principal.add(etiq, BorderLayout.NORTH);
        principal.add(dos, BorderLayout.CENTER);

        getContentPane().add(principal);

        //AJUSTO EL TAMAÑO DE LA VENTANA AL MINIMO
        pack();
        //NO PERMITO QUE PUEDAN CAMBIAR EL TAMAÑO DE LA VENTANA
        this.setResizable(false);

        //AHORA LA CENTRARÉ EN LA PANTALLA
        Dimension pantalla, cuadro;
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        cuadro = this.getSize();

        this.setLocation(((pantalla.width - cuadro.width) / 2),
                (pantalla.height - cuadro.height) / 2);


        //LE AGREGAMOS EL EVENTO AL BOTON "imprimir"

        imprimir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                cadena = "";
                cadena = String.valueOf(campo.getText());
                if (!cadena.equals("")) {
                    imp = new Impresora();
                    imp.imprimir(cadena);
                } else {
                    log.info("NO SE IMPRIME NADA EN BLANCO...");
                }

                campo.requestFocus();
                campo.select(0, cadena.length());
            }
        });



    }//FIN DEL CONSTRUCTOR

    public static void main(String[] jm) {
        Programa p = new Programa();
        p.show();

        p.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
    }//FIN DEL MAIN
}
