package cronometro;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class CronometerWorker extends SwingWorker<Integer, String> {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    static void failIfInterrupted() throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("Interrupted while processing");
        }
    }

    /**
     * TextArea where the messages will be written.
     */
    private final JLabel label;

    public CronometerWorker(JLabel label) {
        this.label = label;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        int hora = 0, minuto = 0, segundo = 0;
        try {
            for (;;) {
                failIfInterrupted();
                Thread.currentThread().sleep(100);
                publish(addZeroIfNeeded(hora) + " : " + addZeroIfNeeded(minuto) + " : " + addZeroIfNeeded(segundo));
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
            log.error(ex.getMessage(), ex);
        }
        return 0;
    }

    @Override
    protected void process(List<String> chunks) {
        for (final String chunk : chunks) {
            label.setText(chunk);
        }
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
