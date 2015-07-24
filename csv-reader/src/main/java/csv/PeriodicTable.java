package csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This file contains the following information on each row:
 * <ul>
 * <li>atomic number</li>
 * <li>symbol</li>
 * <li>name</li>
 * <li>atomic mass in au or g/mol</li>
 * <li>CPK color in RRGGBB hex format</li>
 * <li>electronic configuration</li>
 * <li>electronegativity in Pauling </li>
 * <li>atomic radius in pm</li>
 * <li>ion radius in pm </li>
 * <li>van der Waals radius in pm</li>
 * <li>IE-1 in kJ/mol</li>
 * <li>EA in kJ/mol</li>
 * <li>oxidation states</li>
 * <li>standard state</li>
 * <li>bonding type</li>
 * <li>melting point in K</li>
 * <li>boiling point in K</li>
 * <li>density in g/mL</li>
 * <li>metal or nonmetal?</li>
 * <li>year discovered</li>
 * </ul>
 *
 * @author Cesardl
 *
 * @see
 * <a href="http://php.scripts.psu.edu/djh300/cmpsc221/p3s11-pt-data.htm">Periodic
 * Table Data Files</a>
 */
public class PeriodicTable {

    static final Logger log = LoggerFactory.getLogger(PeriodicTable.class);

    static final int size = 20;

    public void readWithOutLibrary(File file) throws IOException {
        log.info("Read file from {}", file);

        Scanner sc = new Scanner(new FileReader(file));
        ArrayList<Element> ar1 = new ArrayList<>();
        String line;
        String[] parts;
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            parts = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            if (parts.length > size) {
                log.warn("The line have {} elements, omitting this", parts.length);
            }

            String chemicalName = parts[2].trim();
            String symbol = parts[1].trim();
            String atomNum = parts[0].trim();
            String atomWeight = parts[3].trim();
            String boilPoint = parts[15].trim();
            String meltPoint = parts[16].trim();
            String density = parts[17].trim();

            Element.Builder builder = new Element.Builder(chemicalName, symbol, atomNum)
                    .atomWeight(atomWeight)
                    .boilPoint(boilPoint)
                    .meltPoint(meltPoint)
                    .density(density);

            Element e = builder.build();
            ar1.add(e);

            log.info("{}", e);

        }

        log.info("Total {}", ar1.size());
    }

    public void readWithLibrary(File file) throws IOException {
        log.info("Read file from {}", file);

        CSVParser parser = CSVParser.parse(file, Charset.forName("UTF-8"), CSVFormat.newFormat(','));
        for (CSVRecord csvRecord : parser) {
            if (csvRecord.size() > size) {
                log.warn("The line have {} elements, omitting this", csvRecord.size());
            }
        }
    }

}
