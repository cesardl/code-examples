package csv;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author Cesardl
 */
public class AppTest {

    @Test
    public void readWithOutLibrary() {
        try {
            URL url = getClass().getClassLoader().getResource("pt-data1.csv");
            
            File f;
            try {
                f = new File(url.toURI());
            } catch (URISyntaxException e) {
                f = new File(url.getPath());
            }

            new PeriodicTable().readWithOutLibrary(f);

            assertTrue(true);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void readWithLibrary() {
        try {
            URL url = getClass().getClassLoader().getResource("pt-data1.csv");

            File f;
            try {
                f = new File(url.toURI());
            } catch (URISyntaxException e) {
                f = new File(url.getPath());
            }

            new PeriodicTable().readWithLibrary(f);

            assertTrue(true);
        } catch (IOException ex) {
            fail(ex.getMessage());
        }
    }

}
