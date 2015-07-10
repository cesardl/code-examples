package cronometro;

import javax.swing.JLabel;

/**
 *
 * @author cesardiaz
 */
public final class Cronometro implements java.awt.event.ActionListener {

    /**
     * Label where the messages will be written.
     */
    private final JLabel label;

    private int hora, minuto, segundo;
    private Mode mode;

    public Cronometro(JLabel label) {
        this.label = label;
        mode = Mode.ASCENDENTE;

        init();
    }

    public enum Mode {

        ASCENDENTE,
        DESCENDENTE

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        switch (mode) {
            case ASCENDENTE:
                ascendente();
                break;

            case DESCENDENTE:
                break;
        }
        label.setText(addZeroIfNeeded(hora) + " : " + addZeroIfNeeded(minuto) + " : " + addZeroIfNeeded(segundo));
    }

    public void ascendente() {
        segundo++;
        if (segundo == 60) {
            minuto++;
            segundo = 0;
        }
        if (minuto == 60) {
            hora++;
        }
    }

    public void descendente() {
//        int val = inicio;
//
//        if (segundo < 60) {
//            hora = 0;
//            minuto = 0;
//        } else {
//            while (segundo >= 60) {
//                segundo = segundo - 60;
//                minuto++;
//                if (minuto == 60) {
//                    hora++;
//                    minuto = 0;
//                }
//            }
//        }
//
//        while (val != -1) {
//            label.setText(hora + " : " + minuto + " : " + segundo);
//            if (hora >= 0) {
//                if (minuto >= 0) {
//                    if (segundo >= 0) {
//                        segundo--;
//                    }
//                    if (segundo == -1) {
//                        minuto--;
//                        segundo = 59;
//                    }
//                }
//                if (minuto == -1) {
//                    hora--;
//                    minuto = 59;
//                }
//            }
//            val--;
//        }
    }

    public void init() {
        hora = minuto = segundo = 0;
        label.setText("00 : 00 : 00");
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    private String addZeroIfNeeded(int i) {
        StringBuilder sb = new StringBuilder();

        if (i < 10) {
            sb.append(0);
        }
        sb.append(i);

        return sb.toString();
    }

}
