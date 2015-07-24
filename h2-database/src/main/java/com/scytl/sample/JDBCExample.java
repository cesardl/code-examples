package com.scytl.sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cesardiaz
 */
public class JDBCExample {

    static final Logger log = LoggerFactory.getLogger(JDBCExample.class);

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";

    static final String DB_URL = "jdbc:h2:~/tmp/mytest";

    // Database credentials
    static final String USER = "sa";

    static final String PASS = "";

    enum Course {

        AGILE_WEB_DEVELOPMENT, ALGORITHMIC, ARTIFICIAL_INTELLIGENCE, DATABASE, DATA_MINING, GRAPHIC_DESIGN, MATHEMATICS, SOCIAL_INFORMATICS
    }

    public static void main(final String[] args) {
        URL url
                = JDBCExample.class.getClassLoader().getResource(
                        "prueba_arb.txt");

        File f;
        try {
            f = new File(url.toURI());
        } catch (URISyntaxException e) {
            f = new File(url.getPath());
        }

        // I will read chars using utf-8 encoding
        log.info("Connecting to a selected database...");
        try (Connection conn
                = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                BufferedReader in
                = new BufferedReader(new InputStreamReader(
                                new FileInputStream(f), "utf-8"));) {
            log.info("Connected database successfully...");

            // STEP 4: Execute a query
            log.info("Creating table in given database...");
            String sql
                    = "CREATE TABLE IF NOT EXISTS MYLOVELYSTUDENTS "
                    + "(studentid INTEGER not NULL, "
                    + " first VARCHAR(255), " + " last VARCHAR(255), "
                    + " age INTEGER, " + " course VARCHAR(255))";

            stmt.executeUpdate(sql);
            log.info("Created table in given database...");

            int studentId;
            int age;
            String name;
            while ((name = in.readLine()) != null) {
                studentId = randInt(1000, 9999);
                age = randInt(18, 35);
                Course course = randCourse();
                sql
                        = String
                        .format(
                                "INSERT INTO MYLOVELYSTUDENTS VALUES (%d, '%s', 'Ali',%d , '%s')",
                                studentId, name, age, course);

                stmt.executeUpdate(sql);

                log.info("Executing {}", sql);
            }

            sql = "SELECT * FROM MYLOVELYSTUDENTS";

            log.info("########################################");
            try (ResultSet rs = stmt.executeQuery(sql)) {
                int count = 0;
                while (rs.next()) {
                    // Retrieve by column name
                    studentId = rs.getInt(1);
                    String first = rs.getString(2);
                    String last = rs.getString(3);
                    age = rs.getInt(4);
                    String sCourse = rs.getString(5);

                    Object[] os = {
                        ++count, studentId, first, last, age, sCourse
                    };

                    // Display values
                    log.info("{}.- ID: {}, First: {}, Last: {}, Age: {}, Course: {}", os);
                }
            }
            log.info("########################################");
        } catch (SQLException | IOException e) {
            // Handle errors for JDBC and File reader
            log.error(e.getMessage(), e);
        } // end try

        log.info("Goodbye!");
    } // end main

    /**
     * Returns a pseudo-random number between min and max, inclusive. The
     * difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value. Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    private static int randInt(final int min, final int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;
        // log.warn("Random generated: {}", randomNum);
        return randomNum;
    }

    /**
     * @return
     */
    private static Course randCourse() {
        Course courses[] = Course.values();
        Course course = courses[randInt(0, courses.length - 1)];
        // log.warn("Course loaded: {}", course);
        return course;
    }

} // end JDBCExample
