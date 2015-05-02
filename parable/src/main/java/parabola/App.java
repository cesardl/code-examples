package parabola;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            javax.swing.SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    new FrameParabola().setVisible(true);
                }
            });
        } catch (ClassNotFoundException e) {
            log.error("Error with class", e);
        } catch (InstantiationException e) {
            log.error("Error while instantiation", e);
        } catch (IllegalAccessException e) {
            log.error("Error illegal access", e);
        } catch (UnsupportedLookAndFeelException e) {
            log.error("Error loading look and feel", e);
        }
    }
}
