package cronometro;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class Cronometro extends Thread {

    private int inicio;
    private boolean estado;
    private JLabel etiqueta;

    public Cronometro(int inicio, boolean estado, JLabel etiqueta) {
        this.inicio = inicio;
        this.estado = estado;
        this.etiqueta = etiqueta;
    }

    @Override
    public void run() {
        modoSecuencia(estado);
    }

    public void modoSecuencia(boolean ascendente) {
        if (ascendente) {
            ascendente();
        } else {
            descendente();
        }
    }

    public void ascendente() {
        int hora = 0, minuto = 0, segundo = 0;
        try {
            while (estado) {
                Thread.sleep(100);
                etiqueta.setText(hora + " : " + minuto + " : " + segundo);
                segundo++;
                if (segundo == 60) {
                    minuto++;
                    segundo = 0;
                }
                if (minuto == 60) {
                    hora++;
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void descendente() {
        int hora = 0, minuto = 0, segundo = inicio;
        int val = inicio;
        try {
            if (segundo < 60) {
                hora = 0;
                minuto = 0;
            } else {
                while (segundo >= 60) {
                    segundo = segundo - 60;
                    minuto++;
                    if (minuto == 60) {
                        hora++;
                        minuto = 0;
                    }
                }
            }

            while (val != -1) {
                sleep(100);
                etiqueta.setText(hora + " : " + minuto + " : " + segundo);
                if (hora >= 0) {
                    if (minuto >= 0) {
                        if (segundo >= 0) {
                            segundo--;
                        }
                        if (segundo == -1) {
                            minuto--;
                            segundo = 59;
                        }
                    }
                    if (minuto == -1) {
                        hora--;
                        minuto = 59;
                    }
                }
                val--;
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
