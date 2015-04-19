package aplicacionreportes;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Cesardl
 */
public class ReporteAgenda {

    private static final Logger log = LoggerFactory.getLogger(ReporteAgenda.class);

    /**
     * URL de la base de datos.
     */
    private static final String url = "jdbc:mysql://localhost:3306/address_book";
    /**
     * Usuario de acceso a MySQL.
     */
    private static final String login = "root";
    /**
     * Password de usuario.
     */
    private static final String password = "root";
    /**
     * Conexion a la base de datos.
     */
    private Connection connection;

    public void abrir() {
        try {
            connection = DriverManager.getConnection(url, login, password);
            log.info("Conexion abierta");
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public void cerrar() {
        try {
            connection.close();
            log.info("Conexion cerrada");
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    public void runReporte(String contactId) {
        abrir();
        try {
            String master = "reportes/contactos_por_id.jasper";
            InputStream is = getClass().getClassLoader().getResourceAsStream(master);

            log.info("Master: {}", master);

            JasperReport masterReport = (JasperReport) JRLoader.loadObject(is);

            //este es el parámetro, se pueden agregar más parámetros
            //basta con poner mas parametro.put
            Map parametro = new HashMap();
            parametro.put("PARAMETRO_ID", contactId);
            log.info("PARAMETRO_ID: {}", parametro.get("PARAMETRO_ID"));

            //Reporte diseñado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport, parametro, connection);
            //Se lanza el Viewer de Jasper, no termina aplicación al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint, false);
            jviewer.setTitle("Reporte de Contactos");
            jviewer.setVisible(true);
        } catch (JRException jre) {
            log.error(jre.getMessage(), jre);
        }

        cerrar();
    }
}
