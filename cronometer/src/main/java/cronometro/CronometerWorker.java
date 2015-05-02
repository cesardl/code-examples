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
        return 0;
    }

    @Override
    protected void process(List<String> chunks) {
        for (final String chunk : chunks) {
            log.info(chunk);
        }
    }

}
